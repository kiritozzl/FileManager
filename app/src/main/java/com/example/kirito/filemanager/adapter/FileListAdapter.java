package com.example.kirito.filemanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kirito.filemanager.R;
import com.example.kirito.filemanager.entity.Item;
import com.example.kirito.filemanager.support.OpenFiles;

import java.util.List;

/**
 * Created by kirito on 2016/9/9.
 */
public class FileListAdapter extends BaseAdapter {
    private Context context;
    private String path;
    private List<Item> itemList;

    public FileListAdapter(Context context, String path) {
        this.context = context;
        this.path = path;
        itemList = new OpenFiles(path).openFiles();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fileitem,null);
            holder = new viewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_size = (TextView) convertView.findViewById(R.id.tv_size);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }
        Item item = itemList.get(position);
        holder.tv_name.setText(item.getName());
        holder.tv_size.setText(item.getSize());
        return convertView;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class viewHolder{
        TextView tv_name;
        TextView tv_size;
    }
}
