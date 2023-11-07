package com.example.todolist.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// https://developer.android.com/training/data-storage/room/relationships?hl=es-419
@Entity(tableName = "taskItemTabla")
public class TaskItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "task_id")
    private int taskId;  // Esta columna almacena el ID de la tarea a la que está relacionado este elemento

    @ColumnInfo(name = "item_description")
    private String itemDescription;

    public TaskItem(int id, int taskId, String itemDescription) {
        this.id = id;
        this.taskId = taskId;
        this.itemDescription = itemDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

}