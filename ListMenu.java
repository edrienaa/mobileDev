package com.DKA4224.mybakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        final ListView lvMenu = findViewById(R.id.lvMenu);
        final DatabaseHelper mDBHelp = new DatabaseHelper(this);

       final Cursor data = mDBHelp.getData();
        ArrayList<String> listData = new ArrayList<>();
	while (data.moveToNext()){
            listData.add(data.getString(1));
            listData.add(data.getString(2));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        lvMenu.setAdapter(adapter);

        lvMenu.setClickable(true);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = lvMenu.getItemAtPosition(i);

               
            }
        });
    }
}