import java.util.ArrayList;

public class NajmniejszeKwadraty {
    int [] tabx={1,2,4,7};
    double [] taby = {1.6,2.0,2.5,3.5};
    int iloscPunktow=tabx.length;
    ArrayList<Double> sumyKolumn1=new ArrayList<Double> ();
    ArrayList<Double> sumyKolumn2=new ArrayList<Double> (); 
    int n=3;
    int m=1;
    double smietnik=0;
    
    void KomorkaPotegowanieX(){
        for(int i=0;i<n;i++){ //wartosc potegi
            for(int j=0;j<iloscPunktow;j++){ //wartosci x
                smietnik=smietnik+Math.pow(tabx[j], i);
            }
            sumyKolumn1.add(smietnik);
            smietnik=0;
        }
    }
    
    void KomorkaY(){
        for(int i=0;i<iloscPunktow;i++){
            smietnik=smietnik+taby[i];
        }
        sumyKolumn2.add(smietnik);
        smietnik=0;
    }
    
    void KomorkaMnozenieXiY(){
        for(int i=0;i<iloscPunktow;i++){
            smietnik=smietnik+(tabx[i]*taby[i]);
        }
        sumyKolumn2.add(smietnik);
        smietnik=0;
    }
    
    void WypelnijTabele(){
        KomorkaPotegowanieX();
        KomorkaY();
        KomorkaMnozenieXiY();
    }
    
    double LiczWyznacznik1(){
        return (sumyKolumn1.get(0)*sumyKolumn1.get(2))-(sumyKolumn1.get(1)*sumyKolumn1.get(1));
    }
    
    double LiczWyznacznik2(){
        return (sumyKolumn2.get(0)*sumyKolumn1.get(2))-(sumyKolumn1.get(1)*sumyKolumn2.get(1));
    } 
    
    double LiczWyznacznik3(){
        return (sumyKolumn1.get(0)*sumyKolumn2.get(1))-(sumyKolumn2.get(0)*sumyKolumn1.get(1));
    }
    
    double WynikNiewiadomaA(){
        return LiczWyznacznik2()/LiczWyznacznik1();
    }
    
    double WynikNiewiadomaB(){
        return LiczWyznacznik3()/LiczWyznacznik1();
    } 
    
    @Override
    public String toString(){
        return WynikNiewiadomaA()+"+"+WynikNiewiadomaB()+"x";
    }
    
    public static void main(String args[]){
        NajmniejszeKwadraty kw =new NajmniejszeKwadraty();
        kw.WypelnijTabele();
        System.out.println(kw);
    }

}
