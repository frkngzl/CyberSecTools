package com.h5190033.furkan_guzel_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
// Gerekli kütüphaneleri import edildi.
import com.h5190033.furkan_guzel_final.Model.CyberSecModel;
import com.h5190033.furkan_guzel_final.R;
import com.h5190033.furkan_guzel_final.Util.Constants;
import com.h5190033.furkan_guzel_final.Util.GladeUtil;
import com.h5190033.furkan_guzel_final.Util.ObjectUtil;
//Bu dosya AracDetay ekranıdır.
public class AracDetayActivity extends AppCompatActivity {


    ImageView img_d_kapak;
    TextView txt_d_baslik;
    TextView txt_d_detay;
    TextView txt_d_website;
    TextView txt_d_release;
    //Gerekli değişkenler belirlenmiştir.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_detay); //Açılışta çalışan metod, layout olarak activity_arac_detay' a set edilmiştir.

        init(); // init fonksiyonunu çalıştırır.

    }

    private void init() {
        //tasinanAracString adında bir String değer oluşturur, Constants tan TIKLANAN_ARAC_BASLIK ile eşler.
        String tasinanAracString = getIntent().getStringExtra(Constants.TIKLANAN_ARAC_BASLIK);
        //CyberSecModel i buraya getirir.
        CyberSecModel CyberSecModel = ObjectUtil.jsonStringToArac(tasinanAracString);
        //değerleri gerekli layout id leri ile eşler.
        img_d_kapak = findViewById(R.id.img_d_kapak);
        txt_d_baslik = findViewById(R.id.txt_d_baslik);
        txt_d_detay = findViewById(R.id.txt_d_detay);
        txt_d_website = findViewById(R.id.txt_d_website);
        txt_d_release = findViewById(R.id.txt_d_stable_release);
        //CyberSecModel den değerler için gerekli olan verileri çeker. Değerlerin verileri ile değiştirir.
        txt_d_baslik.setText(CyberSecModel.getToolName());
        txt_d_detay.setText(CyberSecModel.getDescription());
        txt_d_website.setText(CyberSecModel.getWebsite());
        txt_d_release.setText(CyberSecModel.getStableRelease());

        GladeUtil.resmiIndiripGoster(getApplicationContext(),CyberSecModel.getHeaderImageURL(),img_d_kapak);
        //img_d_kapak için resim indirir ve setler.
    }
}