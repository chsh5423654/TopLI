package com.chsh.ex.utii;


import com.orhanobut.logger.Logger;

/**
 * 日志
 */
public class LogUtis {

    private static final boolean isDeBug = true;

    public static void v(String message ,Object... objects){
        if (isDeBug){
            Logger.v( message , objects);
        }
    }

    public static void d(Object object){
        if (isDeBug){
            Logger.d(object);
        }
    }
    public static void d(String message ,Object... objects){
        if (isDeBug){
            Logger.d( message , objects);
        }
    }


    public static void i(String message ,Object... objects){
        if (isDeBug){
            Logger.i( message , objects);
        }
    }


    public static void w(String message ,Object... objects){
        if (isDeBug){
            Logger.w( message , objects);
        }
    }

    public static void e(String message ,Object... objects){
        if (isDeBug){
            Logger.e( message , objects);
        }
    }



}
