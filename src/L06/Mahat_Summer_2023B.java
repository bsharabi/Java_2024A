package L06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2023B {

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
                    int[] arr = new int[20];
                    for (int i = 0; i < 20; i++) {
                        arr[i] = rd.nextInt(40) - 20;
                    }
                    System.out.println(Arrays.toString(arr));
                    q3(arr);
                    break;
                case 4:
                    FlowerPackage fl = new FlowerPackage("Rose", 1.4);
                    System.out.println(fl);
                    String[] flowerName = {"Rose", "Tulip", "Sunflower", "Daffodil", "Marigold", "Daisy", "Orchid", "Carnations"};
                    double[] flowerPrice = {1.4, 8.6, 7.5, 2.8, 4.3, 5, 2.25, 1.125};
                    FlowerPackage[] flArray = new FlowerPackage[10];
                    for (int i = 0; i < 10; i++) {
                        flArray[i] = new FlowerPackage(flowerName[rd.nextInt(8)], rd.nextInt(1500), rd.nextInt(12) + 4, flowerPrice[rd.nextInt(8)]);
                    }
                    FlowerPackage.compensation(flArray, 12);
                    break;
                case 5:
                    System.out.println("return secret for 37245 is -> " + secret(37245));
                    System.out.println("Example: 2222  -> " + secret(2222));
                    System.out.println("הפעולה מחשבת את כמות הספרות האי-זוגיות במספר נתון");

                    int[] arr2 = {7245, 64, 14783, 32, 824, 199};
                    System.out.println("Sod return -> " + sod(arr2));
                    System.out.println("הפעולה מחזירה את המספר האחרון בו כמות הספרות האי-זוגיות הוא המינימלי מבין כלל המספרים במערך ");
                    break;
                case 6:
                    System.out.println("Secret(aaaBBB) -> " + secret("aaaBBB"));
                    System.out.println("לא נכון, דוגמא נגדית: aaa-BBB");
                    System.out.println("Secret(aaa-BBB) -> " + secret("aaa-BBB"));
                    String[] strings = {"aA", "aA", "aA", "aA", "aA", "aA"};
                    System.out.println("Example strings: " + Arrays.toString(strings));
                    System.out.println("mystery(strings) -> " + mystery(strings));
                    System.out.print("לא נכון, דוגמא נגדית: ");
                    System.out.println(Arrays.toString(strings));
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    int number = 123456;
                    int w = q9(number);
                    int[] arrSort1 = {35, 923, 781, 12349, 1892};
                    int[] arrSort2 = {2, 358, 181, 5821, 1742, 36621, 27731};
                    bool = q9_b(arrSort1);
                    q3_c(arrSort1, arrSort2);


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

    private static void q3_c(int[] arrSort1, int[] arrSort2) {


        for (int i = 0; i < arrSort1.length; i++) {
            boolean bool = false;
            for (int j = 0; j < arrSort2.length; j++) {
                if (q9(arrSort1[i]) == q9(arrSort2[j]))
                    bool = true;
            }
            if (!bool)
                System.out.print(ANSI_GREEN + arrSort1[i] + " ");
        }

        for (int i = 0; i < arrSort2.length; i++) {
            boolean bool = false;
            for (int j = 0; j < arrSort1.length; j++) {
                if (q9(arrSort1[j]) == q9(arrSort2[i]))
                    bool = true;
            }
            if (!bool)
                System.out.print(ANSI_CYAN + arrSort2[i] + " ");
        }

        System.out.println(ANSI_RESET);
    }

    private static boolean q9_b(int[] arrSort) {

        for (int i = 0; i < arrSort.length - 1; i++) {
            if (q9(arrSort[i]) >= q9(arrSort[i + 1]))
                return false;
        }
        return true;
    }

    private static int q9(int number) {

        int sum = 0;
        number /= 10;

        while (number > 10) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    private static void q3(int[] arr) {
        if (arr == null)
            return;

        int counter = 0;
        boolean hasZero = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                hasZero = true;
            if (arr[i] >= 0)
                counter++;
            else
                counter--;
        }

        if (!hasZero && counter == 0)
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ANSI_RED + arr[i] + " ");
            }
        else
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(ANSI_BLUE + arr[i] + " ");
            }

        System.out.println(ANSI_RESET);

    }

    public static int secret(int num) {
        int res1 = 0, res2 = 0;
        while (num > 0) {
            res1++;
            if (num % 2 == 0)
                res2++;
            num = num / 10;
        }
        return res1 - res2;
    }

    public static int sod(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (secret(arr[i]) <= secret(arr[res]))
                res = i;
        }
        return arr[res];
    }

    static class FlowerPackage {


        private String type;
        private int num;
        private int time;
        private double price;

        public FlowerPackage(String type, int num, int time, double price) {
            this.type = type;
            this.num = num;
            this.time = time;
            this.price = price;
        }

        public FlowerPackage(String type, double price) {
            this.type = type;
            this.num = 2000;
            this.time = 12;
            this.price = price;
        }


        public static void compensation(FlowerPackage[] arr, int flyTime) {

            double sum = 0;

            for (int i = 0; i < arr.length; i++) {
                FlowerPackage fl = arr[i];
                if (fl.getTime() < flyTime) {
                    System.out.println(fl);
                    sum += fl.getNum() * fl.getPrice();
                }
            }
            System.out.println(sum);

        }


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "FlowerPackage{" +
                    "type='" + type + '\'' +
                    ", num=" + num +
                    ", time=" + time +
                    ", price=" + price +
                    '}';
        }
    }

    public static boolean secret(String str) {
        int i = 0;
        while (i < str.length() / 2) {
            if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                return false;
            }
            i++;
        }
        if (str.length() % 2 != 0) i++;
        while (i < str.length()) {
            if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean mystery(String[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (secret(arr[i]) != secret(arr[j]))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
