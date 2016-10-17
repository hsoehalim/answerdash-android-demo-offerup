package com.answerdash.android.demo.offerup;

import android.app.Application;

import com.answerdash.android.sdk.AnswerDash;

public class App extends Application {

    private static final String TEST_SITE_ID = "889";

    @Override
    public void onCreate() {

        super.onCreate();
        AnswerDash.INSTANCE.setSiteID(this, TEST_SITE_ID);
    }

}
