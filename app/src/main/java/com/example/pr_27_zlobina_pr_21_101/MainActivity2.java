package com.example.pr_27_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DrawClass drawClass = new DrawClass(this);
        setContentView(drawClass);

    }
}