package com.example.dell.directionary;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Delete_words extends AppCompatActivity implements View.OnClickListener{

    Map<String, String> map = new HashMap<String, String>();
    AutoCompleteTextView autocomplete;
    Button delete;
    ImageButton back;
    String[] s1,s2;
    StringBuffer words = new StringBuffer();
    StringBuffer meanings = new StringBuffer();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_words);

        back = (ImageButton)findViewById(R.id.back);
        delete = (Button)findViewById(R.id.delete);
        autocomplete=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.select_dialog_item,s1);
        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
        back.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.delete:
                map.remove(autocomplete.getText().toString());
                Toast.makeText(Delete_words.this, "删除成功！", Toast.LENGTH_SHORT).show();
                autocomplete.setText("");
                write();
                break;
        }
    }
    public void write() {
        FileWriter writer = null;
        try {
            // 创建指定路径的文件
            File file = new File(Environment.getExternalStorageDirectory(), "words.txt");
            // 如果文件不存在
            if (!file.exists()) {
                // 创建空文件
                file.createNewFile();
            }
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(file, false);
            for (String key : map.keySet()) {
                writer.write(key + " " + map.get(key) + ";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void getData(){
        File file = new File(Environment.getExternalStorageDirectory(),"words.txt");
        try {
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
            char[] input=new char[fis.available()];
            isr.read(input);
            isr.close();
            fis.close();
            String in=new String(input);
            char[] arr = in.toCharArray();
            for(int i = 0;i<arr.length;i++){
                if(((int)arr[i]>=65&&(int)arr[i]<=90)||((int)arr[i]>=97&&(int)arr[i]<=122)) {
                    words.append(input[i]);
                }
                else if((int)arr[i]==32)
                    words.append(input[i]);
                else {
                    meanings.append(input[i]);
                }
            }
            s1 = words.toString().split(" ");
            s2 = meanings.toString().split(";");
            for (int j = 0;j<s1.length;j++){
                map.put(s1[j],s2[j]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


