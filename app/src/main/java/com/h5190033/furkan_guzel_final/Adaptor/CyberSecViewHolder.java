package com.h5190033.furkan_guzel_final.Adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
// Gerekli kütüphaneleri import edildi.
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190033.furkan_guzel_final.R;
//Bu dosya CyberSecViewHolder dosyasıdır.
public class CyberSecViewHolder extends RecyclerView.ViewHolder {

    ImageView img_araclogo;
    TextView txt_aracadi;
    TextView txt_uretici;
    //Gerekli değişkenler belirlenmiştir.
    public CyberSecViewHolder(@NonNull View itemView, CyberSecAdaptor.OnItemClickListener listener) {
        super(itemView);

        img_araclogo =itemView.findViewById(R.id.img_araclogo);
        txt_aracadi =itemView.findViewById(R.id.txt_aracadi);
        txt_uretici =itemView.findViewById(R.id.txt_uretici);
        //Değerleri gerekli layout id leri ile eşler.
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(getAdapterPosition());
                //tıklama listener'ı.
            }
        });
    }
}
