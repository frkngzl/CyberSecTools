package com.h5190033.furkan_guzel_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
// Gerekli kütüphaneleri import edildi.
import com.h5190033.furkan_guzel_final.R;
import com.h5190033.furkan_guzel_final.Util.AlertDialogUtil;
import com.h5190033.furkan_guzel_final.Util.NetworkUtil;

//Bu dosya Splash ekranıdır.
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); //Açılışta çalışan metod, layout olarak activity_splash' e set edilmiştir.
        init(); // init fonksiyonunu çalıştırır.

    }
    //Splash ekranı için sayaç fonksiyonu, ekranın 3 saniye açık kalmasını sağlar.
    private void init(){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

                Log.e("COUNTER","TİCK");
            }

            @Override
            public void onFinish() {

                if(NetworkUtil.internetControl(getApplicationContext())) {
                    opennextActivity();
                }
                else {
                    AlertDialogUtil.alertDialogShow(SplashActivity.this, getResources().getString(R.string.uyari),getResources().getString(R.string.internetBilgi),getResources().getString(R.string.ayarlariAc),getResources().getString(R.string.İnternetcikis),getResources().getString(R.string.SplashActivity));
                    //İnternet bağlantısı olmadığında splash ekranında alert dialog gösterilmesini sağlar.
                }
            }
        };

        countDownTimer.start();

    }
    //Sonraki activity ye geçmesini sağlar.(Burada o activity "ListeActivity" dir.
    private void opennextActivity(){

        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(),ListeActivity.class);
        startActivity(secondActivityIntent);
        finish();

    }

}

