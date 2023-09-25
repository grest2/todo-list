package app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_list.R
import com.example.todo_list.databinding.ActivityMainBinding
import models.ItemRepository
import models.todo.TodoItem
import models.todo.TodoProgress
import presentation.adapters.TodoRecyclerAdapter
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoRecyclerAdapter
    private val todoRepository: ItemRepository<TodoItem> = ItemRepository<TodoItem>(
        arrayOf(
            TodoItem(UUID.randomUUID().toString(),
                "Подготовиться к курсам",
                "Курсы по программированию\nдля андроид SDK",
                TodoProgress.DONE
            ),
            TodoItem(UUID.randomUUID().toString(),
            "Записаться в музыкальную школу",
            "Записаться на новый урок\nв музыкальную школу",
            TodoProgress.IN_PROGRESS
            ),
            TodoItem(UUID.randomUUID().toString(),
            "Сделать уборку",
            "Убраться в квартире:\nсделать полную уборку",
            TodoProgress.PENDING
            )
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.setBackgroundColor(Color.rgb(232,234,237))
        val manager = LinearLayoutManager(this)
        todoAdapter = TodoRecyclerAdapter(todoRepository.items, this)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = todoAdapter
    }
}