
package prolab.Siniflar;

import java.util.HashMap;
import java.util.Random;


public class Test {
    private iSporcu kullaniciKart;
    private iSporcu bilgisayarKart;
    private String durum;
    
    public Test() {
    }
    
    public Test(iSporcu kullaniciKart,iSporcu bilgisayarKart) {
        this.kullaniciKart = kullaniciKart;
        this.bilgisayarKart = bilgisayarKart;
    }

    public iSporcu getKullaniciKart() {
        return kullaniciKart;
    }

    public void setKullaniciKart(iSporcu kullaniciKart) {
        this.kullaniciKart = kullaniciKart;
    }

    public iSporcu getBilgisayarKart() {
        return bilgisayarKart;
    }

    public void setBilgisayarKart(iSporcu bilgisayarKart) {
        this.bilgisayarKart = bilgisayarKart;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum() {
        String[][] durumlar = {{"penalti","serbestAtis","kaleciKarsiKarsiya"},{"ikilik","ucluk","serbestAtis"}};
        Random rand = new Random(); 
        
        if(this.kullaniciKart instanceof Futbolcu ) {
            this.durum = durumlar[0][rand.nextInt(3)];
        } else {
            this.durum = durumlar[1][rand.nextInt(3)];
        }
    }
    
    public String sonucHesapla() {
        this.setDurum();
        
        HashMap<String, Integer> kullaniciDegerler = this.kullaniciKart.sporcuPuaniGoster();
        HashMap<String, Integer> bilgisayarDegerler = this.bilgisayarKart.sporcuPuaniGoster();
        
        if(kullaniciDegerler.get(this.durum) > bilgisayarDegerler.get(this.durum)) {
            return "kullanici";
        } else if (kullaniciDegerler.get(this.durum) == bilgisayarDegerler.get(this.durum)) {
            return "beraber";
        } else {
            return "bilgisayar";
        }
    }
    
}
