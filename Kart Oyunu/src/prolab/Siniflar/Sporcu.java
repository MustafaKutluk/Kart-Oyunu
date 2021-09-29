
package prolab.Siniflar;

import java.util.HashMap;


abstract class Sporcu implements iSporcu {
    protected String sporcuIsim;
    protected String sporcuTakim;

    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }

    public String getSporcuIsim() {
        return sporcuIsim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }
    
    public Sporcu(){
        System.out.println("Sporcu Oluşturuldu");
    }
    
    public Sporcu(String sporcuIsim,String sporcuTakim){
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
    }
    
    public abstract HashMap<String, Integer> sporcuPuaniGoster();
}
