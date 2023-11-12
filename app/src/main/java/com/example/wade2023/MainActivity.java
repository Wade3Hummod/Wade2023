package com.example.wade2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wade2023.data.AppDatabase;
import com.example.wade2023.data.SubjectTable.MySubject;
import com.example.wade2023.data.SubjectTable.MySubjectQuery;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private FloatingActionButton fabAdd;
    private SearchView srhV;
    private Spinner spnrSubject;
    private ListView lstvTasks;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd=findViewById(R.id.fabAdd);
        srhV=findViewById(R.id.srhV);
        spnrSubject=findViewById(R.id.spnrSubject);
        lstvTasks=findViewById(R.id.lstvTasks);





        Log.d("WH", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        //بناء قاعدة بيانات وارجاع مؤشر عليها 1
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        // مؤشر لكائن عمليات لجدول 2
        MySubjectQuery SubjectQuery=db.getMySubjectQuery();
        //3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2=new MySubject();
        s2.Title="Computers";
        //4 اضافة كائن للجدول
        SubjectQuery.insert(s1);
        SubjectQuery.insert(s2);
        // فحص هل تم حفظ ما سبق 5
        //استخراج وطباعة جميع معطيات الجدول المواضيع

            List<MySubject> allSubjects = SubjectQuery.getAll();
        for (MySubject w:allSubjects)
        {
            Log.d("wadea",w.Title);
            Toast.makeText(this, w.Title, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("WH", "onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("WH", "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("WH", "onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("WH", "onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}