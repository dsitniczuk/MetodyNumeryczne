import java.util.ArrayList;

public class InterpolacjaNewtonaDowolne {

    public double[] tab = {1, 3, 2, 5, 7}; //to y
    public double[] tabx = {0, 2, 3, 4, 6}; //to x
    public ArrayList<Double> temp = new ArrayList<Double>();
    double f0 = tab[0]; //f(x0)
    int ilosc = tab.length - 1;

    void iloraz_roznicowy() {
        int k = 0; // mianownik

        for (int q = 0; q < ilosc; q++) {
            k++;
            for (int w = 0; w < ilosc - q; w++) {
                tab[w] = (tab[w + 1] - tab[w]) / (tabx[w + k] - tabx[w]);
                if (w == 0) {
                    temp.add(tab[w]);
                }
            }
        }
    }

    double interpolacja() {
        double b = 0;
        double a = 0;
        double x = 5;

        for (int i = 0; i < temp.size(); i++) {
            a = temp.get(i);
            for (int j = 0; j < i + 1; j++) {
                a = a * (x - tabx[j]);
            }
            b = b + a;
        }
        b = b + f0;
        return b;
    }

    double oblicz() {
        iloraz_roznicowy();
        return interpolacja();
    }

    public static void main(String[] args) {
        InterpolacjaNewtonaDowolne interpolacja1 = new InterpolacjaNewtonaDowolne();
        System.out.println(interpolacja1.oblicz());
    }

}
