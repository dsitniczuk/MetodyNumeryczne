public class CalkowanieNumeryczneTrapezy {

    double przedzialDol;
    double przedzialGora;

    double szerokosc;
    double ilosc;

    public void szerokosc() {
        szerokosc = (przedzialGora - przedzialDol) / ilosc;
    }

    public double wysokosc(double x) {
        return ((x * x) * (Math.sqrt(1 + x))) / (1 + (x * x));
    }

    public double pole() {

        double punkt = przedzialDol;
        double pole = 0;

        for (int i = 0; i < ilosc; i++) {
            pole = pole + (((wysokosc(punkt) + wysokosc(punkt + szerokosc)) * szerokosc) / 2);
            punkt = punkt + szerokosc;
        }

        return pole;
    }

    public static void main(String[] args) {
        
        CalkowanieNumeryczneTrapezy calkowanie1 = new CalkowanieNumeryczneTrapezy();
        calkowanie1.przedzialDol = 0;
        calkowanie1.przedzialGora = 2;
        calkowanie1.ilosc = 20;

        calkowanie1.szerokosc();
        System.out.println(calkowanie1.pole());

    }

}
