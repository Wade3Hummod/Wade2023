package com.example.wade2023.data.myTasksTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao//واجهة استعملات على جدول معطيات

public interface MyTaskQuery
{
    /**
     * اعادة جميع معطيات جدول المهمات
     * @return
     */
    @Query("SELECT*FROM MyTask")

    list<MyTask> getAllTasks();

    /**
     * استخراج المهمات حسب المستعمل وهل انتهت ام لا وهل مرتبة حسب الاهمية
     * @param userid_p
     * @param isComplted_p
     * @return
     */
    @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted =:isComplted_p"
            "ORDER BY importance DESC")
    List<MyTask> getAllTaskOrderBy(long userid_p,boolean isComplted_p);

    /**
     * ادخال مهمات
     * @param t مجموعة مهمات *
     */
    @Insert
    void insertTask(MyTask...t);//ثلاثة نقلط تعني مجموعه

    /**
     * تعديل المهمات
     * @param tasks مجموعة مهمات للتعديل(التعديل حسب المفتاح الرئيسي)
     * @return
     */
    @Update
    Void updateTask(MyTask...tasks);

    /**
     * حذف مهمة او مهمات
     * @param tasks حذف المهمات(حسب المفتاح الرئيسي)
     */

    @Delete
    void deleteTask(MyTask...tasks);

    @Query("DELETE FROM MyTask WHERE KeyId=:kid")
    void delTask(long kid);
}
