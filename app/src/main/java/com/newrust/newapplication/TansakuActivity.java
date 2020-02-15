package com.newrust.newapplication;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class TansakuActivity extends AppCompatActivity {

    public ImageView currentView;
    public int left,top,right,bottom;
    public String[] Case_array;
    public int currentImage;
    public int obj1_1;
    public int obj1_id;
    public TextView chat;
    public int display_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tansaku);
        currentView = findViewById(R.id.imageView1);
        Case_array = getResources().getStringArray(R.array.case_array);
        chat = findViewById(R.id.textView);
        LoadImage(0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // something to do
                break;
            case MotionEvent.ACTION_UP:
                float density = 1;
                ImageView po = currentView;
                int poleft = (int)(po.getX()/density);
                int potop = (int)(po.getY()/density);
                int x= (int) (motionEvent.getX()/density);
                int y= (int) (motionEvent.getY()/density)-(display_size-findViewById(R.id.tansaku).getBottom());
                int width = (int)(po.getWidth()/density);
                int height = (int) (po.getHeight()/density);
                int percentX = (x-poleft)*100/width;
                int percentY = (y-potop)*100/height;

                Log.d("tansaku", "x:"+ String.valueOf(findViewById(R.id.tansaku).getBottom())+" y:"+String.valueOf(potop));
                Log.d("tansaku", "x:"+ String.valueOf(x)+" y:"+String.valueOf(y));
                Log.d("tansaku", "x:"+ String.valueOf(po.getWidth())+" y:"+String.valueOf(po.getHeight()));
                Log.d("tansaku", "x:"+ String.valueOf(percentX)+" y:"+String.valueOf(percentY));
                if (percentX > left && percentX < right && percentY > top && percentY < bottom ) {
                    switch(obj1_1) {
                        case 1:
                            String hyoujimojiretu = getResources().getStringArray(R.array.tansaku_text_array)[obj1_id];
                            chat.setText(hyoujimojiretu);
                            break;
                    }
                    return false;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                // something to do
                break;
            case MotionEvent.ACTION_CANCEL:
                // something to do
                break;
        }

        return false;
    }

    public void LoadImage(int num){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        display_size = size.y;

        currentImage = num;
        currentView.setImageResource(R.drawable.ship_sample);
        left = Character.getNumericValue(Case_array[num].charAt(9))*10+Character.getNumericValue(Case_array[num].charAt(10));
        top = Character.getNumericValue(Case_array[num].charAt(11))*10+Character.getNumericValue(Case_array[num].charAt(12));
        right = Character.getNumericValue(Case_array[num].charAt(13))*10+Character.getNumericValue(Case_array[num].charAt(14));
        bottom = Character.getNumericValue(Case_array[num].charAt(15))*10+Character.getNumericValue(Case_array[num].charAt(16));
        obj1_1 = Character.getNumericValue(Case_array[num].charAt(18));
        obj1_id = Character.getNumericValue(Case_array[num].charAt(19))*10+Character.getNumericValue(Case_array[num].charAt(20));

        Log.d("tansaku", "left:"+ String.valueOf(left)+" top:"+String.valueOf(top));

        Log.d("tansaku", "right:"+ String.valueOf(right)+" bottom:"+String.valueOf(bottom));
        Log.d("tansaku", "obj1_1:"+ String.valueOf(obj1_1)+" obj1_id:"+String.valueOf(obj1_id));
    }

}
