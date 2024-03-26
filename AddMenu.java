package com.DKA4224.mybakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMenu extends AppCompatActivity {

    DatabaseHelper mDBHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        Button saveMenu = findViewById(R.id.btnSave);
        Button cancel = findViewById(R.id.btnCancel);
        final EditText menu = findViewById(R.id.txtMenu);
        final EditText price = findViewById(R.id.txtPrice);

        saveMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addMenu = menu.getText().toString();
                String addPrice = price.getText().toString();

                int prices = Integer.parseInt(addPrice);

                mDBHelp = new DatabaseHelper(AddMenu.this);
                boolean InsertData = mDBHelp.addData(addMenu, prices);

                //Toast

                Intent iAddMenuSuccess = new Intent(AddMenu.this, ListMenu.class);
                startActivity(iAddMenuSuccess);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            
            }
        });
    }
}