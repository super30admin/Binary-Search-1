// Time Complexity : O(log N), N represents the number of elements in the array
// Space Complexity : O(N) , N repesents the number of elements in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some Compile errors


// Your code here along with comments explaining your approach
	/*First We will check if the middle element is the target, we will check if the element at the start if lesser than mid element, if it is lesser, we will restrict our seach to left side 
    and check if the target is greater than start element and lesser than mid element. If the element is within this range, we will move the end pointer before the mid element,
     if the element is not within this range, we will move our st index to the right side of the mid element
     Similarly we do check for the right side of array.
     this is a modification of Binary search*/

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
