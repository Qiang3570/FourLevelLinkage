package com.johnny.fourlevellinkage;

import android.content.Context;
import android.widget.Toast;

/**
 * Success is the sum of small efforts, repeated day in and day out.
 * 成功就是日复一日那一点点小小努力的积累。
 *
 * 该类是用于方便吐司操作的工具类
 *
 * AndroidGroup：158423375
 * Author：Johnny
 * AuthorQQ：956595454
 * AuthorWX：Qiang_it
 * AuthorPhone：nothing
 * Created by 2016/12/2.
 */
public class ToastUtil {

    public static Toast toast;

    /**
     * 能够连续弹吐司，不用等上个消失
     * @param context
     * @param string
     */
    public static void showToast(Context context, String string){
        if(toast==null){
            toast=Toast.makeText(context,string,Toast.LENGTH_LONG);
        }
        toast.setText(string);
        toast.show();
    }
}