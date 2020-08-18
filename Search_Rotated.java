
public class Search_Rotated {
	
		public int search( int nums[], int target) {
			
			int st = 0;
			int end = nums.length-1;
			
			while(st<=end) {
				int mid = st+(end-st)/2;
				
				if(target == nums[mid]) {
					return mid;
				}
				else if(nums[mid]>=nums[st]) {
					if(target>=nums[st] && target<nums[mid])
						end = mid - 1;
					else st = mid+1;
				}
				else {
					if(target>nums[mid] && target<=nums[end])
						st = mid+1;
					else 
						end = mid-1;
				}
			}
			return -1;
		}
		public static void main(String [] args) {
			Search_Rotated sr = new Search_Rotated();
			int nums[] = {4, 5, 6, 7, 0, 1, 2};
			int target = 0;
			System.out.println("Element found at index: "+sr.search(nums, target));
		}

}
