
public class SearchArrayInfinite {
	public static void main(String[] args) {
		int[] nums = {3,5,7,10,11,13,14,15,17,19};
		int target = 13;
		int ans = searchArrayInfinite(nums,target);
		System.out.println(ans);
	}
	private static int searchArrayInfinite(int[] nums, int target) {
		int low = 0, high = 1;
		while(nums[high] < target) {
			low = high+1;
			high = 2* high;
		}
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid] < target) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
			
		}
		return -1;
	}

}
