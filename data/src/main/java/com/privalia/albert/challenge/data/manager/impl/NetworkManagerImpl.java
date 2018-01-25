package com.privalia.albert.challenge.data.manager.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.HashMap;
import java.util.Map;

import com.privalia.albert.challenge.data.manager.NetworkManager;

public class NetworkManagerImpl extends BroadcastReceiver implements NetworkManager {

    private Context context;

    private boolean available = false;

    private IntentFilter connectivityIntentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

    private Map<String, Listener> mListeners = new HashMap<>();

    public NetworkManagerImpl() {
        super();
    }

    public NetworkManagerImpl(Context context) {
        super();
         this.context = context;
         this.available = isNetworkAvailable();
        //registerConnectivityNetworkMonitorForAPI21AndUp();
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        this.context.registerReceiver(this, connectivityIntentFilter);
    }

    @Override
    public void stop() {
        this.context.unregisterReceiver(this);
    }

    @Override
    public void add(String tag, Listener listener) {
        mListeners.put(tag, listener);
    }

    @Override
    public void remove(String tag) {
        mListeners.remove(tag);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Entra receive -> " + intent.getAction());
        if (!isInitialStickyBroadcast()) {
            boolean available = isNetworkAvailable();

            // This will guarantee that listeners are called only when network state changes.
            if (this.available != available) {
                this.available = available;
                for (Listener listener : mListeners.values()) {
                    if (listener != null) {
                        if (available) listener.onNetworkAvailable();
                        else listener.onNetworkDown();
                    }
                }
            }
        }
    }
}