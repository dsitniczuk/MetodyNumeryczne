import java.util.ArrayList;

public class InterpolacjaNewtonaJednakowe {

    double[] tab = {3, 7, 8, 15}; //to y
    double[] tabx = {1, 2, 3, 4}; //to x
    ArrayList<Double> temp = new ArrayList<Double>();
    double h;
    int ilosc = tab.length - 1;
    double f0 = tab[0]; //f(x0)
    double x = 4;

    void odleglosc() {
        h = tabx[1] - tabx[0];
    }

    void roznica_progresywna_licznik() {
        int k = 0; // mianownik
        for (int q = 0; q < ilosc; q++) {
            k++;
            for (int w = 0; w < ilosc - q; w++) {
                tab[w] = (tab[w + 1] - tab[w]);
                if (w == 0) {
                    temp.add(tab[w]);
                }
            }
        }
    }

    void roznica_progresywna_mianownik() {
        for (int i = 0; i < temp.size(); i++) {
            temp.set(temp.size() - i - 1, temp.get(temp.size() - i - 1) / (potegowanie(h, ilosc - i) * silnia(ilosc - i)));
        }
    }

    void roznica_progresywna() {
        odleglosc();
        roznica_progresywna_licznik();
        roznica_progresywna_mianownik();
    }

    double potegowanie(double aliczba, int astopien) {
        double a = aliczba; //liczba potęgowana
        int b = astopien; //stopien potegi
        double liczba = 1;
        for (int i = 0; i < b; i++) {
            liczba = liczba * a;
        }
        return liczba;
    }

    double silnia(int aliczba) { 
        int a = aliczba;
        int liczba = 1;
        for (int i = 0; i < a - 1; i++) {
            liczba = liczba * (a - i);
        }
        return liczba;
    }

    void wymnoz() {
        for (int i = 1; i < ilosc + 1; i++) {
            double xy = temp.get(i - 1);
            for (int j = 1; j < i + 1; j++) {
                xy = xy * (x - j);
            }
            temp.set(i - 1, xy);
        }
    }

    double oblicz() {
        double x = f0;
        for (int i = 0; i < ilosc; i++) {
            x = x + temp.get(i);
        }
        return x;
    }

    double interpolacja() {
        roznica_progresywna();
        wymnoz();
        return oblicz();
    }

    public static void main(String[] args) {
        InterpolacjaNewtonaJednakowe interpolacja1 = new InterpolacjaNewtonaJednakowe();
        System.out.println(interpolacja1.interpolacja());

    }

}
