import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class jumpsearch02 {

    public static LinkedList<Integer> random_initial() {
        Random rnd = new Random();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        while (nums.size() < 10) {
            nums.add(rnd.nextInt(99));
        }
        return nums;
    }

    public static int jumpSearch(int[] nums, int target) {
        int n = nums.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        // กระโดดทีละ step จนเจอบล็อกที่ค่าสุดท้ายของบล็อก >= target
        while (nums[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1;
            }
        }

        // ค้นแบบ linear ภายในบล็อกนั้น
        for (int i = prev; i < Math.min(step, n); i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> nums = random_initial();

        nums.sort((a, b) -> { return a.compareTo(b); });

        System.out.print("Elements after sorting: : ");
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter target: ");
        int target = sc.nextInt();

        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        int result = jumpSearch(arr, target);

        if (result != -1) {
            System.out.println("The target (" + target + ") at index " + result);
        } else {
            System.out.println("Cannot found " + target + " in this linked list");
        }
    }
}