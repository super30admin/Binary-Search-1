// Time Complexity : O(nlog n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * The problem is to find an elment in the array of unknown length
 * 1. as we dont know the lenght of an array in advance to perform binary search start end pointer from index 1 and keep doubling end
 * pointer till array[end] is less that our target so that we have a range to find and element
 * 2. then perform binary search on the range
 */
public class SearchInaRotatedSortedArrayInfiniteLength {
	public int search(int[] nums, int target) {
		//edge cases
		if(nums == null || nums.length ==0)
			return -1;
        int start = 0, end = 1;
        while(nums[end]<= target) {
        	start= end;
        	end = 2* end;
        }
        return binarySearch(nums, start, end , target);
    }
	public int binarySearch(int[]nums, int start, int end, int target ){
        while(start<= end) {
        	int mid = (start+end)/2;
        	//return index if item found
        	if(nums[mid]== target)
        		return mid;
        	//left side of the array is sorted
        	else if(target < nums[mid])
        		end = mid-1;
        	else
        		start= mid+1;
        }
        return -1;
	}
	public static void main(String args[]) {
		SearchInaRotatedSortedArrayInfiniteLength sArray= new SearchInaRotatedSortedArrayInfiniteLength();
		int [] nums = {4,5,6,7,8,9,10,12,14,16,17,19,20,21,22,25,26,27,29,30};
		System.out.println(sArray.search(nums, 10));
		System.out.println(sArray.search(nums, 8));
	}
}

