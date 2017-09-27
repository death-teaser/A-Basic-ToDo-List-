package com.example.root.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class display extends AppCompatActivity {
    DatabaseHalper helper = new DatabaseHalper(this);
    ArrayAdapter<String> mAdapter;
    ListView lstTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

    }
    public void onclick(View v){
       if(v.getId() == R.id.dbutton){
           EditText et = (EditText)findViewById(R.id.dtext);
           String task = et.getText().toString();
           if(task.equals("")){
               Toast msg = Toast.makeText(this, "Please Insert any Task first", Toast.LENGTH_SHORT);
               msg.show();
           }
           else {
               helper.insertTask(task);
           }
       }
       if(v.getId()== R.id.dshow){
           Intent i = new Intent(this, todolist.class);
           //ArrayList<String> taskList = helper.getTaskList();
           //i.putExtra("list",taskList);
           startActivity(i);
       }
    }

//    private void loadTaskList() {
//        ArrayList<String> taskList = helper.getTaskList();
//        if(mAdapter==null){
//            mAdapter = new ArrayAdapter<String>(this,R.layout.row,R.id.task_title,taskList);
//            lstTask.setAdapter(mAdapter);
//        }
//        else{
//            mAdapter.clear();
//            mAdapter.addAll(taskList);
//            mAdapter.notifyDataSetChanged();
//        }
//    }

}
