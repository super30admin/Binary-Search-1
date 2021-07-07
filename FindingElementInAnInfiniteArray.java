public class FindingElementInAnInfiniteArray {
	
	public int search(int [] nums, int target) {
		
		//edge case:
		if (nums.length == 0 && nums == null) {
			return -1;
		}
		
		//initailize low and high pointer.
		int low = 0;
		int high = 1;
		while(target > nums[high]) {
			low = high;
			high = high*2;
			//System.out.println(high);
		}
		//binary search starts with an while loop bro
		while (low<=high) {
			int mid = low + (high-low)/2;
			// base case
			if (nums[mid]== target) {
				//System.out.println(mid);
				return mid;
			}
			else if (target <=nums[mid]) {
				high = mid -1;
			}
			else {
				low = mid+1;
			}	
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {2,4,5,8,9,10,48,499,500};
		int target = 10;
		FindingElementInAnInfiniteArray findingElementInAnInfiniteArray = new FindingElementInAnInfiniteArray();
		System.out.println(findingElementInAnInfiniteArray.search(nums, target));
				
	}

}
