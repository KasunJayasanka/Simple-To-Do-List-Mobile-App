package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toDoAdapter:ToDoAdapter
    private lateinit var rvToDoItems:RecyclerView
    private lateinit var btnAddToDo:Button
    private lateinit var btnDeleteDoneToDos:Button
    private lateinit var etToDoTitle:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter =ToDoAdapter(mutableListOf())

        rvToDoItems=findViewById(R.id.rvToDoItems)
        btnAddToDo=findViewById(R.id.btnAddToDo)
        btnDeleteDoneToDos=findViewById(R.id.btnDeleteDoneToDos)
        etToDoTitle=findViewById(R.id.etToDoTitle)

        rvToDoItems.adapter=toDoAdapter
        rvToDoItems.layoutManager=LinearLayoutManager(this)


        btnAddToDo.setOnClickListener {
            val toDoTitle=etToDoTitle.text.toString()
            if(toDoTitle.isNotEmpty()){
                val toDo=ToDo(toDoTitle)
                toDoAdapter.addToDo(toDo)
                etToDoTitle.text.clear()
            }
        }

        btnDeleteDoneToDos.setOnClickListener {
            toDoAdapter.deleteDoneToDos()
        }
    }
}



