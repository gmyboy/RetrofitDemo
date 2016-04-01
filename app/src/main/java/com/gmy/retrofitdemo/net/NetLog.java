package com.gmy.retrofitdemo.net;

import android.util.Log;

/**
 * Created by gmy on 16/4/1.
 * E-mail me via gmyboy@qq.com
 */
public class NetLog {
    public final static int VERBOS = 1;
    public final static int DEBUG = 2;
    public final static int INFO = 3;
    public final static int WARN = 4;
    public final static int ERROR = 5;
    private static int logLevel = 0;

    public static void setLogLevel(int level) {
        logLevel = level;
    }

    public static void v(String msg) {
        if (VERBOS > logLevel) {
            Log.v(getTag(), msg);
        }
    }

    public static void d(String msg) {
        if (DEBUG > logLevel) {
            try {
                Log.d(getTag(), msg);
            } catch (RuntimeException ex) {
                System.out.println(String.format("%s,%s", getTag(), msg));
            }
        }
    }

    public static void i(String msg) {
        if (INFO > logLevel) {
            Log.i(getTag(), msg);
        }
    }

    public static void w(String msg) {
        if (WARN > logLevel) {
            Log.w(getTag(), msg);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (ERROR > logLevel) {
            Log.e(getTag(), msg, tr);
        }
    }

    public static String getTag() {
        String tag = "Log_em";
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        /*for(int i=0; i<elements.length; i++){
            System.out.println(i+"   :"+elements[i].getClassName());
		}*/
        if (elements.length > 3) {
            String fullClassName = elements[4].getClassName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            String methodName = elements[4].getMethodName();
            int lineNumber = elements[4].getLineNumber();
            tag = className + "." + methodName + "():" + lineNumber;
        }
        return tag;
    }
}
