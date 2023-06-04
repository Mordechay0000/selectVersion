package com.mordechay.mefateach.selectversion;

public class Constants {

    public static final int INDEFINITE = 0;
    public static final int SWITCH_OFF = 1;
    public static final int SWITCH_ON = 2;
    public static final int SWITCH_DISABLE_OFF = 3;
    public static final int SWITCH_DISABLE_ON = 4;
    public static final int SWITCH_LATER = 5;

    public static final int[][] VALUE = new int[][]{
            {Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE/* disable */, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE, Constants.INDEFINITE/* disable */, Constants.INDEFINITE}, //default
            {Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_OFF/* disable */, Constants.SWITCH_OFF, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON/* disable */, Constants.SWITCH_ON},
            {Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_OFF/* disable */, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_ON/* disable */, Constants.SWITCH_ON},
            {Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_ON, Constants.SWITCH_OFF/* disable */, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF, Constants.SWITCH_OFF/* disable */, Constants.SWITCH_ON}
    };


    public static final int[] IMAGE = new int[]{R.drawable.ic_launcher_browser, R.drawable.ic_launcher_kosher_play, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_gallery3d};
    public static final String[] TITLE = new String[]{"אינטרנט", "כשר פליי", "שירותי גוגל פליי", "חנות גוגל פליי", "התקנת אפליקציות", "חיבור למחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
    public static final String[] SUB_TITLE = new String[]{"גישה לאינטרנט ע\"י נתונים ניידים/wifi", "אפליקציית כשר פליי", "שירותי גוגל פלי", "חנות גוגל פלי", "אפשרות להתקין אפליקציות ממקור חיצוני", "חיבור המכשיר להעברת מדיה מהמחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
}
