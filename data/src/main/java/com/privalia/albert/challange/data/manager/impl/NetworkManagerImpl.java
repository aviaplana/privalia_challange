package com.privalia.albert.challange.data.manager.impl;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;

import java.util.HashMap;
import java.util.Map;

import com.privalia.albert.challange.data.manager.NetworkManager;

public class NetworkManagerImpl extends BroadcastReceiver implements NetworkManager {

    private Context mContext;

    private boolean mAvailable = false;

    private IntentFilter connectivityIntentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

    private Map<String, Listener> mListeners = new HashMap<>();

    public NetworkManagerImpl() {
        super();
    }

    public NetworkManagerImpl(Context context) {
        super();
         mContext = context;
         mAvailable = isNetworkAvailable();
        //registerConnectivityNetworkMonitorForAPI21AndUp();
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        mContext.registerReceiver(this, connectivityIntentFilter);
    }

    @Override
    public void stop() {
        mContext.unregisterReceiver(this);
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
            if (mAvailable != available) {
                mAvailable = available;
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