package com.example.android.servicetest.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.servicetest.R;

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
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        Notification notification = new Notification.Builder(MyService.this)
                                    .setContentTitle("this is title")
                                    .setSmallIcon(R.drawable.as)
                                    .build();
        startForeground(1,notification);

        Log.d("Myservice","onCreate executed");

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
