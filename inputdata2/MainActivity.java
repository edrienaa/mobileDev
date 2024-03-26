package com.example.inputdata2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        TextView txtNumber = findViewById(R.id.txtNumber);
        EditText editTxtNumber = findViewById(R.id.editTxtNumber);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plainText;
                int number1;

                plainText = editTxtNumber.getText().toString();
                number1 = Integer.parseInt(plainText);

                txtNumber.setText(""+number1);
            }
        });
    }
}