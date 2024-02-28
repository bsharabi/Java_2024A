package L09;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2022A {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {
        int ans;
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    int size = rd.nextInt(10);
                    int[] arr = new int[size];
                    for (int i = 0; i < size; i++)
                        arr[i] = (rd.nextBoolean()) ? rd.nextInt(40) : -rd.nextInt(40);
                    System.out.println(Arrays.toString(arr));
                    bool = q3(arr);
                    System.out.println(bool);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    String s = "abcdef";
                    q9(s);
                    break;
                case 10:
                    break;
                case 11:
                    size = rd.nextInt(5);
                    arr = new int[size];
                    for (int i = 0; i < size; i++)
                        arr[i] = rd.nextInt(40);
                    int k = rd.nextInt(8) + 2;
                    System.out.println("Kis -> " + k);
                    System.out.println(Arrays.toString(arr));
                    int[] KArr;
                    KArr = q11_a(arr, k);
                    System.out.println(Arrays.toString(KArr));
                    k = q11_b(arr, KArr);
                    System.out.println("Kis -> " + k);
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case -1:
                    return;

            }
        }
    }

    //O(n)
    // n = s.len
    private static boolean q9(String s) {
        if (s == null || s.length() == 0)
            return false;
        int[] counting = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 'a' || ch > 'z')
                return false;
            if (++counting[ch - 'a'] > 1)
                return false;
        }
        return true;
    }

    private static int q11_b(int[] arr, int[] brr) {

        if (brr.length % arr.length != 0)
            return 0;
        int k = brr.length / arr.length;
        for (int m = 0, i = 0; i < arr.length; i++)
            for (int j = 0; j < k; j++)
                if (brr[m++] != arr[i])
                    return 0;
        return k;
    }

    // O(2k*n) ~ O(k*n)
    // if k>n then O(k^2)
    private static int q11_b_with_a(int[] arr, int[] brr) {

        if (brr.length % arr.length != 0)
            return 0;
        int k = brr.length / arr.length;
        int[] tempBrr = q11_a(arr, k); //O(k*n)
        for (int i = 0; i < brr.length; i++) {
            if (brr[i] != tempBrr[i])
                return 0;
        }
        return k;
    }


    // n = arr .len
    // k param
    //O(k*n)
    private static int[] q11_a(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k == 0)
            return arr;
        if (k == 1)
            return Arrays.copyOf(arr, arr.length);

        int[] KArr = new int[arr.length * k];

        for (int m = 0, i = 0; i < arr.length; i++)
            for (int j = 0; j < k; j++)
                KArr[m++] = arr[i];

        return KArr;
    }


    public static boolean q3(int[] arr) {
        if (arr == null || arr.length == 0)
            return true;
        int balance = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                balance++;
            else if (arr[i] < 0)
                balance--;
            else
                return false;
        }

        return balance == 0;
    }

    static class Movie {
        private String name;
        private double price;
        private int num;


        public Movie() {
            this.name = "";
            this.price = 0;
            this.num = 0;
        }

        public Movie(String name, double price, int num) {
            this.name = name;
            this.price = price;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    static class TestMovie {
        public static double totalSum(Movie m) {
            return m.getPrice() * m.getNum();
        }

        public static void main(String[] args) {
            Movie a = new Movie();
            a.setName("Avatar");
            a.setPrice(30.0);
            a.setNum(100);
            System.out.println(totalSum(a));
            a.setNum(50);
            Movie b = new Movie(a.getName(), 20.0, a.getNum());
            System.out.println(totalSum(b));
        }

        public static String getMostPopularMovie(Movie[] t) {
            if (t == null || t.length == 0)
                return "";

            Movie maxTic = t[0];
            for (int i = 1; i < t.length; i++)
                maxTic = (maxTic.getNum() < t[i].getNum()) ? t[i] : maxTic;

            return maxTic.getName();
        }
    }

}
