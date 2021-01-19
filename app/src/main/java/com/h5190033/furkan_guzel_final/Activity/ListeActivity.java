package com.h5190033.furkan_guzel_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
// Gerekli kütüphaneleri import edildi.
import com.h5190033.furkan_guzel_final.Adaptor.CyberSecAdaptor;
import com.h5190033.furkan_guzel_final.Model.CyberSecModel;
import com.h5190033.furkan_guzel_final.R;
import com.h5190033.furkan_guzel_final.Network.Service;
import com.h5190033.furkan_guzel_final.Util.AlertDialogUtil;
import com.h5190033.furkan_guzel_final.Util.Constants;
import com.h5190033.furkan_guzel_final.Util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//Bu dosya Liste ekranıdır.
public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog beklemeEkrani;
    //Gerekli değişkenler belirlenmiştir.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);//Açılışta çalışan metod, layout olarak activity_list' e set edilmiştir.

        init(); // init fonksiyonunu çalıştırır.

    }

    private  void  init()
    {
        araclariGetir(); // araclariGetir fonksiyonunu çalıştırır.

        beklemeEkrani = new ProgressDialog(ListeActivity.this); //ListeActivity ekranı için "beklemeEkrani adında" ProgressDialog oluşturur.
        beklemeEkrani.setMessage(getResources().getString(R.string.beklemeEkrani));
        beklemeEkrani.show();
    }


    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialogShow(ListeActivity.this, getResources().getString(R.string.geriButonu),getResources().getString(R.string.geriButonuBilgi),getResources().getString(R.string.evet),getResources().getString(R.string.hayir),getResources().getString(R.string.ListeActivity));
        //Uygulamadan çıkmak istediğinde uyarı için verilen AlertDialog ekranı.
    }

    void  araclariGetir() //araclariGetir fonksiyonu tanımlanmıştır.
    {

        new Service().getServiceApi().araclarigetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CyberSecModel>>() {

                    List<CyberSecModel> araclar=new ArrayList<>(); //araclar adında bir ArrayList oluşturur.

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<CyberSecModel> aracList) {
                        Log.e("RETROFIT","onNext : ");
                        araclar=aracList; //araclar Arraylistini aracList ile eşitler.
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()//araclarigetir fonksiyonu tamamlanınca olacak şeyler için bir fonksiyon.
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(araclar.size()>0) {
                        //araclar 0 dan büyükse araclari getirir ve beklemeEkrani fonksiyonunu durdurur.
                            initRecycleView(araclar);
                            beklemeEkrani.dismiss();
                        }
                    }
                });
    }


    private  void  initRecycleView(List<CyberSecModel> araclarList)
    {
        recyclerView =findViewById(R.id.rcv_araclar);
        CyberSecAdaptor aracAdaptor =new CyberSecAdaptor(araclarList, getApplicationContext(), new CyberSecAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                //Tıklanan araci araclarList'den çeker.
                CyberSecModel tiklananArac = araclarList.get(position);
                        
                opennextActivity(tiklananArac); //Tıklanan araci açar.
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(aracAdaptor);
    }

    private void opennextActivity(CyberSecModel tiklananArac){
        //Tıklanan araca göre gerekli Activity yi çalıştırır.
        Intent secondActivityIntent=new Intent(getApplicationContext(),AracDetayActivity.class);
        String tiklananAracString= ObjectUtil.aracToJsonString(tiklananArac);
        secondActivityIntent.putExtra(Constants.TIKLANAN_ARAC_BASLIK, tiklananAracString);
        startActivity(secondActivityIntent);

    }

}