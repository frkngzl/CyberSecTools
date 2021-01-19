package com.h5190033.furkan_guzel_final.Util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.h5190033.furkan_guzel_final.R;
// Gerekli kütüphaneleri import edildi.

public class GladeUtil {
    //GladeUtil fonksiyonu için hazırlanmış dosya.
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        //Gerekli URL den gerekli resmi indirip göstermek için hazırlanmış fonksiyon.
        Glide.with(context)
                .load(url)
                .error(R.drawable.aciklamakapak)
                .centerCrop()
                .into(img);
    }
}