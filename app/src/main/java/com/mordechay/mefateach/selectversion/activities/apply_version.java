package com.mordechay.mefateach.selectversion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.mordechay.mefateach.selectversion.R;
import com.mordechay.mefateach.selectversion.data.Constants;
import com.mordechay.mefateach.selectversion.data.DataTransfer;
import com.mordechay.mefateach.selectversion.data.DeviceEnum;

import java.io.IOException;

public class apply_version extends AppCompatActivity {

    private boolean isLater = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_version);

        Bundle extras = getIntent().getExtras();

        int[] valueArray = extras.getIntArray("valueArray");


        String[][] commandArray;
        commandArray = (DataTransfer.device == DeviceEnum.QIN_F22) ?
                Constants.COMMAND_ARRAY_QIN_F22 :
                (DataTransfer.device == DeviceEnum.QIN_F21_PRO)?
                        Constants.COMMAND_ARRAY_QIN_F21_PRO :
                        (DataTransfer.device == DeviceEnum.QIN_F22_PRO)?
                                Constants.COMMAND_ARRAY_QIN_F22_PRO :
                                (DataTransfer.device == DeviceEnum.XINGYU_S500)?
                                        Constants.COMMAND_ARRAY_XINGYU_S500 :
                                null
        ;

        Process command;
        try{
            command = Runtime.getRuntime().exec("su -c mount -o rw,remount /" + "\n");
            Log.e("1", command.getOutputStream() + "|" + command.getErrorStream());
            command = Runtime.getRuntime().exec("su -c mount -o rw,remount /system" + "\n");
            Log.e("2", command.getOutputStream() + "|" + command.getErrorStream());
            command = Runtime.getRuntime().exec("su -c mount -o rw,remount /vendor" + "\n");
            Log.e("3", command.getOutputStream() + "|" + command.getErrorStream());
            command = Runtime.getRuntime().exec("su -c mount -o rw,remount /product" + "\n");
            Log.e("4", command.getOutputStream() + "|" + command.getErrorStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

int d = 0;
        int c = 0;
        for (int i = 0; d < valueArray.length; i++) {
            if(valueArray[d] == 1) {

            }else if(valueArray[d] == Constants.SWITCH_ON){
                c=0;
                for (int b = 0; c < commandArray[d].length; b++) {
                    try {
                        Log.d("d | c", String.valueOf(d)+ "   |    " + String.valueOf(c));
                        command = Runtime.getRuntime().exec(commandArray[d][c] + "\n");
                        Log.d(String.valueOf(d + 5), commandArray[d][c]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    c= c +1;
                }
            }else if(valueArray[d] == Constants.SWITCH_LATER){
                isLater = true;
            }
            d = d +1;
        }

        if(!isLater){
            try {
                command = Runtime.getRuntime().exec("su -c rm system/app/selectVersion/selectVersion.apk" + "\n");
                Log.e("30", command.getOutputStream() + "|" + command.getErrorStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            command = Runtime.getRuntime().exec("su -c reboot" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}