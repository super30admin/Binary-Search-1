
public class SearchRottedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Input: nums = [4,5,6,7,0,1,2], target = 0
		int[] nums = { 4,5,6,7,0,1,2};
		int target =0;
		System.out.println(search(nums,target ));

	}
	public  static int search(int[] nums, int target) {
		int mid;
		int left = 0;
		int right = nums.length -1;
		while(left <= right) {
			mid = (left + right)/2;
			if(nums[mid] == target) return mid;
			if(nums[left] <= nums[mid]) {
				if(nums[left] <= target && nums[mid] >= target ) right = mid -1;
				else
					left = mid +1;
			}
			else {
				if(nums[right] >= target && nums[mid] <= target )
					left = mid +1;
				else
					right = mid -1;
			}
		}
		return -1;
	}

}
