package com.example.pr_27_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        DrawablePaint dp = new DrawablePaint(this);
        setContentView(dp);
    }

    class DrawablePaint extends View
    {
        Paint p;
        float x = 400;
        float y = 240;
        int radius = 100;


        public DrawablePaint (Context context)
        {
            super(context);
            p = new Paint();
            p.setColor(Color.RED);
        }

        protected void onDraw(Canvas canvas)
        {
            Path path1 = new Path();
            path1.addCircle(x, y, radius, Path.Direction.CW);

            p.setStrokeWidth(5);
            p.setStyle(Paint.Style.FILL); // заливаем
            p.setAntiAlias(true);

            float center_x, center_y;
            center_x = 240;
            center_y = 220;

            final RectF oval = new RectF();
            oval.set(center_x - radius, center_y - radius, center_x + radius,
                    center_y + radius);
            canvas.drawArc(oval, 45, 270, true, p); // рисуем пакмана

// рисуем большого пакмана без заливки
            p.setStyle(Paint.Style.STROKE);
            oval.set(center_x - 200f, center_y - 200f, center_x + 200f,
                    center_y + 200f);
            canvas.drawArc(oval, 45, 270, true, p);

            p.setStyle(Paint.Style.STROKE);

        }
    }
}