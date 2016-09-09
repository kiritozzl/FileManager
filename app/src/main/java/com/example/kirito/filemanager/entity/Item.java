package com.example.kirito.filemanager.entity;

/**
 * Created by kirito on 2016/9/9.
 */
public class Item {
    private String name;
    private String size;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
