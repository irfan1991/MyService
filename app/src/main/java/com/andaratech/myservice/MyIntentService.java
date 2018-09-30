package com.andaratech.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
    public static String EXTRA_DURATION ="extra_duration";
    public static final String TAG = "MyIntentService";
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        if (intent != null) {
           int duration = intent.getIntExtra(EXTRA_DURATION,0);
           try{
               Thread.sleep(duration);
           }catch (InterruptedException e){
               e.printStackTrace();
               Thread.currentThread().interrupt();
           }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}
