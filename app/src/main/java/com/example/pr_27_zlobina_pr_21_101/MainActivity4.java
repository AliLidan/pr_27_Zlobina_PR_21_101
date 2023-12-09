package com.example.pr_27_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class MainActivity4  extends AppCompatActivity {

    ImageView v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        v1 = (ImageView) findViewById(R.id.imageView2);

      /*  Bitmap bm = getBitmap();
        v1.setImageBitmap(bm);*/

        MyView vb = new MyView(this);
        setContentView(vb);

    }


    class MyView extends View {
        Paint p;
        float x = 500;
        float y = 500;
        int side = 300;
        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        // переменные для перетаскивания
        boolean drag = false;
        float dragX = 0;
        float dragY = 0;


        public MyView(Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.GREEN);

        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRect(x, y, x + side, y + side, p);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float evX = event.getX();
            float evY = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (evX >= x && evX <= x + side && evY > y && evY <= y + side) {
                        drag = true;
                        dragX = evX - x;
                        dragY = evY - y;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (drag) {
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

    /*
     public Bitmap getBitmap()
    {
         class MyView extends View {
            Paint p;
            float x = 500;
            float y = 500;
            int side = 300;

            // переменные для перетаскивания
            boolean drag = false;
            float dragX = 0;
            float dragY = 0;


            public MyView(Context context) {
                super(context);
                p = new Paint();
                p.setColor(Color.GREEN);

            }

            protected void onDraw(Canvas canvas) {
                canvas.drawRect(x, y, x + side, y + side, p);
            }

            @Override
            public boolean onTouchEvent(MotionEvent event) {
                float evX = event.getX();
                float evY = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (evX >= x && evX <= x + side && evY > y && evY <= y + side) {
                            drag = true;
                            dragX = evX - x;
                            dragY = evY - y;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (drag) {
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
        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint p = new Paint();
        float x = 100;
        float y = 100;
        int side = 200;
        p.setColor(Color.RED);
        canvas.drawRect(x, y, x + side, y + side, p);

        //MyView vb = new MyView(v1.getContext());

        return bitmap;
    }
}
*/

//------------------------- 2 class -------------------------
/*  class MyView2 extends View {
        Paint p;

       float x = 300;
        float y = 300;
        int side = 300;


        // переменные для перетаскивания
        boolean drag = false;
        float dragX = 0;
        float dragY = 0;

        float x = 400;
        float y = 240;
        float radius = 100;

        public MyView2(Context context) {
            super(context);
            p = new Paint();

        }

        protected void onDraw(Canvas canvas) {
            Path path = new Path();
            path.addCircle(x, y, radius, Path.Direction.CW);
            p.setColor(Color.BLUE); // установим белый цвет
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

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float evX = event.getX();
            float evY = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (evX >= x && evX <= x + radius && evY > y && evY <= y + radius) {
                        drag = true;
                        dragX = evX - x;
                        dragY = evY - y;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (drag) {
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
    }*/
/*
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        // Инициализация вашего виджета здесь
    }

    @Override
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, final int[] appWidgetIds) {
        //переопределили метод
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        //метод который позволяет вырисовывать на вивджите
        RemoteViews rViews = new RemoteViews(context.getPackageName(), R.layout.activity_main4);
        //говорим методу RemoteViews  что рисуем на imageView1
        rViews.setImageViewBitmap(R.id.imageView, Graph.getBitmap());
        //дальше автообновляем виджет для прорисовки красоты
        appWidgetManager.updateAppWidget(appWidgetIds, rViews);

        public class Graph {
        public  Bitmap getBitmap() {
            Bitmap bitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
            //говорим что рисуем на объекте битмапа который создан выше
            Canvas canvas = new Canvas(bitmap);
            //фоновый цвет сцены
            canvas.drawColor(Color.WHITE);

            //параметры для рисования, цвет, размер текста
            Paint paint = new Paint();
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.RED);
            paint.setTextSize(20);

            //собственно сам рисунок
            canvas.drawLine(0, 0, 128, 128, paint);
            canvas.drawText("Какой нибудь текст", 10, 10, paint);

            //обязательно возвращаем на чем рисовать иначе ничего не покажется
            return bitmap;
        }

 */
/*---------------vtnjl ------------------

        public static Bitmap getBitmap() {
            Bitmap bitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
            //говорим что рисуем на объекте битмапа который создан выше
            Canvas canvas = new Canvas(bitmap);
            //фоновый цвет сцены
            canvas.drawColor(Color.WHITE);



            //параметры для рисования, цвет, размер текста
            Paint paint = new Paint();
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.RED);
            paint.setTextSize(20);

            //собственно сам рисунок
            canvas.drawLine(0, 0, 128, 128, paint);
            canvas.drawText("Какой нибудь текст", 10, 10, paint);

            //обязательно возвращаем на чем рисовать иначе ничего не покажется
            return bitmap;
        }
         */

/*
Итак если я фигуру помещая в растровое изображение в bipmap то это просто ихзображение
я же не могу его двигать?
сам канваз раздут до размера холста то есть размера экрана
как его уменьшить?
 люди советают помащать картинку в bipmap но она не может двигт=аться по определению
 получится просто картинка
------------------------------    1     ----------------------------------------------------------
 один из ответов:
 с сайта: https://translated.turbopages.org/proxy_u/en-ru.ru.539724f6-656c9e5b-c9733788-74722d776562/https/stackoverflow.com/questions/9736246/android-canvas-only-take-up-only-part-of-screen

 Если вы хотите динамически создавать DrawView, как показано в вашем примере, 1cc соЗдайте view (возможно, FrameLayout) в вашем xml-макете, который будет содержать ваш canvas, и используйте стандартные методы верстки Android, чтобы сделать FrameLayout нужного размера.
В качестве альтернативы вы можете создать DrawView статически, поместив его непосредственно в свой макет; Как добавить CustomView в Layout из XML? показано, как это сделать.
------------------------------    2     ----------------------------------------------------------

второй:
https://dajver.blogspot.com/2012/04/canvas-android.html
но он мне не подходит так как не appcompat который мне нужен для других объектов

третий:
https://translated.turbopages.org/proxy_u/en-ru.ru.cfc35e7f-656c97cf-3621b3f9-74722d776562/https/stackoverflow.com/questions/8890102/drag-multiple-images-in-a-canvas-by-touching-in-android
почти совсем не мое

четвертый:
https://ru.stackoverflow.com/questions/895692/%D0%9A%D0%B0%D0%BA-%D0%B2-canvas-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C-%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82-%D0%BA%D0%B0%D1%81%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC?ysclid=lppluw99z9778732024
проект классный но тоже не совсем мое


теория от котят
https://developer.alexanderklimov.ru/android/catshop/android.graphics.canvas.php?ysclid=lppjjducij729359156
там тоже обясняется что используют через bipmap или view

чувак, у которого ооже двигается объект, но с привязкой, где его оставил
https://stackoverflow.com/questions/23260077/moving-drawing-in-canvas-android

то что я вяла за основу
http://forum.startandroid.ru/viewtopic.php?t=535
но тут опять таки на весь холст
http://forum.startandroid.ru/viewtopic.php?f=32&t=473 от сюда к верхнемцу вопросу нашла ответ


хороший пример игры с перетаскиванием. но тут один объект и опять таки bipmap
http://www.mobilab.ru/androiddev/androidgamedev02html.html



то самое
https://stackoverflow.com/questions/5633196/can-we-have-two-canvases-in-an-activity-or-having-a-canvas-outside-the-ondra

но тут советают взять интерфейс
SurfaceView

рисование канвас в imageView
https://stackoverflow.com/questions/4918079/android-drawing-a-canvas-to-an-imageview



 */