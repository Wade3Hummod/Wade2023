package com.example.wade2023.data.SubjectTable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wade2023.data.usersTable.MyUser;

import java.util.List;


/**
 * واجهه تحوي عمليات /دوال/استعمالات على قاعدة البايانات
 */
@Dao//لتحديد ان الواجهه تحوي استعلامات على قاعدة بيانات
public interface MySubjectQuery {


    @Query("SELECT * FROM MyUser")
    List<MySubject> getAll();
    @Insert
    void insertAll(MySubject... users);

        @Query("SELECT * FROM MySubject WHERE Title = :mySubject")
    MySubject checkSubject(String mySubject);

    @Delete
    void delete(MySubject user);

    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(MySubject myUser);

    @Update
    void update(MySubject... values);
}