//http://eff10.internetdsl.tpnet.pl/programowanie/mz_fun/pages/bisection.htm
public class Bisekcja {
    double przedzialA=0;
    double przedzialB=1;
    double dokladnosc=0.01;
    double wartoscPunktu;
    double wartoscFunkcjiWPunkcie;
    
    double Funkcja(double argument){
        return argument*argument*argument-argument*argument+2*argument-1;
    }
    
    double Punkt(){
        return (przedzialA+przedzialB)/2;
    }
    
    double FunkcjaWPunkcie(){
        wartoscPunktu=Punkt();
        return Funkcja(wartoscPunktu);
    }
    
    boolean CzyToPierwiastek(){
        boolean smietnik;
        wartoscFunkcjiWPunkcie=FunkcjaWPunkcie();
        double temp=FunkcjaWPunkcie();
        if(temp<0)temp=-temp;
        if(temp>=dokladnosc){
            smietnik=false;
            ZmienPrzedzial();
        }
        else {
            smietnik=true;
        }
        return smietnik;
    }
    
    boolean ZmienPrzedzial(){
            if(wartoscFunkcjiWPunkcie<0&&Funkcja(przedzialA)<0)
                przedzialA=wartoscPunktu;
            else 
                przedzialB=wartoscPunktu;
        return true;
    }
    
    double WyliczPierwiastek(){
        while(CzyToPierwiastek()==false){
        }
        return wartoscPunktu;
    }
    
    public static void main(String args[]){
        Bisekcja bs=new Bisekcja();
        System.out.println(bs.WyliczPierwiastek());
    }

}
