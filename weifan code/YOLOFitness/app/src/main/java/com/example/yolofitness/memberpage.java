package com.example.yolofitness;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class memberpage extends AppCompatActivity {
    public Button member_searchbutton;
    public EditText member_searchbox;
    public ListView view_class;
    DatabaseHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberview_page);
        member_searchbutton = (Button) findViewById(R.id.member_searchbutton);
        member_searchbox = (EditText) findViewById(R.id.member_searchbox);
        view_class = (ListView) findViewById(R.id.view_class);
        database = new DatabaseHelper(this);
        displayClassList(database);

        member_searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classn = member_searchbox.getText().toString();
                if (classn != null){
                    List<ClassModel> search = database.search(classn);
                    ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(memberpage.this, android.R.layout.simple_list_item_1, search);
                    view_class.setAdapter(classarrayadapter);
                }else{
                    Toast.makeText(memberpage.this, "N/A", Toast.LENGTH_SHORT).show();
                    displayClassList(database);
                }

            }
        });
    }
    private void displayClassList(DatabaseHelper databaseHelper) {
        List<ClassModel> allclass = databaseHelper.getAll();
        ArrayAdapter classarrayadapter = new ArrayAdapter<ClassModel>(memberpage.this, android.R.layout.simple_list_item_1, allclass);
        view_class.setAdapter(classarrayadapter);
    }

}
