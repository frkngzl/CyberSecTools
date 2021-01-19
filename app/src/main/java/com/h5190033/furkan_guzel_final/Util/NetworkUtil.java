package com.h5190033.furkan_guzel_final.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
// Gerekli kütüphaneleri import edildi.

public class NetworkUtil {
    //NetworkUtil fonksiyonu için hazırlanmış dosya.
    public  static  boolean internetControl(Context context)
    {
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //Bağlantı kontrolü için.
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return  true;
            //İnternet erişimi varsa true döndürür yoksa false döndürür.
        }
        else {
            return  false;
        }

    }

}