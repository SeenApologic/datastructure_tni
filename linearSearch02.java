import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class linearSearch02 {

    public static LinkedList<Integer> random_initial() {
        Random rnd = new Random();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        while (nums.size() < 10) {
            nums.add(rnd.nextInt(99));
        }
        return nums;
    }

    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> nums = random_initial();

        System.out.print("Elements : ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter target: ");
        int target = sc.nextInt();

        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("The target (" + target + ") at index " + result);
        } else {
            System.out.println("Cannot found " + target + " in this linked list");
        }
    }
}