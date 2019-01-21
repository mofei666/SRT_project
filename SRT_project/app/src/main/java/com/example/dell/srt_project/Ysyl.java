package com.example.dell.srt_project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class Ysyl extends AppCompatActivity implements Button.OnClickListener{

    Button czys,stsl,czyl;
    SeekBar ys_bar,yl_bar;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        czys =(Button)findViewById(R.id.czys);
        czyl =(Button)findViewById(R.id.czyl);
        stsl =(Button)findViewById(R.id.stsl);
        ys_bar =(SeekBar)findViewById(R.id.ys_bar);
        yl_bar =(SeekBar)findViewById(R.id.yl_bar);
        back=(ImageButton)findViewById(R.id.back);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ysyl);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Intent intent = new Intent(Ysyl.this,Menu.class);
                startActivity(intent);
                break;
            case R.id.czyl:
                yl_bar.setProgress(0);
                break;
            case R.id.czys:
                ys_bar.setProgress(0);
                break;
            case R.id.stsl:
                break;
        }
    }
}