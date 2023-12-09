package com.example.pr_27_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MyView vb = new MyView(this);
        setContentView(vb);
    }

    class MyView extends View
    {
        Paint p;
        float x = 300;
        float y = 300;
        int side = 200;

        // переменные для перетаскивания
        boolean drag = false;
        float dragX = 0;
        float dragY = 0;

        public MyView(Context context)
        {
            super(context);
            p = new Paint();
            p.setColor(Color.GREEN);
        }

        protected void onDraw (Canvas canvas)
        {
            //canvas.drawRect(x,y,x + side, y+side,p);
            p.setColor(Color.YELLOW);
            canvas.drawCircle(x,y,side,p); // нарисует круг в точке (100,200) с радиусом 50

        }

        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            float evX = event.getX();
            float evY = event.getY();

            switch ( event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    if(evX <= x + side && evX >= x - side && evY >= y - side && evY <= y + side)
                    {
                        drag = true;
                        dragX = evX-x;
                        dragY = evY-y;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if(drag)
                    {
                        x = evX - dragX;
                        y = evY - dragY;
                        invalidate();
                    }
                    break;

                case MotionEvent.ACTION_UP:
                    drag = false;
                    break;
            }
            return true;
        }
    }
}