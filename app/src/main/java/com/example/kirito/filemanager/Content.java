package com.example.kirito.filemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kirito.filemanager.support.LoadData;

import java.io.File;

/**
 * Created by kirito on 2016/9/9.
 */
public class Content extends AppCompatActivity {
    private String path;
    private TextView content;
    private LoadData load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        path = getIntent().getStringExtra("path");
        setTitle(new File(path).getName());
        content = (TextView) findViewById(R.id.tv_content);
        load = new LoadData(Content.this);
        load.setCallBack(new LoadData.callBack() {
            @Override
            public void setData(String data) {
                content.setText(data);
            }
        });
        load.execute(path);
    }
}
