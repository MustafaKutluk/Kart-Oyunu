
package prolab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import prolab.Siniflar.*;
import java.util.Random; 


public class Prolab {

    public static void writeScreen(Bilgisayar bilgisayar,Kullanici kullanici)
    {
        System.out.println("Bilgisayar Skoru : " + bilgisayar.SkorGoster() + " Kullanici Skoru : " + kullanici.SkorGoster());
        System.out.println("Kartlarınız : ");
        for(int i = 0; i < kullanici.getKartListesi().size(); i++ ) {
            iSporcu kart = kullanici.kartSec(i);
            if(kart instanceof Futbolcu) {
                if( ((Futbolcu)kart).isKartKullanildiMi() == false ) {
                    System.out.println((i + 1) + " =>       Futbolcu : " + kart.getSporcuIsim());
                    System.out.println("                  Penalti : " + ((Futbolcu)kart).getPenalti());
                    System.out.println("                  Serbest Atis : " + ((Futbolcu)kart).getSerbestAtis());
                    System.out.println("                  Kaleci Karsi Karsiya : " + ((Futbolcu)kart).getKaleciKarsiKarsiya());
                }
            } else {
                if( ((Basketbolcu)kart).isKartKullanildiMi() == false ) {
                    System.out.println((i + 1) + " =>       Basketbolcu : " + kart.getSporcuIsim());
                    System.out.println("                  Ikilik : " + ((Basketbolcu)kart).getIkilik());
                    System.out.println("                  Uclük : " + ((Basketbolcu)kart).getUcluk());
                    System.out.println("                  Serbest Atis : " + ((Basketbolcu)kart).getSerbestAtis());
                }
            }
        }
    }
    
    public static boolean tümKartlarKullandiMi(Kullanici kullanici) {
        boolean check = true;
        
        for(int i = 0 ; i < 8 ; i++) {
            iSporcu kart = kullanici.getKartListesi().get(i);
            if(kart instanceof Futbolcu) {
                if(((Futbolcu)kart).isKartKullanildiMi() == false) {
                    check = false;
                    break;
                }
            }
            else {
                if(((Basketbolcu)kart).isKartKullanildiMi() == false) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    
    
    public static void main(String[] args) throws IOException {
        
        String[] nameList = {"Feridun","Toygar","Burhan","Yasemin","Besim","Ibrahim","Serpil","Nurullah","Nida","Baris","Cengiz","Mustafa","Mehmet","Ali","Recep","Hüseyin","Kenan","Kemal","Ilker","Ecrin","Sümeyye"};

        String[] surnameList = {"Karama","Demirci","Under","Akin","Akinci","Kutlu","Yeni","Serap","Taştan","Terzi","Tutku","Kelebek","Cihan","Dilek","Ümitli","Basal","Hayat","Celik","Kasaphan","Mahzun","Sadık"};

        String[] teamList = {"Real Madrid","Barcelona","Galatasaray","Fenerbahçe","Besiktas","Milan","Inter","Trabzonspor","Paris SG","Bayern Münih","Dortmund","Chealse","Liverpool","Mancheshter City","Everton","Arsenal","Atletico Madrid","Marsilya","Lyon","Basaksehir","Ajax"};
        
        List<iSporcu> futbolKartListesi = new ArrayList<>();
        List<iSporcu> basketKartListesi = new ArrayList<>();
        Random rand = new Random(); 
        
        for(int i = 0; i < 16; i++) {
            String name = nameList[rand.nextInt(20)] + " " + surnameList[rand.nextInt(20)];
            String team = teamList[rand.nextInt(20)];
            if(i % 2 == 0) {
                Futbolcu fb = new Futbolcu(name,team,rand.nextInt(100),rand.nextInt(100),rand.nextInt(100));
                futbolKartListesi.add(fb);
            } else {
                Basketbolcu bs = new Basketbolcu(name,team,rand.nextInt(100),rand.nextInt(100),rand.nextInt(100));
                basketKartListesi.add(bs);
            }
        }
        
        
        Bilgisayar bilgisayar = new Bilgisayar(12345,"Bilgisayar",0);
        Kullanici kullanici = new Kullanici(54321,"Mustafa",0);
        
        for(int i = 0; i < 4; i++) {
            int index = rand.nextInt(futbolKartListesi.size());
            kullanici.setKartListesi(futbolKartListesi.get(index));
            futbolKartListesi.remove(index);
            
            index = rand.nextInt(futbolKartListesi.size());
            bilgisayar.setKartListesi(futbolKartListesi.get(index));
            futbolKartListesi.remove(index);
            
            index = rand.nextInt(basketKartListesi.size());
            kullanici.setKartListesi(basketKartListesi.get(index));
            basketKartListesi.remove(index);
            
            index = rand.nextInt(basketKartListesi.size());
            bilgisayar.setKartListesi(basketKartListesi.get(index));
            basketKartListesi.remove(index);
        }
        
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        
        boolean check = true;
        
        while(check) {
            
            writeScreen(bilgisayar,kullanici);
            
            System.out.println("Bir Kart Sec: ");
            String input = reader.readLine();
            int id = Integer.parseInt(input) - 1;
            
            if(id > 8 || id < 0) {
                System.out.println("Yanlıs bir kart numarası girdiniz.1");
                continue;
            }
            
            iSporcu iUserKart = kullanici.kartSec(id);
            
            if (iUserKart instanceof Futbolcu) {
                if(((Futbolcu) kullanici.getKartListesi().get(id)).isKartKullanildiMi()) {
                    System.out.println("Seçilmiş Kart Seçtiniz. Tekrar Deneyin");
                    continue;
                }
            } else {
                if(((Basketbolcu) kullanici.getKartListesi().get(id)).isKartKullanildiMi()) {
                    System.out.println("Seçilmiş Kart Seçtiniz. Tekrar Deneyin");
                    continue;
                }
            }
            
            if (iUserKart instanceof Futbolcu) {
                ((Futbolcu) kullanici.getKartListesi().get(id)).setKartKullanildiMi(true);
            } else {
                ((Basketbolcu) kullanici.getKartListesi().get(id)).setKartKullanildiMi(true);
            }
            
            Test oyun = new Test();
            oyun.setKullaniciKart(iUserKart);
            
            iSporcu iBilgisayarKart = null;
            while(iBilgisayarKart == null) {
                int pcID = rand.nextInt(8);
                iSporcu sp = bilgisayar.kartSec(pcID);
                if(sp.getClass().equals(iUserKart.getClass())) {
                    if(sp instanceof Futbolcu) {
                        if( ((Futbolcu)sp).isKartKullanildiMi() == false) {
                            iBilgisayarKart = sp;
                            ((Futbolcu) bilgisayar.getKartListesi().get(id)).setKartKullanildiMi(true);
                        }
                    } else {
                        if( ((Basketbolcu)sp).isKartKullanildiMi() == false) {
                            iBilgisayarKart = sp;
                            ((Basketbolcu) bilgisayar.getKartListesi().get(id)).setKartKullanildiMi(true);
                        }
                    }
                }
            }
            
            oyun.setBilgisayarKart(iBilgisayarKart);
            
            String sonuc = oyun.sonucHesapla();
            String kazanan = "";
            
            switch (sonuc) {
                case "kullanici":
                    kazanan = "Kullanıcı";
                    kullanici.setSkor(10);
                    break;
                case "beraber":
                    kazanan = "Berabere";
                    kullanici.setSkor(5);
                    bilgisayar.setSkor(5);
                    break;
                default:
                    kazanan = "Bilgisayar";
                    bilgisayar.setSkor(10);
                    break;
            }
            
            System.out.println("");
            if (iUserKart instanceof Futbolcu) {
                System.out.print("Oynanan Oyun Futbol. ");
            } else {
                System.out.print("Oynanan Oyun Basketbol. ");
            }
            
            switch (oyun.getDurum()) {
                case "penalti":
                    System.out.println("Gercekleşen Olay Penalti. ");
                    break;
                case "kaleciKarsiKarsiya":
                    System.out.println("Gercekleşen Olay Kaleci Ile Karsi Karsiya. ");
                    break;
                case "ikilik":
                    System.out.println("Gercekleşen Olay Ikilik Atis. ");
                    break;
                case "ucluk":
                    System.out.println("Gercekleşen Olay  Uclük Atis. ");
                    break;
                default:
                    System.out.println("Gercekleşen Olay Serbest Atis. ");
                    break;
            }
            
            System.out.println("Kullanici Kartı Isim : " + iUserKart.getSporcuIsim() + "      Bilgisayar Kart Isim : " + iBilgisayarKart.getSporcuIsim());
            
            HashMap<String, Integer> kullaniciDeger;
            HashMap<String, Integer> bilgisayarDeger;
            
            if (iUserKart instanceof Futbolcu) {
                kullaniciDeger = ((Futbolcu)iUserKart).sporcuPuaniGoster();
                bilgisayarDeger = ((Futbolcu)iBilgisayarKart).sporcuPuaniGoster();
            } else {
                kullaniciDeger = ((Basketbolcu)iUserKart).sporcuPuaniGoster();
                bilgisayarDeger = ((Basketbolcu)iBilgisayarKart).sporcuPuaniGoster();
            }
            
            kullaniciDeger.forEach((key,value)->{
                System.out.println("Kullanici Deger => " + key + " : " + value + "      Bilgisayar Deger => " + key + " : " + bilgisayarDeger.get(key));
            });
            
            System.out.println("Kazanan : " + kazanan);
            
            
            if(tümKartlarKullandiMi(kullanici) == true) {
                System.out.println("Kullanici Puanı : " + kullanici.SkorGoster());
                System.out.println("Bilgisayar Puanı : " + bilgisayar.SkorGoster());
                System.out.println("Oyun Bitti.");
                check = false;
            }
            
        }
    }

}