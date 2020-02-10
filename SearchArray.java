
public class SearchArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		int ans = searchArray(nums, target);
		System.out.println(ans);
	}
	private static int searchArray(int[] nums, int target) {
		
		int low =0, high = nums.length-1;
		//if(high < low) return -1;
		while(low <= high) {
			int mid = low +(high - low)/2;
			
			if(target == nums[mid]) {
				return mid;
			}
			
			if(target < nums[mid]) {
				if(nums[low]<= target && target < nums[mid]) {
					high = mid-1;
				}
				else {
					low = mid+1;
				}
			}
			
			if(target > nums[mid]) {
				if(nums[mid]<= target && target < nums[high]) {
					low = mid+1;
				}
				else {
					high = mid-1;
				}
			}
			
		}
		return -1;
	}

}
