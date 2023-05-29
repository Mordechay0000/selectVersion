package com.mordechay.mefateach.selectversion;

public class Constants {

    public static final int[][] VALUE = new int[][]{
            {0, 0, 0, 0, 0, 0/* no graphi */, 0, 0, 0, 0, 0, 0/* no graphi */, 0}, //default
            {2, 2, 2, 2, 2, 1/* no graphi */, 1, 2, 2, 2, 2, 2/* no graphi */, 2},
            {2, 2, 2, 2, 2, 1/* no graphi */, 1, 1, 1, 1, 1, 2/* no graphi */, 2},
            {2, 2, 2, 2, 2, 1/* no graphi */, 1, 1, 1, 1, 1, 1/* no graphi */, 2}
    };

    public static final boolean[][] IS_BLOCKED_CUSTOMIZE = new boolean[][]{
            {false, false, false, false, false, false, false, false, false, false, false, false, false}, //default
            {false, true, false, true, false, false, false, true, false, false, false, false, false},
            {false, true, false, true, false, false, false, false, false, false, false, false, false},
            {false, true, false, true, false, false, false, false, false, false, false, false, false}
    };



    public static final int[] IMAGE = new int[]{R.drawable.ic_launcher_browser, R.drawable.ic_launcher_kosher_play, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_gallery3d};
    public static final String[] TITLE = new String[]{"אינטרנט", "כשר פליי", "שירותי גוגל פליי", "חנות גוגל פליי", "התקנת אפליקציות", "חיבור למחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
    public static final String[] SUB_TITLE = new String[]{"גישה לאינטרנט ע\"י נתונים ניידים/wifi", "אפליקציית כשר פליי", "שירותי גוגל פלי", "חנות גוגל פלי", "אפשרות להתקין אפליקציות ממקור חיצוני", "חיבור המכשיר להעברת מדיה מהמחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
}
