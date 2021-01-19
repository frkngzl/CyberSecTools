package com.h5190033.furkan_guzel_final.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
// Gerekli kütüphaneleri import edildi.
import com.h5190033.furkan_guzel_final.R;


public class AlertDialogUtil {
//Bu dosya AlertDialogUtil içindir.
    public static void alertDialogShow(Context context, String title, String message, String yes, String no ,String screen)
    {
        //AlertDialog göstermek için hazırlanmış fonksiyon.
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(screen.toString() == context.getResources().getString(R.string.SplashActivity)){
                    context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                    //Eğer pozitif butona basılırsa telefon ayarlarına gitmesini sağlar.
                }
                else{
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(screen.toString() == context.getResources().getString(R.string.SplashActivity)){
                    ((Activity)context).finish();
                    //Eğer negatif tuşa basılırsa işlemi bitirir.
                }
                else{
                    window.dismiss();
                }

            }
        });
        builder.show();
    }

}