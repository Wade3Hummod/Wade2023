package com.example.wade2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wade2023.data.AppDatabase;
import com.example.wade2023.data.SubjectTable.MySubject;
import com.example.wade2023.data.SubjectTable.MySubjectQuery;
import com.example.wade2023.data.myTasksTable.MyTask;
import com.example.wade2023.data.myTasksTable.MyTaskQuery;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabAdd;
    private SearchView srhV;
    private Spinner spnrSubject;
    private ListView lstvTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(i);
            }
        });
        srhV = findViewById(R.id.srhV);
        spnrSubject = findViewById(R.id.spnrSubject);
        lstvTasks = findViewById(R.id.lstvTasks);

    }
     @Override//بناء قائمة
    public boolean onCreateOptionsMenu(Menu menu)
     {
         getMenuInflater().inflate(R.menu.menu_item,menu);
         return true;
     }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==R.id.itmAddTask)
        {
        }
        if(item.getItemId()==R.id.itmLogOut)
        {
            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.itmSettings)
        {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("WH", "onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        initSubjectSpnr();
        initAllListView();
    }

    /**
     * عملية تجهيز السبنر بالمواضيع
     */
    private void initSubjectSpnr()
    {
        AppDatabase db =AppDatabase.getDB((getApplicationContext()));//قاعدة بناء
        MySubjectQuery subjectQuery =db.getMySubjectQuery();//عمليات جدول المواضيع
        List<MySubject>allSubjects =subjectQuery.getAll();//استخراج جميع المواضيع
        //تجهيز الوسيط
        ArrayAdapter<String> subjectAdabter= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        subjectAdabter.add("All");//ستظهر اولا بالسبنر تعني عرض جميع المهمات
        for(MySubject subject : allSubjects)//اضافة المواضيع للوسيط
        {
            if(subject.getTitle()==null)
                subject.setTitle(" ");
            subjectAdabter.add((subject.getTitle()));
        }
        spnrSubject.setAdapter((subjectAdabter));//ربط سبنر بالوسيط
        spnrSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {//استخراج الموضوع حسب رقمه الترتيبي position
                String item=subjectAdabter.getItem(position);
                if (item.equals("All"))//هذه يعني عرض جميع المهام
                    initAllListView();
                else
                {
                    //استخراج كائن الموضوع الذي اخترناه  لاستخراج رقمه id
                    MySubject subject=subjectQuery.checkSubject(item);
                    //استدعاء العملية التي تجهز القائمة حسب رقم الموضوع id
                    initListViewBySubjId(subject.getKeyid());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });
    }

    /**
     * تجهيز قائمة جميع المهمات وعرضها ب ListView
     */
    private void initAllListView()
    {
        AppDatabase db =AppDatabase.getDB((getApplicationContext()));
        MyTaskQuery taskQuery=db.getMyTaskQuery();
        List<MyTask>allTasks = taskQuery.getAllTasks();
        ArrayAdapter<MyTask>tsksAapter=new ArrayAdapter<MyTask>(this, android.R.layout.simple_list_item_1);
        tsksAapter.addAll(allTasks);
        lstvTasks.setAdapter(tsksAapter);
    }

    /**
     * تجهيز قائمة المهمات حسب رقم الموضوع
     * رقم الموضوع param key_id@
     */
    private void initListViewBySubjId(long key_id)
    {
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        MyTaskQuery taskQuery=db.getMyTaskQuery();
        //يجب اضافة عملية تعيد جميع المهمات حسب رقم الموضوع
        List<MyTask>allTasks=taskQuery.getTaskBySubjId(key_id);
        ArrayAdapter<MyTask>taskAdapter=new ArrayAdapter<MyTask>(this, android.R.layout.simple_list_item_1);
        taskAdapter.addAll(allTasks);
        lstvTasks.setAdapter(taskAdapter);
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