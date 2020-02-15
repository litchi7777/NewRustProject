package com.newrust.newapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


    }

    public void onMenuButtonClick(View view){
        switch (view.getId()){
            case R.id.btnToMenu:
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;

        }

    }
}
