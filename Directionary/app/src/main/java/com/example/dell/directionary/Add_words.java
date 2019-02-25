package com.example.dell.directionary;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Add_words extends AppCompatActivity implements View.OnClickListener{
    Map<String, String> map = new HashMap<String, String>();
    EditText word,meaning;
    Button next;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_words);
        word = (EditText)findViewById(R.id.word);
        meaning = (EditText)findViewById(R.id.meaning);
        back = (ImageButton) findViewById(R.id.back);
        next = (Button)findViewById(R.id.next);
        back.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                write();
                finish();
                break;
            case R.id.next:
                map.put(word.getText().toString(), meaning.getText().toString());
                word.setText("");
                meaning.setText("");
                break;
        }
    }
    public void write(){

        FileWriter writer = null;
        try {
            // 创建指定路径的文件
            File file = new File(Environment.getExternalStorageDirectory(),"words.txt");
            // 如果文件不存在
            if (!file.exists()) {
                // 创建空文件
                file.createNewFile();
            }
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(file, true);
            for (String key : map.keySet()) {
                writer.write(key + " " + map.get(key)+";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


