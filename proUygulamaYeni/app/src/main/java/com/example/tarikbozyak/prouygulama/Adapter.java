package com.example.tarikbozyak.prouygulama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Adapter extends ArrayAdapter<String> {





    String[] Saat ;
    String Nerden;
    String Nereye;
    String[] Fiyat ;
    String[] SeferNo ;
    int[] imgs;
    Context c;
    LayoutInflater inflater;



    //Bu class gidiş yönün uçak listesini oluşturmak için kullanıldı.

    public Adapter(Context context,String[] Saat,String Fiyat[],String SeferNo[],int imgs[],String Nerden,String Nereye) {
        super(context, R.layout.row2_layout,Saat);

        this.c=context;
        this.Saat=Saat;
        this.Fiyat=Fiyat;
        this.SeferNo=SeferNo;
        this.imgs=imgs;
        this.Nerden=Nerden;
        this.Nereye=Nereye;
    }



    public class ViewHolder{


        TextView Saat;
        TextView Fiyat;
        ImageView img;
        TextView Nerden;
        TextView Nereye;
        TextView SeferNo;


    }


    //Buradaki getView metodu ArrayAdapter sınıfından Override edilmiş özel bir metoddur.
    //Bu metod sayesinde gidiş yönünde sefer listeleyen listview in elemanlarına değer gönderimi sağlan

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.row2_layout,null);
        }
        final ViewHolder holder=new ViewHolder();
        holder.Saat=(TextView)convertView.findViewById(R.id.textSaat);
        holder.Fiyat=(TextView)convertView.findViewById(R.id.textFiyat);
        holder.img=(ImageView)convertView.findViewById(R.id.imageViewLogo);
        holder.Nerden=(TextView)convertView.findViewById(R.id.textNerden);
        holder.Nereye=(TextView)convertView.findViewById(R.id.textNereye);
        holder.SeferNo=(TextView)convertView.findViewById(R.id.textSefer);



        holder.Saat.setText(Saat[position]);
        holder.Fiyat.setText(Fiyat[position]);
        holder.img.setImageResource(imgs[position]);
        holder.Nerden.setText(DegerTut.Nerden);
        holder.Nereye.setText(DegerTut.Nereye);
        holder.SeferNo.setText(SeferNo[position]);




        // liste=db.getAllOtel();


        //holder.OtelAdi.setText(liste.get(position).getOtelAdi());
        //holder.OtelYildizSayisi.setText("Kalite : "+liste.get(position).getOtelYıldız());
        //holder.OtelGunlukFiyat.setText("Günlük Fiyat : "+liste.get(position).getGunlukFıyat());




        return convertView;
    }
}
