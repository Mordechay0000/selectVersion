package com.mordechay.mefateach.selectversion;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int INDEFINITE = 0;
    public static final int SWITCH_OFF = 1;
    public static final int SWITCH_ON = 2;
    public static final int SWITCH_DISABLE_OFF = 3;
    public static final int SWITCH_DISABLE_ON = 4;
    public static final int SWITCH_LATER = 5;

    public static final HashMap[] VALUE = new HashMap[]{
            new HashMap<String, Integer>() {{
                put("internet", Constants.INDEFINITE);
                put("google_play_services", Constants.INDEFINITE);
                put("google_play", Constants.INDEFINITE);
                put("kosher_play", Constants.INDEFINITE);
                put("install_packages", Constants.INDEFINITE);
                put("connect_to_computer", Constants.INDEFINITE); /* disable */
                put("system_app_player", Constants.INDEFINITE);
                put("system_app_video", Constants.INDEFINITE);
                put("system_app_camera", Constants.INDEFINITE);
                put("system_app_gallery", Constants.INDEFINITE);
                put("system_app_file_explorer", Constants.INDEFINITE);
                put("system_app_messages", Constants.INDEFINITE); /* disable */
                put("system_app_remote", Constants.INDEFINITE);
            }},
            new HashMap<String, Integer>() {{
                put("internet", Constants.SWITCH_ON);
                put("google_play_services", Constants.SWITCH_DISABLE_ON);
                put("google_play", Constants.SWITCH_DISABLE_ON);
                put("kosher_play", Constants.SWITCH_DISABLE_ON);
                put("install_packages", Constants.SWITCH_ON);
                put("connect_to_computer", Constants.SWITCH_OFF); /* disable */
                put("system_app_player", Constants.SWITCH_OFF);
                put("system_app_video", Constants.SWITCH_ON);
                put("system_app_camera", Constants.SWITCH_ON);
                put("system_app_gallery", Constants.SWITCH_ON);
                put("system_app_file_explorer", Constants.SWITCH_ON);
                put("system_app_messages", Constants.SWITCH_ON); /* disable */
                put("system_app_remote", Constants.SWITCH_ON);
            }},
            new HashMap<String, Integer>() {{
                put("internet", Constants.SWITCH_ON);
                put("google_play_services", Constants.SWITCH_ON);
                put("google_play", Constants.SWITCH_ON);
                put("kosher_play", Constants.SWITCH_ON);
                put("install_packages", Constants.SWITCH_ON);
                put("connect_to_computer", Constants.SWITCH_OFF); /* disable */
                put("system_app_player", Constants.SWITCH_OFF);
                put("system_app_video", Constants.SWITCH_OFF);
                put("system_app_camera", Constants.SWITCH_OFF);
                put("system_app_gallery", Constants.SWITCH_OFF);
                put("system_app_file_explorer", Constants.SWITCH_OFF);
                put("system_app_messages", Constants.SWITCH_ON); /* disable */
                put("system_app_remote", Constants.SWITCH_ON);
            }},
            new HashMap<String, Integer>() {{
                put("internet", Constants.SWITCH_ON);
                put("google_play_services", Constants.SWITCH_ON);
                put("google_play", Constants.SWITCH_ON);
                put("kosher_play", Constants.SWITCH_ON);
                put("install_packages", Constants.SWITCH_ON);
                put("connect_to_computer", Constants.SWITCH_OFF); /* disable */
                put("system_app_player", Constants.SWITCH_OFF);
                put("system_app_video", Constants.SWITCH_OFF);
                put("system_app_camera", Constants.SWITCH_OFF);
                put("system_app_gallery", Constants.SWITCH_OFF);
                put("system_app_file_explorer", Constants.SWITCH_OFF);
                put("system_app_messages", Constants.SWITCH_OFF); /* disable */
                put("system_app_remote", Constants.SWITCH_ON);
            }}
    };



    public static final int[] IMAGE = new int[]{R.drawable.ic_launcher_browser, R.drawable.ic_launcher_kosher_play, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_app, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_browser, R.drawable.ic_launcher_gallery3d};
    public static final String[] TITLE = new String[]{"אינטרנט", "כשר פליי", "שירותי גוגל פליי", "חנות גוגל פליי", "התקנת אפליקציות", "חיבור למחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
    public static final String[] SUB_TITLE = new String[]{"גישה לאינטרנט ע\"י נתונים ניידים/wifi", "אפליקציית כשר פליי", "שירותי גוגל פלי", "חנות גוגל פלי", "אפשרות להתקין אפליקציות ממקור חיצוני", "חיבור המכשיר להעברת מדיה מהמחשב", "אפליקצית sms", "אפליקצית מוזיקה", "אפליקצית קבצים", "אפליקצית מצלמה", "אפליקצית גלריה", "אפליקצית גלריה ללא וידאו", "שלט למזגן"};
}
