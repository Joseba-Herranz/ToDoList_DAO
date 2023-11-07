package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.todolist.data.Task;
import com.example.todolist.data.TaskAdapter;
import com.example.todolist.data.TaskViewModel;

public class MainActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;
    private TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        EditText editTextTask = findViewById(R.id.editTextTask);
        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        RecyclerView recyclerViewTasks = findViewById(R.id.recyclerViewTasks);

        taskAdapter = new TaskAdapter();
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);

        taskViewModel.getAllTasks().observe(this, tasks -> {
            taskAdapter.setTasks(tasks);
        });

        buttonAddTask.setOnClickListener(v -> {
            String description = editTextTask.getText().toString().trim();
            if (!description.isEmpty()) {
                Task task = new Task();
                task.setDescription(description);
                taskViewModel.insert(task);
                editTextTask.setText("");
            }
        });
    }
}