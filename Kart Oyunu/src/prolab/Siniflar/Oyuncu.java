
package prolab.Siniflar;

import java.util.ArrayList;
import java.util.List;


abstract class Oyuncu {
    protected int oyuncuID;
    protected String oyuncuAdi;
    protected int Skor;
    protected List<iSporcu> kartListesi;  
    
    public Oyuncu()
    {
        kartListesi = new ArrayList<>();
    }
    
    public Oyuncu(int oyuncuID,String oyuncuAdi,int Skor)
    {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.Skor = Skor;
        kartListesi = new ArrayList<>();
    }
    
        public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }
    
    public List<iSporcu> getKartListesi() {
        return kartListesi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public void setSkor(int Skor) {
        this.Skor = this.Skor + Skor;
    }

    public void setKartListesi(iSporcu kartListesi) {
        this.kartListesi.add(kartListesi);
    }
    
    public int SkorGoster() {
        return this.Skor;
    }
    
    abstract iSporcu kartSec(int index);
}
