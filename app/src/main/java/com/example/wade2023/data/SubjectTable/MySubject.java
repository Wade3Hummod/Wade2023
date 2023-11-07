package com.example.wade2023.data.SubjectTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity public class MySubject {
    @PrimaryKey(autoGenerate = true)
    public long keyid;
    public String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;

    }
}
