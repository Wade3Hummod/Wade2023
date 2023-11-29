package com.example.wade2023.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.wade2023.data.SubjectTable.MySubject;
import com.example.wade2023.data.SubjectTable.MySubjectQuery;
import com.example.wade2023.data.myTasksTable.MyTask;
import com.example.wade2023.data.myTasksTable.MyTaskQuery;
import com.example.wade2023.data.usersTable.MyUser;
import com.example.wade2023.data.usersTable.MyUserQuery;

/*
تعريف الجداول ورقم النسخة
version
عند تغير اي شيء يخص جدول او جداول علينا تغيير رقم الاصدار ليتم بناء قاعدة البيانات من جديد
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class},version = 2)
/**
 * الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 * وتوفر لنا كائن لتعامل مع قاعدة البناء
 */
public abstract class AppDatabase extends RoomDatabase
{
    /**
     * كائن للتعامل مع قاعدة البيانات
     */
    private static AppDatabase db;

    /**
     * يعيد كائن لعمليات جدول المستعملين
     * @return
     */
    public abstract MyUserQuery getMyUserQuery();

    /**
     * يعيد كائن لعمليات جدول الموضيع
     * @return
     */
    public abstract MySubjectQuery getMySubjectQuery();

    /**
     *يعيد كائن لعمليات جدول المهمات
     * @return
     */
    public abstract MyTaskQuery getMyTaskQuery();

    /**
     * بناء قاعدة البيانات واعادة كائن يؤشر عليها
     * @param context
     * @return
     */

    public static AppDatabase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                            AppDatabase.class, "database-name")//اسم قاعدة البيانات
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()

                    .build();
        }
        return db;
    }
}