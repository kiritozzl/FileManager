package com.example.kirito.filemanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kirito.filemanager.adapter.FileListAdapter;
import com.example.kirito.filemanager.entity.Item;

import java.io.File;

/**
 * Created by kirito on 2016/9/9.
 */
public class FileList extends AppCompatActivity {
    private ListView lv;
    private String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filelist);

        path = getIntent().getStringExtra("path");
        setTitle("上层文件夹:"+new File(path).getName());
        lv = (ListView) findViewById(R.id.lv);
        FileListAdapter adapter = new FileListAdapter(this,path);
        lv.setClickable(true);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item)parent.getItemAtPosition(position);
                File file = new File(item.getPath());
                String name = file.getName();
                String file_path = item.getPath();
                if (file.isDirectory()){
                    Intent intent = new Intent(FileList.this,FileList.class);
                    intent.putExtra("path",item.getPath());
                    startActivity(intent);
                }else if (name.endsWith(".txt")){
                    Intent i = new Intent(FileList.this,Content.class);
                    i.putExtra("path",file.getAbsolutePath());
                    startActivity(i);
                }else if (name.endsWith(".jpeg") || name.endsWith(".jpg") || name.endsWith(".png")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse("file://"+file_path),"image/*");
                    startActivity(intent);
                }else if (name.endsWith(".xlsx") || name.endsWith(".docx") || name.endsWith(".ppt")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    //intent.setDataAndType(Uri.parse("file://"+file_path),"application/vnd.ms-excel");
                    intent.setDataAndType(Uri.parse("file://"+file_path),"application/msword");
                    startActivity(intent);
                }
            }
        });
    }

}
