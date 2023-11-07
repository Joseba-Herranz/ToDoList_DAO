package com.example.todolist.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getDatabase(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public LiveData<TaskWithItems> getTaskWithItems(int taskId) {
        return taskDao.getTaskWithItems(taskId);
    }

    public void insert(Task task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.insert(task);
        });
    }
}
