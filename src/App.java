import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("My name is Szakacsi Ferenc-Adam");
        System.out.println("This programme will solve commonly seen test problems");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        String st = keyboard.nextLine();
        FizzBuzz(num);
        RomanToInt(st);
        keyboard.close();
    }

    private static void FizzBuzz(int num) {
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static int RomanToInt(String S) {
        int ans = 0, num = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            switch (S.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}