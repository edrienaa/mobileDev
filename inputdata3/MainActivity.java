package com.example.inputdata3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        Button btnToast = findViewById(R.id.btnToast);
        TextView txtTotal = findViewById(R.id.txtTotal);
        EditText txtNumber1 = findViewById(R.id.txtNumber1);
        EditText txtNumber2 = findViewById((R.id.txtNumber2);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plainText;
                int number1;
                int number2;
                int sum = number1 + number2;

                plainText = txtNumber1.getText().toString();
                number1 = Integer.parseInt(plainText);

                plainText = txtNumber2.getText().toString();
                number2 = Integer.parseInt(plainText);

                txtTotal.setText(""+sum);

            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "HAFA HAFA HAFA HAFA";

                Toast.makeText(MainActivity.this, "Toast message is success"+msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}