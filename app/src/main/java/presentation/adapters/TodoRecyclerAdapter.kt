package presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import models.todo.TodoItem

class TodoRecyclerAdapter(private var list: Array<TodoItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}