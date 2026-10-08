import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class binarySearch02 {

    public static LinkedList<Integer> random_initial() {
        Random rnd = new Random();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        while (nums.size() < 10) {
            nums.add(rnd.nextInt(99));
        }
        return nums;
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> nums = random_initial();

        nums.sort((a, b) -> { return a.compareTo(b); });

        System.out.print("Elements after sorting: : ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter target: ");
        int target = sc.nextInt();

        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("The target (" + target + ") at index " + result);
        } else {
            System.out.println("Cannot found " + target + " in this linked list");
        }
    }
}