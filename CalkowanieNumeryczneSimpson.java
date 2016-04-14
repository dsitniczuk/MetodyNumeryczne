public class CalkowanieNumeryczneSimpson {

    double gornaGranica;
    double dolnaGranica;
    double odleglosc;
    double dokladnosc;

    public double funkcja(double x) {
        return ((x * x) * (Math.sqrt(1 + x))) / (1 + (x * x));
    }

    public void odleglosc() {
        odleglosc = (gornaGranica - dolnaGranica) / dokladnosc;
    }

    public double licz() {
        double punktZero = odleglosc / 3;
        double suma = funkcja(dolnaGranica);
        double temp = dolnaGranica;

        for (int i = 1; i < dokladnosc; i++) {
            temp = temp + odleglosc;

            if (i % 2 != 0) {
                suma = suma + 4 * funkcja(temp);
            } else {
                suma = suma + 2 * funkcja(temp);
            }

        }
        temp = temp + odleglosc;

        return punktZero * (suma + funkcja(temp));

    }

    public static void main(String[] args) {
        CalkowanieNumeryczneSimpson calkowanie1 = new CalkowanieNumeryczneSimpson();
        calkowanie1.gornaGranica = 2;
        calkowanie1.dolnaGranica = 0;
        calkowanie1.dokladnosc = 10;
        
        calkowanie1.odleglosc();
        System.out.println(calkowanie1.licz());

    }

}
