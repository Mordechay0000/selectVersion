package com.mordechay.mefateach.selectversion.data;

import com.mordechay.mefateach.selectversion.R;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    //splash screen DELAY
    public static final int SPLASH_SCREEN_DELAY = 1000;


    public static final int INDEFINITE = 0;
    public static final int SWITCH_OFF = 1;
    public static final int SWITCH_ON = 2;
    public static final int SWITCH_DISABLE_OFF = 3;
    public static final int SWITCH_DISABLE_ON = 4;
    public static final int SWITCH_LATER = 5;

    public static final int INTERNET = 0;
    public static final int GOOGLE_PLAY_SERVICES = 1;
    public static final int GOOGLE_PLAY = 2;
    public static final int KOSHER_PLAY = 3;
    public static final int INSTALL_PACKAGES = 4;
    public static final int CONNECT_TO_COMPUTER = 5;
    public static final int SYSTEM_APP_PLAYER = 6;
    public static final int SYSTEM_APP_VIDEO = 7;
    public static final int SYSTEM_APP_CAMERA = 8;
    public static final int SYSTEM_APP_GALLERY = 9;
    public static final int SYSTEM_APP_FILE_EXPLORER = 10;
    public static final int SYSTEM_APP_MESSAGES = 11;
    public static final int SYSTEM_APP_REMOTE = 12;


    public static final int[][] valuesArray = new int[][]{
            {Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE,
                    Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE,
                    Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE},
            {Constants.SWITCH_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_DISABLE_ON,
                    Constants.SWITCH_ON, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_ON, Constants.SWITCH_ON,
                    Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_OFF},
            {Constants.SWITCH_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_ON,
                    Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF,
                    Constants.SWITCH_OFF, Constants.SWITCH_ON, Constants.SWITCH_OFF},
            {Constants.SWITCH_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_DISABLE_ON, Constants.SWITCH_ON,
                    Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF,
                    Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF}
    };


    public static final String[][] COMMAND_ARRAY_QIN_F22= new String[][]{
            {
                    "su -c rm vendor/bin/hw/wpa_supplicant",
                    "su -c rm system/etc/apns-conf.xml",
                    "su -c cp system/tmp/MtkSettings.apk system/system_ext/priv-app/MtkSettings",
                    "su -c chmod 644 system/system_ext/priv-app/MtkSettings/MtkSettings.apk",
                    "su -c cp system/tmp/MtkSystemUI.apk system/system_ext/priv-app/MtkSystemUI",
                    "su -c chmod 644  system/system_ext/priv-app/MtkSystemUI/MtkSystemUI.apk",

                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",

                    "su -c pm uninstall-system-updates com.android.vending",
                    "su -c pm uninstall-system-updates com.google.android.gms",
                    "su -c pm uninstall-system-updates com.google.android.gsf",
                    "su -c rm system/system_ext/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                    "su -c rm system/system_ext/priv-app/Phonesky/Phonesky.apk",
                    "su -c rm system/system_ext/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk"
            },
            {
                    "su -c pm uninstall-system-updates com.android.vending",
                    "su -c pm uninstall-system-updates com.google.android.gms",
                    "su -c pm uninstall-system-updates com.google.android.gsf",
                    "su -c rm system/system_ext/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                    "su -c rm system/system_ext/priv-app/Phonesky/Phonesky.apk",
                    "su -c rm system/system_ext/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk"
            },
            {
                    "su -c pm disable com.android.vending",
                    "su -c cp /system/tmp/hosts  /system/etc/",
                    "su -c cp /system/tmp/init.rc  /system/etc/init/hw/"
            },
            {
                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",
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


    public static final String[][] COMMAND_ARRAY_QIN_F21_PRO = new String[][]{
            {
                    "su -c rm vendor/bin/hw/wpa_supplicant",
                    "su -c rm system/etc/apns-conf.xml",
                    "su -c cp system/tmp/MtkSettings.apk system/system_ext/priv-app/MtkSettings",
                    "su -c chmod 644 system/system_ext/priv-app/MtkSettings/MtkSettings.apk",
                    "su -c cp system/tmp/MtkGallery2.apk system/system_ext/priv-app/MtkGallery2",
                    "su -c chmod 644 system/system_ext/priv-app/MtkGallery2/MtkGallery2.apk",

                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",

                    "su -c pm uninstall-system-updates com.android.vending",
                    "su -c pm uninstall-system-updates com.google.android.gms",
                    "su -c pm uninstall-system-updates com.google.android.gsf",
                    "su -c rm system/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                    "su -c rm system/priv-app/Phonesky/Phonesky.apk",
                    "su -c rm system/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk"
            },
            {
                    "su -c pm uninstall-system-updates com.android.vending",
                    "su -c pm uninstall-system-updates com.google.android.gms",
                    "su -c pm uninstall-system-updates com.google.android.gsf",
                    "su -c rm system/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                    "su -c rm system/priv-app/Phonesky/Phonesky.apk",
                    "su -c rm system/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk"
            },
            {
                    "su -c pm disable com.android.vending",
                    "su -c cp /system/tmp/hosts  /system/etc/",
                    "su -c cp /system/tmp/init.rc  /system/etc/init/hw/"
            },
            {
                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",
            },
            {
                    "su -c cp /system/tmp/GooglePackageInstaller.apk  /system/priv-app/GooglePackageInstaller/",
                    "su -c chmod 644   /system/priv-app/GooglePackageInstaller/GooglePackageInstaller.apk"
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

    public static final String[][] COMMAND_ARRAY_QIN_F22_PRO = new String[][]{
            {
                    "su -c rm vendor/bin/hw/wpa_supplicant",
                    "su -c rm system/etc/apns-conf.xml",
                    "su -c cp system/tmp/MtkSettings.apk system/system_ext/priv-app/MtkSettings",
                    "su -c chmod 644 system/system_ext/priv-app/MtkSettings/MtkSettings.apk",
                    "su -c cp system/tmp/MtkSystemUI.apk system/system_ext/priv-app/MtkSystemUI",
                    "su -c chmod 644  system/system_ext/priv-app/MtkSystemUI/MtkSystemUI.apk",

                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",

                    "su -c pm uninstall-system-updates com.android.vending",
                    "su -c pm uninstall-system-updates com.google.android.gms",
                    "su -c pm uninstall-system-updates com.google.android.gsf",
                    "su -c rm system/system_ext/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                    "su -c rm system/system_ext/priv-app/Phonesky/Phonesky.apk",
                    "su -c rm system/system_ext/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk"
            },
            {
                    "su -c pm uninstall-system-updates com.android.vending",
                    "su -c pm uninstall-system-updates com.google.android.gms",
                    "su -c pm uninstall-system-updates com.google.android.gsf",
                    "su -c rm system/system_ext/priv-app/PrebuiltGmsCore/PrebuiltGmsCore.apk",
                    "su -c rm system/system_ext/priv-app/Phonesky/Phonesky.apk",
                    "su -c rm system/system_ext/priv-app/GoogleServicesFramework/GoogleServicesFramework.apk"
            },
            {
                    "su -c pm disable com.android.vending",
                    "su -c cp /system/tmp/hosts  /system/etc/",
                    "su -c cp /system/tmp/init.rc  /system/etc/init/hw/"
            },
            {
                    "su rm -rf system/app/KosherPlay/KosherPlay.apk",
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


    public static final int[] IMAGE = new int[]{R.drawable.ic_launcher_browser, R.drawable.ic_launcher_kosher_play, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_gallery3d};
    public static final String[] TITLE = new String[]{"אינטרנט", "כשר פליי", "שירותי גוגל פליי", "חנות גוגל פליי", "התקנת אפליקציות", "חיבור למחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
    public static final String[] SUB_TITLE = new String[]{"גישה לאינטרנט ע\"י נתונים ניידים/wifi", "אפליקציית כשר פליי", "שירותי גוגל פלי", "חנות גוגל פלי", "אפשרות להתקין אפליקציות ממקור חיצוני", "חיבור המכשיר להעברת מדיה מהמחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
}
