package L04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021A {

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
                    break;
                case 4:
                    break;
                case 5:
                    q5();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    int c = q9(new int[]{3, 2, 2, 2, 5, 6, 6, 1, 3, 3, 3, 3, 1, 2}, 3);
                    break;
                case 10:
                    break;
                case 11:
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

    private static int q9(int[] arr, int num) {

        int count = 1;
        int countBlock = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                if (count >= num)
                    countBlock++;
                count = 1;
            }

        }
        return (count >= num) ? countBlock + 1 : countBlock;
    }

    private static void q5() {

        int num = sc.nextInt();
        int[] arr = new int[num];

        arr[0] = rd.nextInt(90) + 10;
        System.out.println(arr[0]);

        for (int i = 1; i < num; i++) {
            while ((arr[i] = rd.nextInt(90) + 10) <= arr[i - 1]) ;
            System.out.println(arr[i]);
        }

        int asarot = 3;
        int ahadot = 1;

        int num1 = asarot * 10 + ahadot;

    }


    private static void q1() {
        int size = 39;
        int number;
        float sum = 0;

        for (int i = 0; i < size; i++) {
            number = rd.nextInt(900) + 100;
            System.out.println(number);
            if (number % 2 == 0) {
                System.out.println(number / 100 + (number / 10) % 10 + number % 10);
            }
            sum += number;
        }

        System.out.println(sum / 39.0f);

    }


    public static int what(int[] arr) {
        int up, down;
        for (int i = 0; i < arr.length; i++) {
            up = 0;
            down = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    down++;
                if (arr[j] > arr[i])
                    up++;
            }
            if (up == down)
                return arr[i];
        }
        return -1;
    }

    public static int whatImp(int[] arr) {
        return arr[arr.length / 2];
    }
}
