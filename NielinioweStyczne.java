//http://eff10.internetdsl.tpnet.pl/programowanie/mz_fun/pages/newton.htm
public class Stick {
    double dokladnosc=0.01;
    double punktStartowy=1;
    double wartoscPunktu;
    
    double FunkcjaZwykla(double argument){
        return argument*argument*argument-argument*argument+2*argument-1;
    }
    
    double FunkcjaPochodna(double argument){
        return 3*argument*argument-2*argument+2;
    }
    
    double WartoscPunktu(double argument){
        return punktStartowy-FunkcjaZwykla(argument)/FunkcjaPochodna(argument);
    }
    
    double WartoscFunkcjiwPunkcie(){
        wartoscPunktu=WartoscPunktu(punktStartowy);
        return FunkcjaZwykla(wartoscPunktu);
    }
    
    boolean CzyWpadaWZakres(){
        boolean smietnik;
        if(WartoscFunkcjiwPunkcie()>=dokladnosc){
            smietnik=true;
            punktStartowy=wartoscPunktu;
        }
        else 
            smietnik=false;
        return smietnik;
    }
    
    double Oblicz(){
        while(CzyWpadaWZakres()==true){
        }
        return wartoscPunktu;
    }
    
    
    public static void main(String args[]){
        Stick st = new Stick ();
        System.out.println(st.Oblicz());
    }
}
