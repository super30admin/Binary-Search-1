
public class InfiniteSortedArray {
	static int search(int[] nums, int target) {
		int slow = 0;
		int fast = 2;
		try {
			while(nums[fast] < target) {
				slow = fast;
				fast = fast*2;
			}
		} catch(Exception e) {
			try {
				while(nums[slow] <= target) {
					if(nums[slow] == target) {
						return slow;
					}
					slow++;
				}
			} catch(Exception ex) {
				System.out.println("Not Found!");
			}
		}
		return binarySearch(nums, slow, fast, target);
	}
	
	static int binarySearch(int[] arr, int l, int r, int x) {
		while(l<=r) {
			int mid = l+(r-l)/2;
			if(arr[mid] == x) {
    			return mid;
	    		} else if(arr[mid] < x) {
	    			l = mid+1;
	    		} else if(arr[mid] > x) {
	    			r = mid-1;
	    		}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 4, 5, 8, 10, 11, 14, 15, 17, 19, 20, 22, 25};
		int target = 13;
		System.out.println(search(nums, target));
	}

}
