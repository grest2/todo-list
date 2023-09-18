package presentation

import models.todo.TodoItem

sealed class CellUiModel {

    object Header: CellUiModel()
    object Footer: CellUiModel()

    class TodoModel(val todoItem: TodoItem): CellUiModel()
}