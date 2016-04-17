package com.example.android.servicetest.app;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by windog on 2016/4/16.
 */
public class MyService extends Service {

    private DownloadBinder mbinder = new DownloadBinder();


    class DownloadBinder extends Binder {
        public void startDownload(){
            Log.d("MyService","start download");
        }

        public int getProgress(){
            Log.d("Myservice","getProgress");
            return 0;
        }


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {   //用于与Activity之间的通信
        return mbinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
