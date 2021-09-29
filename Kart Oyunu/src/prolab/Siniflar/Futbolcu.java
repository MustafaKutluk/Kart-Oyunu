
package prolab.Siniflar;

import java.util.HashMap;


public class Futbolcu extends Sporcu {
    private int penalti;
    private int serbestAtis;
    private int kaleciKarsiKarsiya;
    private boolean kartKullanildiMi;
    
    public Futbolcu()
    {
        super();
    }
    
    public Futbolcu(String futbolcuAdi, String futbolcuTakim)
    {
        super(futbolcuAdi,futbolcuTakim);
    }
    
    public Futbolcu(String futbolcuAdi, String futbolcuTakim,int penalti, int serbestAtis, int kaleciKarsiKarsiya)
    {
        super(futbolcuAdi,futbolcuTakim);
        this.penalti = penalti;
        this.serbestAtis = serbestAtis;
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }

    @Override
    public HashMap<String, Integer> sporcuPuaniGoster() {
        HashMap<String, Integer> degerler = new HashMap<>();
        degerler.put("penalti",this.penalti);
        degerler.put("serbestAtis",this.serbestAtis);
        degerler.put("kaleciKarsiKarsiya",this.kaleciKarsiKarsiya);
        
        return degerler;
    }
    
    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }
    
    public int getPenalti() {
        return penalti;
    }

    public void setPenalti(int penalti) {
        this.penalti = penalti;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

    public int getKaleciKarsiKarsiya() {
        return kaleciKarsiKarsiya;
    }

    public void setKaleciKarsiKarsiya(int kaleciKarsiKarsiya) {
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }
}
