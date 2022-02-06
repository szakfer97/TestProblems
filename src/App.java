import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("My name is Szakacsi Ferenc-Adam");
        System.out.println("This programme will solve commonly seen test problems");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        FizzBuzz(num);
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
}
