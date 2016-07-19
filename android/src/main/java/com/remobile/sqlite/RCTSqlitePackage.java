package com.remobile.sqlite;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.ReactContextBaseJavaModule;


public class RCTSqlitePackage extends ReactContextBaseJavaModule implements ReactPackage {

    private Activity activity;
    private SQLitePlugin mModuleInstance;

  /*  public RCTSqlitePackage(ReactApplicationContext reactContext) {
        super(reactContext);
    } */


    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        mModuleInstance = new SQLitePlugin(reactContext, getCurrentActivity());
        return Arrays.<NativeModule>asList(
                mModuleInstance
        );
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }
    
    public String getName(){
        return "sqlite";
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList();
    }

    public void onDestroy() {
        if (mModuleInstance != null) {
            mModuleInstance.onDestroy();
        }
    }
}
