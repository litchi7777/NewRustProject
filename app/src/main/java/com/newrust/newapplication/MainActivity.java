package com.newrust.newapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTansakuButtonClick(View view){
        switch (view.getId()){
            case R.id.btnToTansaku:
                Intent intent = new Intent(this, TansakuActivity.class);
                startActivity(intent);
                break;

        }

    }

    public void onStoryButtonClick(View view){
        switch (view.getId()){
            case R.id.btnToStory:
                Intent intent1 = new Intent(this, StoryActivity.class);
                startActivity(intent1);
                break;

        }

    }

}
