package com.example.wade2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wade2023.data.AppDatabase;
import com.example.wade2023.data.SubjectTable.MySubject;
import com.example.wade2023.data.SubjectTable.MySubjectQuery;
import com.example.wade2023.data.myTasksTable.MyTask;
import com.example.wade2023.data.usersTable.MyUser;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class AddTaskActivity extends AppCompatActivity {
    private Button btnSave;
    private Button btnCancel;
    private AutoCompleteTextView autoEtSubject;
    private TextView tvImportance;
    private SeekBar skbrImportance;
    private TextInputEditText etShortTitle;
    private TextInputEditText etText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        autoEtSubject = findViewById(R.id.autoEtSubject);
        tvImportance = findViewById(R.id.tvImportance);
        skbrImportance = findViewById(R.id.skbrImportance);
        etShortTitle = findViewById(R.id.etShortTitle);
        etText = findViewById(R.id.etText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAutoEtSubjects();
    }

    private void initAutoEtSubjects() {
        //مؤشر لقاعدة البيانات
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //مؤشر لواجهة استعمالات جدول المواضيع
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        //مصدر المعطيات:استخراج جميع المواضيع من الجدول
        List<MySubject> allSubjects = subjectQuery.getAll();
        //تجهيز الوسيط
        ArrayAdapter<MySubject> adapter = new ArrayAdapter<MySubject>(this, android.R.layout.simple_dropdown_item_1line);
        adapter.addAll(allSubjects);//اضافة جميع المعطيات للوسيط
        autoEtSubject.setAdapter(adapter);//ربط الحقل بالوسيط
        //معالجة حدث لعرض المواضيع عند الضغط على الحقل
        autoEtSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoEtSubject.showDropDown();
            }
        });
    }

    private void checkSaveandCancel()
    {
        boolean isAllOK = true;
        String short_title = etShortTitle.getText().toString();
        String Text = etText.getText().toString();
        int importancee = skbrImportance.getProgress();
        String autoetSubj = autoEtSubject.getText().toString();
        if (short_title.length() < 8 || short_title.contains(" ") == true) {

            isAllOK = false;
            etShortTitle.setError("Wrong short_title");
        }
        if (Text.length() < 8 || Text.contains(" ") == true) {

            isAllOK = false;
            etText.setError("Wrong text");
        }
        if (isAllOK) {
            Toast.makeText(this, "All ok", Toast.LENGTH_SHORT).show();
            AppDatabase db = AppDatabase.getDB(getApplicationContext());
            MySubjectQuery subjectQuery = db.getMySubjectQuery();


            if (subjectQuery.checkSubject(autoetSubj) == null) // فحص هل الموضوع من قبل بالجدول
            {
                //بناء موضوع جديد واضافته
                MySubject subject = new MySubject();
                subject.Title = autoetSubj;
                subjectQuery.insertAll(subject);
            }
            //استخراج id الموضوع لأننا بحاجة لرقمه التسلسلي

            MySubject subject = subjectQuery.checkSubject(autoetSubj);


            MyTask task = new MyTask();
            task.importance = importancee;
            task.text = Text;
            task.importance = importancee;
            task.subjId = subject.getKeyid();//تحديد رقم الموضوع للمهة
            db.getMyTaskQuery().insertTask(task);//اضافة المهمة للجدول
            finish();
        }
    }
    public void onclickCancelAddTask(View v)
    {
        finish();

    }
    public void onclickAddTask(View v)
    {
        checkSaveandCancel();
    }


}