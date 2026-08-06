import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LabQueue01 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 101; i <= 105; i++) {
			q.add(i);
			System.out.println(i);
		}
		
		System.out.println("Queue => " + q);
		System.out.println();
		
		while(!q.isEmpty()) {
			System.out.println("Calling number: " + q.peek());
			System.out.println("Providing service number: " + q.poll());
			System.out.println();
		}
		
		System.out.println("Queue => " + q);
	}

}
