package com.h5190033.furkan_guzel_final.Util;

import com.google.gson.Gson;
import com.h5190033.furkan_guzel_final.Model.CyberSecModel;
// Gerekli kütüphaneleri import edildi.

public class ObjectUtil {
    //ObjectUtil fonksiyonu için hazırlanmış dosya.
    public  static String aracToJsonString(CyberSecModel aracmodel)
    {
        Gson gson = new Gson();
        return   gson.toJson(aracmodel);
        //aracmodel return edilmiş.
    }

    public  static CyberSecModel jsonStringToArac(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,CyberSecModel.class);
        //CyberSecModel return edilmiş.
    }
}
