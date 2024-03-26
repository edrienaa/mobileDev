package com.DKA4224.mybakery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMenu extends AppCompatActivity {

    DatabaseHelper mDBHelp;
    EditText updateMenu, updatePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu);

        Intent intent = getIntent();
        final String udMenu = intent.getStringExtra("addMenu");
        final String udPrice = intent.getStringExtra("addPrice");

        EditText updateMenu = findViewById(R.id.txtUdMenu);
        EditText updatePrice = findViewById(R.id.txtUdPrice);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnCancel = findViewById(R.id.btnUdCancel);

        mDBHelp = new DatabaseHelper(this);
        final Cursor data = mDBHelp.getDataForUpdate(udMenu);

        if (data != null){
            while (data.moveToNext()){
                updateMenu.setText(data.getString(1));
                updatePrice.setText(data.getString(2));

            }
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String udMenu = updateMenu.getText().toString();
                String udPrice = updatePrice.getText().toString();

                int ud_price = Integer.parseInt(udPrice);

                mDBHelp = new DatabaseHelper(UpdateMenu.this);
                if (data !=null && data.moveToFirst()){
                    updateMenu.setText(data.getString(1));
                    String udId = data.getString(data.getColumnIndex("id"));
                    boolean updateData = mDBHelp.updateData(udMenu, udId, ud_price);

                    
                }data.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
            }
        });

    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder();
        builder.setTitle("");
        builder.setMessage("");
        builder.setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String udMenu = updateMenu.getText().toString();
                mDBHelp = new DatabaseHelper(UpdateMenu.this);
                boolean deleteData = mDBHelp.deleteData(udMenu);

                
                dialog.dismiss();
                

            }
        });

        builder.setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}