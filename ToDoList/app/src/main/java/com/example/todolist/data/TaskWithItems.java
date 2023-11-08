package com.example.todolist.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class TaskWithItems {

    @Embedded
    public Task task;

    @Relation(
            parentColumn = "id",
            entityColumn = "task_id"
    )
    public List<TaskItem> taskItems;

}
