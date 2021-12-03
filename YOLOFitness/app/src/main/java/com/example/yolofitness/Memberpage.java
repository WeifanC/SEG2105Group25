package com.example.yolofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Memberpage extends AppCompatActivity {
    public EditText ET_search;
    public TextView hint;
    public Button bt_myclass, bt_menu,bt_search;
    public ListView lt_member;
    public String classname;
    DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberpage);
        hint = (TextView) findViewById(R.id.textView2);
        bt_myclass = (Button) findViewById(R.id.bt_unenroll);
        bt_menu = (Button) findViewById(R.id.bt_backtomain);
        ET_search = (EditText)findViewById(R.id.ET_Search);
        bt_search = (Button)findViewById(R.id.Bt_search);
        lt_member = (ListView)findViewById(R.id.ltmember);
        database = new DatabaseHelper(this);
        Bundle bundle;
        bundle = getIntent().getExtras();
        Bundle finalBundle = bundle;
        String Insname = bundle.getString("user");


        displayClassList(database);

        bt_menu.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        bt_myclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String allorowned = bt_myclass.getText().toString();
                if (allorowned.equals("AVAILABLE COURSES")){
                    bt_myclass.setText("My Course");
                    List<ClassModel> owned = database.getOwnedClass(Insname);
                    List<ClassModel> available = database.getOwnedClass("null");
                    owned.addAll(available);
                    ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(Memberpage.this, android.R.layout.simple_list_item_1, owned);
                    lt_member.setAdapter(classarrayadapter);
                }else if (allorowned.equals("My Course")){
                    bt_myclass.setText("AVAILABLE COURSES");
                    displayClassList(database);
                }



///                classname=ET_search.getText().toString();
///                boolean verify = database.Verify_Classname(classname);
                ///               if (verify) {

                ///               }
                ///               else {
                ///                   Toast.makeText(instructor_page.this,"Classname incorrected",Toast.LENGTH_LONG).show();
///               }
            }
        });
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classn = ET_search.getText().toString();
                if (classn != null){
                    List<ClassModel> search = database.search(classn);
                    ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(Memberpage.this, android.R.layout.simple_list_item_1, search);
                    lt_member.setAdapter(classarrayadapter);
                }else{
                    Toast.makeText(Memberpage.this, "This course is not available to you ", Toast.LENGTH_SHORT).show();
                    displayClassList(database);
                }

            }
        });


        lt_member.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClassModel clickedClass = (ClassModel) adapterView.getItemAtPosition(i);
                String Cinstructor = clickedClass.getMember();
                boolean verify = database.Verify_Classname(clickedClass.getName(),Insname);
                if (Cinstructor.equals("null")|| verify){
                    finalBundle.putInt("classid",clickedClass.getId());
                    finalBundle.putString("classname",clickedClass.getName());
                    finalBundle.putString("diff",clickedClass.getDifficulty());
                    finalBundle.putString("date",clickedClass.getDate());
                    finalBundle.putString("hours",clickedClass.getHours());
                    finalBundle.putString("capacity",clickedClass.getCapacity());
                    Intent intent = new Intent(Memberpage.this, modifycourse_page.class);
                    intent.putExtras(finalBundle);
                    startActivity(intent);
                }else{
                    Toast.makeText(Memberpage.this, "This course is not available to you . ", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void displayClassList(DatabaseHelper databaseHelper) {
        List<ClassModel> allclass = databaseHelper.getAll();
        ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(Memberpage.this, android.R.layout.simple_list_item_1, allclass);
        lt_member.setAdapter(classarrayadapter);
    }
}