package com.h5190033.furkan_guzel_final.Network;

import com.h5190033.furkan_guzel_final.Model.CyberSecModel;

import java.util.List;
// Gerekli kütüphaneleri import edildi.
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    //ServiceApi fonksiyonu, cybersecuritytools.json'ı çeker ve CyberSecModel deki araclarigetir fonksiyonu ile bağlar.
    @GET("cybersecuritytools.json")
    Observable<List<CyberSecModel>> araclarigetir();
}