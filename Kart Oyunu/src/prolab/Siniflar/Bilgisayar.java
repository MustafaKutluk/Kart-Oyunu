
package prolab.Siniflar;

import java.util.List;


public class Bilgisayar extends Oyuncu {
    
    public Bilgisayar()
    {
        super();
    }
    
    public Bilgisayar(int oyuncuID,String oyuncuAdi,int Skor)
    {
        super(oyuncuID,oyuncuAdi,Skor);
    }

    @Override
    public iSporcu kartSec(int index) {
        List<iSporcu> deste = this.getKartListesi();
        return deste.get(index);
    }
    
}
