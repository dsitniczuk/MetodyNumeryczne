//http://eff10.internetdsl.tpnet.pl/programowanie/mz_fun/pages/regulafalsi.htm
public class UkladNieliniowySieczne {
    double przedzialA=0;
    double przedzialB=1;
    double dokladnosc=0.01;
    double wartoscPunktu;
    double wartoscFunkcjiWpunkcie;
    
    double Funkcja(double argument){
        return argument*argument*argument-argument*argument+2*argument-1;
    }
    
    double WzorOgolny(double argumentA, double argumentB){
        return przedzialA-Funkcja(argumentA)*(przedzialB-przedzialA)/(Funkcja(argumentB)-Funkcja(argumentA));
    }
    
    double Oblicz(){
        wartoscPunktu=WzorOgolny(przedzialA,przedzialB);
        return Funkcja(wartoscPunktu);
    }
    
    boolean CzyPierwiastek(){
        boolean smietnik;
        wartoscFunkcjiWpunkcie=-Oblicz();
        if(wartoscFunkcjiWpunkcie>=dokladnosc) {
            przedzialA=wartoscPunktu;
            smietnik=false;
        }
        else smietnik=true;
        //System.out.println(wartoscPunktu+" "+wartoscFunkcjiWpunkcie+" "+przedzialA);
        return smietnik;
    }
    
    double ZnajdzPierwiastek(){
        while(CzyPierwiastek()!=true){
            
        }
        return wartoscPunktu;
    }
    
    public static void main(String args[]){
        UkladNieliniowySieczne uns = new UkladNieliniowySieczne();
        System.out.println(uns.ZnajdzPierwiastek());
    }

}
