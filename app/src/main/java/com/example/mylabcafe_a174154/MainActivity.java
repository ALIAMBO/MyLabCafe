package com.example.mylabcafe_a174154;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnMinus,btnCheck;
    TextView tvQuantity;
    EditText etName;

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd= findViewById(R.id.btn_add);
        btnMinus=findViewById(R.id.btn_minus);
        btnCheck=findViewById(R.id.btn_checkOut);
        tvQuantity=findViewById(R.id.tv_quantity);
        etName=findViewById(R.id.et_Name);

        quantity=1;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                tvQuantity.setText(""+quantity);

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity--;
                tvQuantity.setText(""+quantity);
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {

                name =etName.getText().toString();
                Toast.makeText(MainActivity.this,"Thank You "+ name +" for order "+quantity +" latte.",Toast.LENGTH_LONG).show();

                Intent intent =new Intent (MainActivity.this,OrderActivity.class);

                 intent.putExtra("quantity",quantity);
                intent.putExtra("name",name);

                startActivity(intent);

            }
        });
    }
}