
package prolab.Siniflar;

import java.util.HashMap;


public interface iSporcu {
    abstract HashMap<String, Integer> sporcuPuaniGoster();
    public String getSporcuIsim();
    public void setSporcuIsim(String sporcuIsim);
    public String getSporcuTakim();
    public void setSporcuTakim(String sporcuIsim);
}
