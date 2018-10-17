package potenza;

public class Potenza {

    public static void main(String[] args) {
        try {
            System.out.println("__________\n" + power(2, 4));
        } catch (ExceptionPower e) {

        }
    }

    public static int power(int a, int b) throws ExceptionPower {
        if (b < 0) {
            throw new ExceptionPower(1);
        }
        if (a == 0 && b == 0) {
            throw new ExceptionPower(2);
        }
        if (b == 0) {
            System.out.println(a + "\t|" + b);
            return 1;
        } else if (a == 0) {
            System.out.println(a + "\t|" + b);
            return 0;
        } else {
            int p;
            p = a * power(a, b - 1);
            System.out.println(a + "\t|" + b);
            assert p > b : "Errore: il risultato deve essere maggiore dell'esponente";
            return p;
        }
    }

    private static class ExceptionPower extends Exception {

        public ExceptionPower(int nErrore) {
            String s;
            switch (nErrore) {
                case 1:
                    s = "l'esponente non può essere negativo";
                    break;
                case 2:
                    s = "la potenza è indeterminata";
                    break;
                default:
                    s = "eccezione non gestita";

            }

            System.out.println("Errore potenza: " + s);
        }
    }
}
