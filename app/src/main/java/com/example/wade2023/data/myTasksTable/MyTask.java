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
     * هل تمت المهمة
     */
    public boolean isCompleted;
    /**
     * رقم موضوع المهمة
     */
    public long subjId;
    /**
     * رقم المستعمل الذي اضافا المهمة
     */
    long userId;

    @Override
    public String toString() {
        return "MyTask{" +
                "keyId=" + keyId +
                ", importance=" + importance +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjId=" + subjId +
                ", userId=" + userId +
                '}';
    }
}
