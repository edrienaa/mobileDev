package com.example.inputdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        TextView textUser = findViewById(R.id.textUser);
        EditText editTxtName = findViewById(R.id.editTxtName);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plainText;

                plainText = editTxtName.getText().toString();
                textUser.setText(""+plainText);
            }
        });
    }
}