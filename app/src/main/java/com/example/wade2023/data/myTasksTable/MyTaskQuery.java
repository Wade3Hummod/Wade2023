package com.example.wade2023.data.myTasksTable;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao//واجهة استعملات على جدول معطيات

public interface MyTaskQuery
{
    @Query("SELECT*FROM MyTask")
    list
}
