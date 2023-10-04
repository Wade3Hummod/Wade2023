package com.example.wade2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import com.example.wade2023.data.AppDatabase;
import com.example.wade2023.data.MySubject;
import com.example.wade2023.data.MySubjectQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("WH", "onCreate");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        //بناء قاعدة بيانات وارجاع مؤشر عليها 1
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        // مؤشر لكائن عمليات لجدول 2
        MySubjectQuery SubjectQuery=db
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