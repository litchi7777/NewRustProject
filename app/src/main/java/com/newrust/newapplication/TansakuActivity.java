package com.newrust.newapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TansakuActivity extends AppCompatActivity {

    public int left,top,right,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tansaku);
        String case1 = getString(R.string.case1);


    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // something to do
                break;
            case MotionEvent.ACTION_UP:
                ImageView po = (ImageView) findViewById(R.id.imageView);
                int poleft = po.getLeft();
                int potop = po.getTop();
                int x= (int) motionEvent.getX();
                int y= (int) motionEvent.getY();
                int percentX = (x-poleft)/po.getWidth()*100;
                int percentY = (y-potop)/po.getHeight()*100;
                if (percentX > left && percentX < right && percentY < top && percentY < bottom ) {

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




}
