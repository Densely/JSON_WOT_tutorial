package com.densely.jsonwottutorial;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 17.11.13
 * Time: 0:12
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static Typeface getTypeface(Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "font/font.ttf");

        return typeface;
    }


}
