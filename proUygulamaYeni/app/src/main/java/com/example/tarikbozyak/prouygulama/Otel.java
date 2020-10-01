package com.example.tarikbozyak.prouygulama;


public class Otel {

    private int id;
    private String OtelAdi;
    private String OtelYıldız;



    private String GunlukFıyat;

    public Otel(){}

    public Otel(String OtelAdi, String OtelYıldız,String GunlukFiyat) {
        super();
        this.OtelAdi = OtelAdi;
        this.OtelYıldız = OtelYıldız;
        this.GunlukFıyat=GunlukFiyat;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOtelAdi() {
        return OtelAdi;
    }
    public void setOtelAdi(String OtelAdi) {
        this.OtelAdi = OtelAdi;
    }
    public String getOtelYıldız() {
        return OtelYıldız;
    }
    public void setOtelYıldız(String OtelYıldız) {
        this.OtelYıldız = OtelYıldız;
    }
    public String getGunlukFıyat() {
        return GunlukFıyat;
    }

    public void setGunlukFıyat(String gunlukFıyat) {
        GunlukFıyat = gunlukFıyat;
    }

    @Override
    public String toString() {
        return "Otel [id=" + id + ", Otel Adi=" + OtelAdi + ", Otel Yıldız=" + OtelYıldız
                + "]";
    }
}