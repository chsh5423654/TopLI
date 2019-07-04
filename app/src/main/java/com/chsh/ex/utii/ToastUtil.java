package com.chsh.ex.utii;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private static Toast mToast;

    public static void showToast(Context mContext, String text, int duration) {

        if (mToast == null) {
            mToast = Toast.makeText(mContext.getApplicationContext(), text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void showToast(Context mContext, int resId, int duration) {
        showToast(mContext, mContext.getResources().getString(resId), duration);
    }

    public static void showToast(Context context, String string) {
        showToast(context, string, Toast.LENGTH_SHORT);
    }

}