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

public class Ldy extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,ImageButton.OnClickListener{

    TextView tv_ldy;
    Button st;
    RadioGroup radioGroup;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ldy);
        tv_ldy=(TextView)findViewById(R.id.ldy);
        st=(Button) findViewById(R.id.st);
        radioGroup=(RadioGroup) findViewById(R.id.radio);
        back=(ImageButton)findViewById(R.id.back);
        radioGroup.setOnCheckedChangeListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.radio:
                RadioButton rb1 = (RadioButton) this.findViewById(checkedId);
                tv_ldy.setText("当前朗读员:"+rb1.getText());
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Ldy.this,Menu.class);
        startActivity(intent);
    }
}