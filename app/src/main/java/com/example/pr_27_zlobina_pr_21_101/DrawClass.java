package com.example.pr_27_zlobina_pr_21_101;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/*
* наследуемся от класса android.view.View
*  и переопределяем метод класса onDraw().*/

public class DrawClass extends View {
    public DrawClass(Context context) {
        super(context);

        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.qw1);

    }
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        // Рисуем жёлтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(950, 30, 25, mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawRect(20, 650, 950, 680, mPaint);

        // Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        canvas.drawText("Лужайка только для котов", 30, 648, mPaint);


        // Текст под углом
        int x = 810;
        int y = 190;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(27);
        String str2rotate = "Лучик солнца!";


        canvas.save();
// Создаём ограничивающий прямоугольник для наклонного текста
// поворачиваем холст по центру текста
        canvas.rotate(-45, x + mRect.exactCenterX(), y + mRect.exactCenterY());

// Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);

// восстанавливаем холст
        canvas.restore();


// это картинка
        canvas.drawBitmap(mBitmap, 750, 400, mPaint);
    //    canvas.drawBitmap(mBitmap, 50, 150, mPaint);

    }


}
