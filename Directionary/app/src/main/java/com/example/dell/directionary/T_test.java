package com.example.dell.directionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class T_test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Button ec=(Button)findViewById(R.id.etoc);
        Button ce=(Button)findViewById(R.id.ctoe);
        ImageButton back =(ImageButton)findViewById(R.id.back);
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(T_test.this,E_to_C.class);
                startActivity(intent);
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(T_test.this,C_to_E.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(T_test.this,Menu.class);
                startActivity(intent);
            }
        });
    }
}
