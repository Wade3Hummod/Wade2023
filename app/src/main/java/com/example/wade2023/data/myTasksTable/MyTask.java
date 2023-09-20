package com.example.wade2023.data.myTasksTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
/**
*فئة تمثل مهمة
*/
@Entity

public class MyTask
{
    @PrimaryKey(autoGenerate = true)
    /**
     * رقم المهمة
     */
    public Long keyId;
    /**
     * درجة الاهمية 5-1
     */
    public int importance;
    /**
     * نص المهمة
     */
    public String text;
    /**
     * زمن بناء المهمة
     */
    public long time;
    /**
     * رقم موضوع المهمة
     */
    public long subjId;
    /**
     * رقم المستعمل الذي اضافا المهمة
     */
    long userId;

}
