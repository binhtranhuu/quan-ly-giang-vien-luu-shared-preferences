package com.example.tranhuubinhb17dcat023.storage;

import android.content.Context;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "quan_ly_giang_vien";
    private static SharedPrefManager mInstance;
    private Context ctx;

    private SharedPrefManager(Context ctx) {
        this.ctx = ctx;
    }

    public static synchronized SharedPrefManager getInstace(Context ctx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(ctx);
        }
        return mInstance;
    }
}
