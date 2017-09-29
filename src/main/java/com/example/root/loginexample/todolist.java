package com.example.root.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class todolist extends AppCompatActivity {
    DatabaseHalper helper = new DatabaseHalper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);
        ListView lstTask =  (ListView) findViewById(R.id.tlist);
        List<String> taskList =  helper.getTaskList();
        ArrayAdapter<String>  mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,taskList);
        lstTask.setAdapter(mAdapter);

    }
}
