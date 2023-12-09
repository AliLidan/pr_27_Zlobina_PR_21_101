package com.example.pr_27_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button btn, btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

    }


    public void OnClick(View view){
        switch(view.getId())
        {
            case R.id.button:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(this, MainActivity5.class);
                startActivity(intent2);
                break;

            case R.id.button3:
                Intent intent3 = new Intent(this, MainActivity4.class);
                startActivity(intent3);
                break;

            case R.id.button4:
                Intent intent4 = new Intent(this, MainActivity3.class);
                startActivity(intent4);
                break;

            case R.id.button5:
                Intent intent5 = new Intent(this, MainActivity6.class);
                startActivity(intent5);
                break;

            default:
                Toast.makeText(getApplicationContext(),"hey!",Toast.LENGTH_SHORT).show();


        }
    }
}