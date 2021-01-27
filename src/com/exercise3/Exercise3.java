package com.exercise3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise3 {
    //Wyliczenie silni.
    static BigDecimal getFactorial(int num) {
        BigDecimal factorial = new BigDecimal("1");
        for (int i=1; i<num+1; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }
        return factorial;
    }

    //Wyliczenie liczby e zgodnie ze wzorem z Wikipedii podanej w wiadomosci - poprzez sumę szeregu z n=15.
    static BigDecimal getE() {
        BigDecimal e = new BigDecimal("0.0");
        BigDecimal tmp;
        BigDecimal one = new BigDecimal("1.0");
        for(int i=0; i<80; i++) {
            tmp = one.divide(getFactorial(i), 120, RoundingMode.CEILING);
            e = e.add(tmp);
        }
        System.out.println(e);
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
        BigDecimal e = getE();
        String str = e.toPlainString();
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
