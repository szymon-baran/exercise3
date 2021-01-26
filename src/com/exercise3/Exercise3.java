package com.exercise3;

public class Exercise3 {
    //Wyliczenie silni.
    static long getFactorial(int num) {
        long factorial = 1;
        for (int i=1; i<num+1; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //Wyliczenie liczby e zgodnie ze wzorem z Wikipedii podanej w wiadomosci - poprzez sumę szeregu z n=15.
    static double getE() {
        double e=0, tmp;
        for(int i=0; i<15; i++) {
            tmp = 1.0/getFactorial(i);
            e += tmp;
        }
        return e;
    }

    //Sprawdzenie, czy dana liczba jest pierwsza poprzez dzielenie jej przez liczby równe lub większe od 2, a mniejsze od niej samej.
    static boolean isPrime(long number) {
        for(long i=2; i<number; i++) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }

    //Przycięcie liczby do 10 kolejnych cyfr.
    static String cutString(String mainStr, int i) {
        return mainStr.substring(i, 10+i);
    }

    public static void main(String[] args) {
        double e = getE();
        String str = String.valueOf(e);
        System.out.println("Wyznaczona liczba e: " + str);
        String mainStr = str.substring(2);
        System.out.println("Zbior cyfr do poszukiwan: " + mainStr);

        for (int i=0; i<mainStr.length()-9; i++) {
            String newStr = cutString(mainStr, i);
            System.out.print("Liczba: " + newStr + "\nsprawdzanie... ");
            boolean result = isPrime(Long.parseLong(newStr));
            System.out.println(result);
            if(result) {
                System.out.println("Pierwsza dziesieciocyfrowa liczba pierwsza wsrod kolejnych cyfr liczby e to: " + newStr);
                break;
            }
        }
    }
}
