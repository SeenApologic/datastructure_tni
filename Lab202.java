import java.util.ArrayList;
import java.util.Scanner;

public class Lab202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        int[] initial_numbers = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        for (int n : initial_numbers) {
            numbers.add(n);
        }
        System.out.println("Initial numbers = " + numbers);

        System.out.print("Enter number to add at the end: ");
        int addLast = sc.nextInt();
        numbers.add(addLast);
        System.out.println("After add last = " + numbers);

        System.out.print("Enter number to insert: ");
        int insertValue = sc.nextInt();
        int lastDigit = 1;
        
        numbers.add(lastDigit, insertValue);
        System.out.println("After insert at index " + lastDigit + " = " + numbers);

        int secondLastDigit = 4;
        numbers.remove(secondLastDigit);
        System.out.println("After remove index " + secondLastDigit + " = " + numbers);

        int thirdLastDigit = 4; 
        int date = 9;
        
        numbers.set(thirdLastDigit, date);
        System.out.println("After update index " + thirdLastDigit + " = " + numbers);

        System.out.println("Final numbers = " + numbers);
    }
}