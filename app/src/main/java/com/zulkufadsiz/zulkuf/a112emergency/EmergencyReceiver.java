package com.zulkufadsiz.zulkuf.a112emergency;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zulkuf on 12/4/17.
 */

public class EmergencyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String number  = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if (intent.getAction() == Intent.ACTION_NEW_OUTGOING_CALL){
            if(number.equals("112")) {
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (!mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.enable();
                    Toast.makeText(context, "112 Aranıyor", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}
