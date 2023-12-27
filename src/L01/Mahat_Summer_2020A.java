package L01;

import java.text.MessageFormat;
import java.util.Scanner;

public class Mahat_Summer_2020A {

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
                    Clock c = new Clock(20, 45);
                    System.out.println(c.getInterval());

                    Clock c1 = new Clock(24, 0);
                    System.out.println(c1.getInterval());

                    q2_b();
                    break;
                case 3:
                    ans = what(12345);
                    System.out.println("c -> " + ans);
                    ans = what(222);
                    System.out.println("c -> " + ans);
                    System.out.println("הפעולה מחשבת את כמות הספרות האי-זוגיות במספר");

                    why();
                    System.out.println("הפעולה מחפשת את המספר הראשון אשר לו מספר ספרות אי זוגיות מינימלי");
                    break;
                case 4:
                 bool=   q4(new int[]{22,56,123,12,10,-4,2});
                    System.out.println(bool);

                    bool=   q4(new int[]{22,10,123,12,10,-4,2});
                    System.out.println(bool);


                    bool=   q4(new int[]{22,56,123,12,10,-4,12});
                    System.out.println(bool);

                    bool=   q4(new int[]{22,12,123,12,10,-4,2});
                    System.out.println(bool);

                    bool=   q4(new int[]{22,12,123,12,10,-4,12});
                    System.out.println(bool);
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

    private static boolean q4(int[] arr) {
        int size = arr.length;
        if(size<3 || size%2==0)
            return false;

        int mid = size/2;
        int middle = arr[size/2];

        for (int i = 0; i < mid; i++) {
            if(arr[i]<= middle)
                return false;
        }
        for (int i = mid+1; i < size; i++) {
            if(arr[i]>= middle)
                return false;
        }
        return true;
    }


    private static void q1() {
        int cntNum = 0, cntEv = 0, cntPos = 0, sumPos = 0;
        int num;

//        num = sc.nextInt();
//        while (num != 0) {
//            cntNum++;
//            cntEv += (num % 2 == 0) ? 1 : 0;
//            if (num > 0) {
//                sumPos += num;
//                cntPos++;
//            }
//            num = sc.nextInt();
//        }

        while ((num = sc.nextInt()) != 0) {
            cntNum++;
            cntEv += (num % 2 == 0) ? 1 : 0;
            if (num > 0) {
                sumPos += num;
                cntPos++;
            }
        }
//        double avg = (cntPos == 0) ? 0 : (double) sumPos / cntPos;
        double avg = (double) sumPos / cntPos;
        System.out.println(ANSI_BLUE + "counter  -> " + cntNum);
        System.out.println(ANSI_GREEN + "Even -> " + cntEv);
        System.out.print(ANSI_RED);
        System.out.println("Pos -> " + cntPos);
        System.out.println(ANSI_CYAN + "Sum Pos -> " + sumPos);
        System.out.println(ANSI_YELLOW + "Avg -> " + avg);
        System.out.println(ANSI_RESET);
    }

    static class Clock {
        private int hour; //0-23 שעה
        private int min; //0-59 דקות

        public Clock(int hour, int min) {
            this.hour = hour;
            this.min = min;
        }

        public int getInterval() {

//            int dayMin = 1440;
//            int currentDayMin = hour * 60 + min;
//            return dayMin - currentDayMin;


            //      (23 - 20)  * 60 +  (60 - 45)
            //        180           +     15 = 195
            return (23 - hour) * 60 + (60 - min);
        }
    }

    private static void q2_b() {
        System.out.println("Enter Time (hour & min");
        Clock c1 = new Clock(sc.nextInt(), sc.nextInt());

        System.out.println("Enter Time (hour & min");
        Clock c2 = new Clock(sc.nextInt(), sc.nextInt());

        if (c1.getInterval() < c2.getInterval()) {
            System.out.println("c1");
        } else {
            System.out.println("c2");
        }
    }

    // input (num) = 12345
    public static int what(int num) {
        int i = 0;
        int c = 0;
        System.out.println("--- iter --- num --- c");
        System.out.println("   " + i + "       " + num + "     " + c);
        while (num > 0) {
            c += (num % 2);
            num /= 10;
            System.out.println("   " + i++ + "       " + num + "     " + c);
        }
        return c;
    }

    public static void why()
    {

        int[] arr = {1245, 34781, 23, 468, 139 };
        int res = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (what(arr[i]) < what(res))
            {
                res = arr[i];
            }
        }
        System.out.println(res);
    }

}
