package com.dilloday.jimmy.dilloday.Classes;

/**
 * Created by Jimmy on 1/23/2017.
 */
import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;


public class GCMTokenRefreshListenerService extends InstanceIDListenerService {

    //If the token is changed registering the device again
    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, GCMRegistrationIntentService.class);
        startService(intent);
    }
}
