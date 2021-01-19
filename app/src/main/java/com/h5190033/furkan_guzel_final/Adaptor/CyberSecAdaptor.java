package com.h5190033.furkan_guzel_final.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
// Gerekli kütüphaneleri import edildi.
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190033.furkan_guzel_final.Model.CyberSecModel;
import com.h5190033.furkan_guzel_final.Util.GladeUtil;
import com.h5190033.furkan_guzel_final.R;

import java.util.List;
//Bu dosya CyberSecAdaptor dosyasıdır.
public class CyberSecAdaptor extends RecyclerView.Adapter<CyberSecViewHolder> {


    List<CyberSecModel> araclar;
    Context context;
    OnItemClickListener listener;
    //Gerekli değişkenler belirlenmiştir.
    public interface OnItemClickListener {
        void onClick(int position);
        //Tıklama fonksiyonu.
    }


    public CyberSecAdaptor(List<CyberSecModel> araclar, Context context, OnItemClickListener listener) {
        this.araclar = araclar;
        this.context = context;
        this.listener = listener;
        //CyberSecModel deki belirli değerler ile buradaki değerler eşleştirilmiştir.
    }

    @NonNull
    @Override
    public CyberSecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View değeri oluşturup cardview_arac ile eşleştirilmiştir.
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_arac,parent,false);
        return new CyberSecViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CyberSecViewHolder viewHolder, int position) {

        viewHolder.txt_aracadi.setText(araclar.get(position).getToolName());
        viewHolder.txt_uretici.setText(araclar.get(position).getCreator());
        GladeUtil.resmiIndiripGoster(context,araclar.get(position).getImageURL(),viewHolder.img_araclogo);
        //CyberSecViewHolder dan belirli değerler çekilerek, buradaki değerler ile set edilmiştir.
    }

    @Override
    public int getItemCount() {
        return araclar.size();
    } //Item sayacı, araclar.size fonksiyonuna return edilmiş.
}
