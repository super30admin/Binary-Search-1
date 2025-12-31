
public class SearchInRotatedSortedArray {

	// Time complexity O(log n);
	// space complexity O(1);
	public int search(int[] nums, int target) {
		if (nums==null || nums.length<0) {
			return -1;
		}
		
		//1- define low and high
		//2- find  barrier(mid)
		//3- identify sorted side
		// 4 - do binary search in sorted side
		int low=0, high=nums.length-1, mid=0;
		while (low<=high) {
			mid= low + (high-low)/2;
			 if (nums[mid]==target) {
				 return mid;
			 }else if (nums[low]<=nums[mid]) {
				 //left sorted 
				 if (target >= nums[low] && target<nums[mid] ) {
					 high=mid-1;
				 }else {
					 low=mid+1;
				 }
			 }else {
				 // right sorted
				 if (target>nums[mid] && target<=nums[high]) {
					 low=mid+1;
				 }else {
					 high= mid-1;
				 }
			 }
		}
		
		return -1;
		
	}
	
	public static void main(String args[]) 
    { 
        
    } 
}
