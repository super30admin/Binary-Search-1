// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Dont have leetcode premium so haven't //executed the solution on leetcode
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class UnknownLengthArray {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(0);
		list.add(3);
		list.add(5);
		list.add(9);
		list.add(12);
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MAX_VALUE);
		
		int low = 0;
		int high = 1;
		int target = 12;
		
		while(list.get(high) < target) {
			low = high;
			high = 2 * high;
		}
		
		int output =  binarySearch(list, target, low, high);
		
		System.out.println(output);
		
	}

	private static int binarySearch(List<Integer> list, int target, int low, int high) {
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			if(list.get(mid) == target) {
				return mid;
			} else if(list.get(mid) < target) {
				low = mid + 1;
			} else {
				high = mid -1;
			}
		}
		return -1;
	}
}

