package com.example.todolist.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);

//    @Update
//    void update(Task task);
//
//    @Delete
//    void delete(Task task);

    @Query("SELECT * FROM taskTabla")
    LiveData<List<Task>> getAllTasks();

    @Transaction
    @Query("SELECT * FROM taskTabla WHERE id = :taskId")
    LiveData<TaskWithItems> getTaskWithItems(int taskId);


}