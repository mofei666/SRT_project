package com.example.dell.directionary;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class C_to_E extends AppCompatActivity implements View.OnClickListener{

    EditText word;
    Button next,commit;
    ImageButton back;
    String[] s1,s2;
    TextView meaning;
    Map<String,String> map = new HashMap<String, String>();
    StringBuffer words =new StringBuffer();
    StringBuffer meanings =new StringBuffer();
    StringBuffer error =new StringBuffer();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_c_to_e);
        word = (EditText)findViewById(R.id.word);
        meaning = (TextView)findViewById(R.id.meaning);
        next = (Button)findViewById(R.id.next);
        back = (ImageButton)findViewById(R.id.back);
        commit = (Button)findViewById(R.id.commit);
        commit.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        getData();
        meaning.setText(s2[i]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                write();
                finish();
                break;
            case R.id.commit:
                if (s1[i].equals(word.getText().toString())) {
                    Toast.makeText(C_to_E.this, "恭喜你答对了！", Toast.LENGTH_SHORT).show();
                    word.setText(s1[i]);
                } else {
                    Toast.makeText(C_to_E.this, "回答错误，请看正确答案！", Toast.LENGTH_SHORT).show();
                    word.setText(s1[i]);
                    error.append(word.getText().toString() + " " +  meaning.getText().toString() + ";");
                }
                break;
            case R.id.next:
                i++;
                if (i<s1.length) {
                    meaning.setText(s2[i]);
                    word.setText("");
                }
                else
                    Toast.makeText(C_to_E.this, "恭喜你通关了！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void write(){
        FileWriter writer = null;
        try {
            // 创建指定路径的文件
            File file = new File(Environment.getExternalStorageDirectory(),"error_words.txt");
            // 如果文件不存在
            if (!file.exists()) {
                // 创建空文件
                file.createNewFile();
            }
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(file, true);
            writer.write(error.toString());
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
                map.put(s2[j],s1[j]);
            }
            int k = 0;
            for (String key : map.keySet()) {
                s2[k]=key.toString();
                s1[k]=map.get(key).toString();
                k++;
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

