package com.example.yolofitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class memberpage extends AppCompatActivity {
    public Button member_searchbutton,member_viewclass;
    public EditText member_searchbox;
    public ListView lt_view_class;
    DatabaseHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberview_page);
        member_searchbutton = (Button) findViewById(R.id.member_searchbutton);
        member_viewclass = (Button) findViewById(R.id.member_viewclass);
        member_searchbox = (EditText) findViewById(R.id.member_searchbox);
        lt_view_class = (ListView) findViewById(R.id.lt_view_class);
        database = new DatabaseHelper(this);
        displayClassList(database);
        Bundle bundle = getIntent().getExtras();
        Bundle finalBundle = bundle;

        member_searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classn = member_searchbox.getText().toString();
                if (classn != null){
                    List<ClassModel> search = database.search(classn);
                    ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(memberpage.this, android.R.layout.simple_list_item_1, search);
                    lt_view_class.setAdapter(classarrayadapter);
                }else{
                    Toast.makeText(memberpage.this, "N/A", Toast.LENGTH_SHORT).show();
                    displayClassList(database);
                }

            }
        });
        lt_view_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClassModel clickedClass = (ClassModel) adapterView.getItemAtPosition(i);
                finalBundle.putInt("classid",clickedClass.getId());
                finalBundle.putString("classname",clickedClass.getName());
                finalBundle.putString("diff",clickedClass.getDifficulty());
                finalBundle.putString("date",clickedClass.getDate());
                finalBundle.putString("hours",clickedClass.getHours());
                finalBundle.putString("capacity",clickedClass.getCapacity());
                finalBundle.putStringArray("membername",clickedClass.getStudentname());
                Intent intent = new Intent(memberpage.this, EnrolPage.class);
                intent.putExtras(finalBundle);
                startActivity(intent);
            }
        });
    }
    private void displayClassList(DatabaseHelper databaseHelper) {
        List<ClassModel> allclass = databaseHelper.getAll();
        ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(memberpage.this, android.R.layout.simple_list_item_1, allclass);
        lt_view_class.setAdapter(classarrayadapter);
    }

}
