package com.dilloday.jimmy.dilloday.Main;

/**
 * Created by jsonh on 7/12/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, com.dilloday.jimmy.dilloday.Main.MainActivity.class);
        startActivity(intent);
        finish();
    }
}
