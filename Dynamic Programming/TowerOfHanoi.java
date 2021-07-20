import java.util.*;
class TowerOfHanoi {

	public static void main(String[] args) {

		// Initializing the source tower
		Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);

		// Creating helper and destination tower 
		Stack<Integer> h = new Stack<>();
		Stack<Integer> d = new Stack<>();

		// Printing the result before
		System.out.println("Source Before: "+ s);
		System.out.println("Destination Before: "+ d);

		// Call..
		implementHanoi(s,h,d,s.size());

		// Printing the result after
		System.out.println("Source After: "+ s);
		System.out.println("Destination After: "+ d);
	}

	private static void implementHanoi(Stack<Integer> s, Stack<Integer> h, Stack<Integer> d, int n) {

		// Base conditions
		if (n == 0) return;

		if (n == 1) {
			d.push(s.pop());
			return;
		}

		// Moving 0 to n-1 disks from source tower to helper tower with the help of recursion.
		implementHanoi(s,d,h,n-1);

		// Now moving nth number of disk to destination tower from source tower.
		d.push(s.pop());

		// Moving 0 to n-1 disks from helper tower to destination tower with the help of recursion.
		implementHanoi(h,s,d,n-1);
	}
}