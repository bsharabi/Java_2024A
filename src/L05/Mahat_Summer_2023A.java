package L05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2023A {

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
                    q1();
                    break;
                case 2:
                    break;
                case 3:
                    int[] arr = {6, 24, 12, 8, 44, 3, 7};
                    bool = q3(arr);
                    System.out.println(Arrays.toString(arr));
                    System.out.println("isOrdered -> " + bool);
                    int[] arr2 = {6, 24, 12, 8, 16, 22};
                    System.out.println(Arrays.toString(arr2));
                    bool = q3(arr2);
                    System.out.println("isOrdered -> " + bool);

                    int x = rd.nextInt(20) + 1;
                    int y = x + rd.nextInt(20);
                    int size = rd.nextInt(y - x);

                    arr = q3_b(size, x, y);
                    System.out.println(Arrays.toString(arr));
                case 4:
                    break;
                case 5:
                    int[] arr3 = {1, 25, 3, 8, 10, 4, 20, 5};
                    bool = what(arr3);
                    int[] arr4 = {0, 9, 2, 7, 4, 5, 6, 3, 8, 1};
                    System.out.println(ANSI_RESET);
                    System.out.println("Return -> " + bool);
                    System.out.println("הפעולה בודקת שכל המספרים באינדקסים הזוגיים היא סדרה עולה ובאי זוגיים סדרה יורדת");
                    int max = maxArray(arr4);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    int[] a = {1, 25, 3, 8, 10, 4, 20, 5};
                    int[] b = {5, 20, 4, 10, 8, 3, 25, 1};
                    bool = q8(a, b);
                    int[] a1 = {8, 6, 7, 10, 13, 2};
                    int[] b1 = {2, 7, 6};
                    bool = what(a1, b1);
                    System.out.println("what(a,b) -> " + bool);
                    int[] a2 = {8, 6, 7, 10, 13, 2};
                    int[] b2 = {8, 6, 7, 10};
                    bool = what(a2, b2);
                    System.out.println("what(a,b) -> " + bool);
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    int[][] mat = matRan();
                    bool = q11(mat);
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

    private static int[][] matRan() {
        int[][] mat = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = rd.nextInt(23);
            }
        }
        return mat;
    }


    private static boolean q11(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {

            if (mat[i][i] % 2 == 0)
                return false;

            for (int k = 0; k < mat.length; k++)
                if (mat[i][k] > mat[i][i])
                    return false;

            for (int k = 0; k < mat.length; k++)
                if (mat[k][i] > mat[i][i])
                    return false;

        }

        return true;

    }

    //O(n)
    // הלולאה מבצעת n איטרציות (עוברת על כל תא בדיוק פעם אחת)
    private static boolean q8(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        int size = a.length;
        for (int i = 0; i < size; i++) {
            if (a[i] != b[size - 1 - i])
                return false;
        }
        return true;
    }

    //O(1)
    private static int maxArray(int[] arr) {
        int size = arr.length;
        if (size % 2 == 0)
            return Math.max(arr[1], arr[size - 2]);
        return Math.max(arr[1], arr[size - 1]);

    }

    private static int[] q3_b(int size, int x, int y) {
        int[] arr = new int[size];

        arr[0] = x + rd.nextInt(y - x + 1);

        for (int i = 1; i < size; i++) {
            if (arr[i - 1] % 2 == 0)
                arr[i] = x + rd.nextInt(y - x + 1);
            else
                while ((arr[i] = x + rd.nextInt(y - x + 1)) % 2 == 0) ;
        }

        return arr;
    }

    public static boolean what(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print((i % 2 == 0) ? ANSI_BLUE : ANSI_RED);
            System.out.print(a[i] + ((a.length - 1 == i) ? "" : ", "));
        }
        System.out.print(ANSI_RESET);
        System.out.println("]");
        System.out.println("iter     a[i] < a[i-2]           a[i] > a[i-2]   ");
        for (int i = 2; i < a.length - 1; i++) {
            if (a[i] < a[i - 2]) {
                System.out.print(ANSI_BLUE + "  " + (i - 2) + "      a[" + i + "]" + " < a[" + (i - 2) + "]   " + false);
                return false;
            }
            System.out.print(ANSI_BLUE + "  " + (i - 2) + "      a[" + i + "]" + " < a[" + (i - 2) + "]   " + true);
            i++;
            if (a[i] > a[i - 2]) {
                System.out.println(ANSI_RED + "      " + "a[" + i + "]" + " > a[" + (i - 2) + "]   " + false);
                return false;
            }
            System.out.println(ANSI_RED + "      " + "a[" + i + "]" + " > a[" + (i - 2) + "]   " + true);
        }
        return true;
    }


    public static boolean what(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        boolean f;
        for (int i = 0; i < n - m + 1; i++) {
            f = true;
            for (int k = m - 1; k >= 0; k--) {
                if (a[i + k] != b[k])
                    f = false;
            }
            if (f) return true;
        }
        return false;
    }

    private static boolean q3(int[] arr) {

        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                break;
        }

        for (; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                return false;
        }
        return true;
    }

    private static void q1() {

        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            int temp = i;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (i % sum == 0)
                System.out.print(i + " ");
            sum = 0;

        }

    }


}
