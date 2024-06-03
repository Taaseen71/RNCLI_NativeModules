package com.nativemoduleapp;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class GetDeviceID extends ReactContextBaseJavaModule{

    private static ReactApplicationContext reactContext;

    public GetDeviceID(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void show(){
        Toast.makeText(reactContext, "Hi from Android", Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void getDeviceID(Promise promise) {
        try {
            String android_ID = Settings.Secure.getString(reactContext.getContentResolver(), Settings.Secure.ANDROID_ID);
            promise.resolve(android_ID);
        } catch (Exception e) {
            promise.reject("error", e.getMessage()); // Reject with error message
        }
    }

    @NonNull
    @Override
    public String getName() {
        return "ABC";
    }
}
