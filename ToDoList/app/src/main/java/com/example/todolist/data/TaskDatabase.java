package com.example.todolist.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Task.class, TaskItem.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {
    private static final int NUMBER_OF_THREADS = 4;

    public static Executor databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public abstract TaskDao taskDao();

    private static TaskDatabase INSTANCE;

    public static TaskDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, "task_database")
                    .build();
        }
        return INSTANCE;
    }
}