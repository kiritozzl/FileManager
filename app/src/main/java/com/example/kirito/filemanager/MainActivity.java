package com.example.kirito.filemanager;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String sd_path;
    private String internal_path;

    private Button btn;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sd_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        //internal_path = this.getFilesDir().getAbsolutePath();
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FileList.class);
                intent.putExtra("path",sd_path);
                startActivity(intent);
            }
        });
        Log.e(TAG, "onCreate: sd_path---"+sd_path );
    }
}
