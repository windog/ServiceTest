package com.example.android.servicetest.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.servicetest.R;

public class MainActivity extends AppCompatActivity {

    Button startservices;
    Button stopservices;
    Button bindService;
    Button unbindtService;
    private MyService.DownloadBinder downloadBinder;

    /* ServiceConnection 去找 Service 中的 binder ,与service取得关联
    *  必须是个全局变量 global variable  */
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startservices = (Button) findViewById(R.id.start_Service);
        stopservices = (Button) findViewById(R.id.stop_Service);
        bindService = (Button) findViewById(R.id.bindService);
        unbindtService = (Button) findViewById(R.id.unbindService);

        startservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        stopservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });

        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                bindService(intent,connection,BIND_AUTO_CREATE);
            }
        });

        unbindtService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });
    }


}
