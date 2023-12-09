package com.example.pr_27_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        DrawView dr = new DrawView((this));
        setContentView(dr);

    }

    class DrawView extends View {
        Paint p; // грубо говоря кисть где указ. толщина и цвет
        Rect rect;

        public DrawView (Context context)
        {
            super(context);
            p = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            // заливка канваса цветом
            canvas.drawARGB(80,102,204,255);
            //установим кисточке цвет и толщину
            p.setColor(Color.BLUE);
            p.setStrokeWidth(10);

            canvas.drawPoint(50,50,p); // нарисует точку с координатами (50,50)

            canvas.drawLine(100,100,500,500, p); //нарисует линию из точки (100,100) в точку (500,500)

            canvas.drawCircle(100,200,50,p); // нарисует круг в точке (100,200) с радиусом 50

            canvas.drawRect(200,150,400,200,p); //нарисует прямоугольник с левым верхним углом в точке (200,150) и нижним правым углом в точке (400,200)

            rect.set(200,500,1000,1000);
            p.setColor(Color.DKGRAY);
            canvas.drawRect(rect,p);


            rect.set(100,1500,500,1900);//(отступ с лева//     отступ с верху   // до конечной точки правой сороны(длина)//   до конечной точки с низу )
            p.setColor(Color.YELLOW); // квадрат
            canvas.drawRect(rect,p);
            // если условия не верны то он плюсует и пишет по логике цифры или рисует наоборот
            //(100, 2000, 1000, 500)
        }
    }
}