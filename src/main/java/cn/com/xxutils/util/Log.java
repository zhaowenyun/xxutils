package cn.com.xxutils.util;

/**
 * Created by Administrator on 2016/5/10.
 */
public class Log {
    private Log() {

    }

    public static void d(String msg) {
        android.util.Log.d("libs-xxUtils", msg);
    }

    public static void e(String msg) {
        android.util.Log.e("libs-xxUtils", msg);
    }

}
