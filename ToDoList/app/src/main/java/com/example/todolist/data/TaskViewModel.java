package com.example.todolist.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<Task>> allTasks;

    public TaskViewModel(Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public LiveData<TaskWithItems> getTaskItemsForTask(int taskId) {
        return repository.getTaskWithItems(taskId);
    }


    public void insert(Task task) {
        repository.insert(task);
    }
}