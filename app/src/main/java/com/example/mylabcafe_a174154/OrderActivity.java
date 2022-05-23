package com.example.mylabcafe_a174154;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtnCall,imgBtnWeb,imgBtnEmail;
    TextView TVName,TVQuantity;
    String name;
    int quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        imgBtnCall=findViewById(R.id.img_btn_Call);
        imgBtnWeb=findViewById(R.id.img_btn_app);
        imgBtnEmail=findViewById(R.id.img_btn_email);

        TVName=findViewById(R.id.tv_name_order);
        TVQuantity=findViewById(R.id.tv_quantity_order);

        Intent intent =getIntent();
        quantity=intent.getIntExtra("quantity",0);
        name =intent.getStringExtra("name");

        TVName.setText(name);
        TVQuantity.setText(""+quantity);

        imgBtnCall.setOnClickListener(this);
        imgBtnWeb.setOnClickListener(this);
        imgBtnEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img_btn_app:
                Uri webpage=Uri.parse("http://www.google.com");
                Intent webIntent=new Intent(Intent.ACTION_VIEW, webpage);
                if(webIntent.resolveActivity(getPackageManager())!= null){
                    startActivity(webIntent);
            }
                  else{
                Toast.makeText(OrderActivity.this,"Sorry ,no app can enter this length of data",Toast.LENGTH_LONG).show();
            }
                break;


            case R.id.img_btn_Call:
                Intent call =new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel: 01158988470"));

                if (call.resolveActivity(getPackageManager())!=null){
                    startActivity(call);
                    //verify that app is exist to receive an intent
            }
                else{
                    Toast.makeText(OrderActivity.this,"Sorry ,no app can enter this length of data",Toast.LENGTH_LONG).show();
            }
                break;


            case R.id.img_btn_email:
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/palin");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your order from My Cafe App");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Email message: Information about order.");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"DeltaFood@Company.com"});

                if (emailIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(emailIntent);
                    //verify that app is exist to receive an intent
                }
                else{
                    Toast.makeText(OrderActivity.this,"Sorry ,no app can enter this length of data",Toast.LENGTH_LONG).show();
                }

                break;


        }
    }
}