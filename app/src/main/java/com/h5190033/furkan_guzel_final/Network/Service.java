package com.h5190033.furkan_guzel_final.Network;

import com.h5190033.furkan_guzel_final.Util.Constants;
// Gerekli kütüphaneleri import edildi.
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    //Bu dosya Service fonksiyonu için hazırlanmıştır..

    private static Retrofit retrofit;
    //Retrofit tanımlanmıştır.
    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static OkHttpClient okHttpClient;

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient().newBuilder().build();
        }

        return okHttpClient;
    }

    ServiceApi serviceApi;
    //ServiceApi tanımlanmış.
    public ServiceApi getServiceApi() {
    //ServiceApi fonksiyonu.
        if (serviceApi == null) {
            serviceApi = getRetrofit().create(ServiceApi.class);
        }

        return serviceApi;
    }
}