
public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberArrayController nums = new NumberArrayController();
		nums.display("Display initial array:");
		
		int[] new_nums = new int[nums.getNums().length - 1];
		int delete_index = 2;
		
		for(int i =0; i < delete_index;i++) {
			new_nums[i] = nums.getNums()[i];
		}

		//copy
		for(int i = delete_index +1; i < nums.getNums().length; i++)
			new_nums[i-1] = nums.getNums()[i];
		
		nums.setNums(new_nums);
		nums.display("\nAfter deleted data index 2:");
	}

}
