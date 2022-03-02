import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("My name is Szakacsi Ferenc-Adam");
        System.out.println("This programme will solve commonly seen test problems");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        String st = keyboard.nextLine();
        FizzBuzz(num);
        LongestPalSubstr(st);
        RomanToInt(st);
        LongestSubstringWithNoRepeatingCharacters(st);
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

    static int LongestPalSubstr(String str) {
        int n = str.length();
        if (n < 2) {
            return n;
        }
        int maxLength = 1, start = 0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i)) // increment 'high'
                high++;

            while (low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
                low--;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }
            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }
        System.out.print("Longest palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength));
        return maxLength;
    }

    private static int RomanToInt(String S) {
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
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans;
    }

    private static String LongestSubstringWithNoRepeatingCharacters(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }
}