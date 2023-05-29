package com.mordechay.mefateach.selectversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class apply_version extends AppCompatActivity {

    Bundle extras;
    int[] valueArray;
    String[][] commandArray;
    Process command;
    boolean isLater = false;
    boolean[] isBlockedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_version);

        extras = getIntent().getExtras();

        valueArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
        isBlockedArray = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false};
        valueArray = extras.getIntArray("valueArray");
        isBlockedArray = extras.getBooleanArray("isBlockedArray");

        commandArray = new String[][]{
                {
                    "su -c rm vendor/bin/hw/wpa_supplicant",
                        "su -c rm system/etc/apns-conf.xml",
                        "su rm -rf system/app/KosherPlay/KosherPlay.apk",
                        "su -c cp system/tmp/MtkSettings.apk system/system_ext/priv-app/MtkSettings",
                        "su -c chmod 644 system/system_ext/priv-app/MtkSettings/MtkSettings.apk",
                        "su -c cp system/tmp/MtkSystemUI.apk system/system_ext/priv-app/MtkSystemUI",
                        "su -c chmod 644  system/system_ext/priv-app/MtkSystemUI/MtkSystemUI.apk"
                },
                {
                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",
                },
                {
                    "su -c pm uninstall com.android.vending",
                        "su -c pm uninstall com.google.android.gms",
                        "su -c rm system/system_ext/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                        "su -c rm system/system_ext/priv-app/Phonesky/Phonesky.apk",
                        "su -c rm system/system_ext/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk",
                        "su -c rm system/system_ext/priv-app/SetupWizard/SetupWizard.apk"
                },
                {
                        "su -c pm disable com.android.vending",
                        "su -c cp /system/tmp/hosts  /system/etc/",
                        "su -c cp /system/tmp/init.rc  /system/etc/init/hw/"
                },
                {
                        "su -c cp /system/tmp/GooglePackageInstaller.apk  /system/system_ext/priv-app/GooglePackageInstaller/",
                        "su -c chmod 644   /system/system_ext/priv-app/GooglePackageInstaller/GooglePackageInstaller.apk"
                },
                {
                        "su -c rm system/priv-app/MtpService/MtpService.apk"
                },
                {
                        "su -c rm system/app/DqMusic/DqMusic.apk"
                },
                {
                        "su -c cp system/tmp/MtkGallery2.apk system/system_ext/priv-app/MtkGallery2",
                        "su -c chmod 644 system/system_ext/priv-app/MtkGallery2/MtkGallery2.apk"
                },
                {
                        "su -c rm system/system_ext/app/Camera/Camera.apk"

                },
                {
                        "su -c rm system/system_ext/priv-app/MtkGallery2/MtkGallery2.apk"
                },
                {
                        "su -c rm system/priv-app/DocumentsUI/DocumentsUI.apk"

                },
                {
                        "su -c rm system/priv-app/MtkMms/MtkMms.apk"
                },
                {
                        "su -c rm system/app/Remote/Remote.apk"
                },
        };

        try{
            command = Runtime.getRuntime().exec("su -c mount -o rw,remount /" + "\n");
            Log.e("1",command.getOutputStream() + "|" + command.getErrorStream());
            command = Runtime.getRuntime().exec("su -c mount -o rw,remount /vendor" + "\n");
            Log.e("2",command.getOutputStream() + "|" + command.getErrorStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

int d = 0;
        int c = 0;
        for (int i = 0; d <= valueArray.length - 1; i++) {
            if(valueArray[d] == 1) {

            }else if(valueArray[d] == 2 && !isBlockedArray[d]){
                c=0;
                for (int b = 0; c < commandArray[d].length; b++) {
                    try {
                        Log.d("d | c", String.valueOf(d)+ "   |    " + String.valueOf(c));
                        command = Runtime.getRuntime().exec(commandArray[d][c] + "\n");
                        Log.d(String.valueOf(d + 3),commandArray[d][c]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    c= c +1;
                }
            }else if(valueArray[d] == 3){
                isLater = true;
            }
            d = d +1;
        }

        if(!isLater){
            try {
                command = Runtime.getRuntime().exec("su -c rm system/app/selectVersion/selectVersion.apk" + "\n");
                Log.e("30",command.getOutputStream() + "|" + command.getErrorStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /* try {
            //command = Runtime.getRuntime().exec("su -c reboot" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}