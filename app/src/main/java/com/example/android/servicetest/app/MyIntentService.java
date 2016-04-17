package com.example.android.servicetest.app;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by windog on 2016/4/17.
 */
public class MyIntentService extends IntentService {
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService", "id is" + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "destroy");
    }

    public MyIntentService() {
        super("MyIntentService");  //调用父类有参构造函数
    }
}
