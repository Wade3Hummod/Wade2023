package com.example.wade2023.data.myTasksTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

public  class MyTask
{
    @PrimaryKey(autoGenerate = true)
    public long keyid;//رقم المهمه
    @ColumnInfo(name = "textTasks")// اعطاء اسم جديد للعامود- الصفة في الجدول
    public String text;//نص المهمات
    public int importance;//درجه الاهمية 1-5
    public long subjid;//رقم موضوع المهمة
    public long userid;//رقم مستعمل الذي اضاف المهمه
    public long time;// وقت انتاج المهمه
    public String Shorttitle;
    public boolean isCompleted ; // هل تمت المهمة

    public long getKeyid() {
        return keyid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public long getSubjid() {
        return subjid;
    }

    public void setSubjid(long subjid) {
        this.subjid = subjid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getShorttitle()
    {
        return Shorttitle;
    }

    public void setShorttitle(String shorttitle) {
        Shorttitle = shorttitle;
    }

    @Override
    public String toString() {
        return "MyTasks{" +
                "keyid=" + keyid +
                ", text='" + text + '\'' +
                ", importance=" + importance +
                ", subjid=" + subjid +
                ", userid=" + userid +
                ", time=" + time +
                ", Shorttitle='" + Shorttitle + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }

}