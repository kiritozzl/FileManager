package com.example.kirito.filemanager.support;

import android.content.Intent;

import com.example.kirito.filemanager.entity.Item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirito on 2016/9/9.
 */
public class OpenFiles {
    private String path;
    private File file;

    public OpenFiles(String path) {
        this.path = path;
        file = new File(path);
    }

    public List<Item> openFiles(){
        File [] files = file.listFiles();
        List<Item> itemList = new ArrayList<>();
        for (File f : files) {
            Item item = new Item();
            item.setName(f.getName());
            item.setPath(f.getAbsolutePath());
            if (!f.isDirectory()){
                item.setSize(calculateSize(f.length()));
            }else if (f.isDirectory()){
                item.setSize(f.listFiles().length + " items");
            }
            itemList.add(item);
        }
        return itemList;
    }

    public String calculateSize(long size){
        String t_size = "";
        if (size <= 1024){
            t_size = size + "B";
        }else if (size > 1024 && size <= 1024 * 1024){
            size /= 1024;
            t_size = size + "KB";
        }else if (size > 1024 * 1024 && size <= 1024 * 1024 * 1024){
            size = size / (1024 * 1024);
            t_size = size + "MB";
        }else {
            size = size / (1024 * 1024 * 1024);
            t_size = size + "GB";
        }
        return t_size;
    }
}
