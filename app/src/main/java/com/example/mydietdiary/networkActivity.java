package com.example.mydietdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class networkActivity extends AppCompatActivity {
    TextView textView;
    Button button1;
    WifiReceiver wifiReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network);

        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkConnectivity();
            }
        });

        wifiReceiver = new WifiReceiver();
    }

    private void checkConnectivity() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            if(info.getType() == ConnectivityManager.TYPE_WIFI) {
                println("WIFI로 설정됨");
            } else if(info.getType() == ConnectivityManager.TYPE_MOBILE) {
                println("일반 망으로 설정됨");
            }
            println("연결 여부 : " + info.isConnected());
        } else {
            println("데이터 통신 불가");
        }
    }

    private void println(String str) {
        textView.append(str + "\n");
    }

    class WifiReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
                int state = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
                if(state == WifiManager.WIFI_STATE_ENABLED) {
                    println("Wifi enabled");
                } else if (state == WifiManager.WIFI_STATE_DISABLED) {
                    println("Wifi disabled");
                }
            } else if (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
                NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                WifiManager manager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                String ssid = manager.getConnectionInfo().getSSID();

                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    println("Connected : " + ssid);
                } else if(info.getState() == NetworkInfo.State.DISCONNECTED) {
                    println("Disconnected : " + ssid);
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(wifiReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(wifiReceiver);
    }
}
