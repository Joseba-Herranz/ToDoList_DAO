package com.example.todolist.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "taskTabla")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo (name = "task")
    private String description;

    public Task() {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}