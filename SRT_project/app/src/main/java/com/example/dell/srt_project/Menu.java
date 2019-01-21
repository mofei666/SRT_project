package com.example.dell.srt_project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Menu extends Activity {

    Button lv,blue,red;
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lv = (Button) findViewById(R.id.lv);
        blue = (Button) findViewById(R.id.blue);
        red = (Button) findViewById(R.id.red);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("首页");
        tv_title.setGravity(Gravity.CENTER);

        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Ldy.class);
                startActivity(intent);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Yysz.class);
                startActivity(intent);
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Ysyl.class);
                startActivity(intent);
            }
        });
    }
}