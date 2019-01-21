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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Yysz extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,ImageButton.OnClickListener{

    TextView yy;
    ImageButton back;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yysz);
        back=(ImageButton)findViewById(R.id.back);
        yy = (TextView) findViewById(R.id.yy);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(this);
        back.setOnClickListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getId()) {
                case R.id.radio:
                    RadioButton rb1 = (RadioButton) this.findViewById(checkedId);
                    yy.setText("当前语言:"+rb1.getText());
                    break;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Yysz.this,Menu.class);
        startActivity(intent);
    }
}