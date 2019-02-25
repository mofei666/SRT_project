package com.example.dell.directionary;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Error_words extends AppCompatActivity {

    TextView errorwords;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error_words);
        errorwords = (TextView)findViewById(R.id.error);
        back = (ImageButton)findViewById(R.id.back);
        errorwords.setMovementMethod(ScrollingMovementMethod.getInstance());
        errorwords.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 通知ScrollView控件不要干扰
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    // 通知ScrollView控件不要干扰
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }

        });
        File file = new File(Environment.getExternalStorageDirectory(),"error_words.txt");
        try {
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
            char[] input=new char[fis.available()];
            isr.read(input);
            isr.close();
            fis.close();
            String in=new String(input);
            errorwords.setText(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
