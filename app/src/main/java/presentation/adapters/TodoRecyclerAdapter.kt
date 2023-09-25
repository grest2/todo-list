package presentation.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import models.todo.TodoItem
import models.todo.TodoProgress

class TodoRecyclerAdapter(private var list: Array<TodoItem>, private val context: Context): RecyclerView.Adapter<TodoRecyclerAdapter.TodoItemListViewHolder>() {

    class TodoItemListViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {

        data class Model(

            val icon: Drawable?,
            val title: String,
            val subtitle: String
        )

        private val iconView: ImageView = binding.findViewById(R.id.iconTodo)
        private val titleView: TextView = binding.findViewById(R.id.todoTitleTextView)
        private val subtitleView: TextView = binding.findViewById(R.id.todoSubtitleTextView)

        fun configure(model: Model) {
            titleView.text = model.title
            subtitleView.text = model.subtitle
            iconView.setImageDrawable(model.icon)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return TodoItemListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoItemListViewHolder, position: Int) {
        val item = list[position]
        val icon: Drawable?
        when (item.progress) {
            TodoProgress.DONE -> icon = ResourcesCompat.getDrawable(context.resources, R.drawable.done_icon, null)
            TodoProgress.PENDING -> icon = ResourcesCompat.getDrawable(context.resources, R.drawable.postponed, null)
            TodoProgress.IN_PROGRESS -> icon = ResourcesCompat.getDrawable(context.resources, R.drawable.todo_icon, null)
        }

        val model = TodoItemListViewHolder.Model(icon, item.title, item.description)
        holder.configure(model)
    }
}