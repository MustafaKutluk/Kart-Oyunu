
package prolab.Siniflar;

import java.util.HashMap;


public class Basketbolcu extends Sporcu {
    private int ikilik;
    private int ucluk;
    private int serbestAtis;
    private boolean kartKullanildiMi;
    
    public Basketbolcu()
    {
        super();
    }
    
    public Basketbolcu(String basketbolcuAdi, String basketbolcuTakim)
    {
        super(basketbolcuAdi,basketbolcuTakim);
    }
    
    public Basketbolcu(String basketbolcuAdi, String basketbolcuTakim,int ikilik, int ucluk, int serbestAtis)
    {
        super(basketbolcuAdi,basketbolcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
    }

    @Override
    public HashMap<String, Integer> sporcuPuaniGoster() {
        HashMap<String, Integer> degerler = new HashMap<>();
        degerler.put("ikilik",this.ikilik);
        degerler.put("ucluk",this.ucluk);
        degerler.put("serbestAtis",this.serbestAtis);
        
        return degerler;
    }
    
    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }
    
    public int getIkilik() {
        return ikilik;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }
}
