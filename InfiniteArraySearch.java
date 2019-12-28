// Time Complexity : Binary Search - O(logn). To find the search set we need to find the low and high by doubling the high until high is greater than targe. This is in the order of logn. So total O(logn)
// Space Complexity : O(n) - size of the input array. here n could even be infinity
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : There is an error in the code,
											//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 16
											//at InfiniteArraySearch.search(InfiniteArraySearch.java:5)
											//at Main.main(InfiniteArraySearch.java:32)
//Update: Solved the error. Figured out what I was doing wrong in the 2nd Problem. My program was correct because my code logic was assuming it to be an infinite array. So when my target element was near the end of the sample array that I provided, the high pointer was being set to an index out of the array. So it was giving an error. But in theory if we assume it to be an infinite array, it should not give the error.													


class InfiniteArraySearch{ 
	public int search(int[] nums, int target){	//set low as 0 and high as 2nd lowest index
		int low = 0;
		int high = 1;
		if(nums == null || nums.length == 0) return -1; //check base case if array is empty or null, then return -1. no point in searching
		while(target >= nums[high])
		{ // until the target is not contained between low and high, keep doubling high and setting new low to previous high
		low = high;
		high = high * 2;
		}	
		while(low <= high)
		{ //once the search set is found from the above iteration, perfrom usual binary search.
			int mid = low + (high - low) / 2;
			if(nums[mid] == target){ return mid; }
			else if(nums[mid] > target) { high = mid -1; }
			else{ low = mid + 1; }

		}
		return -1;
	}

}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    InfiniteArraySearch obj = new InfiniteArraySearch();
    int[] input_array = {2,4,6,8,9,10,12,14,16,18,20,22,24,26};  //Sample input array rotated
    int target = 4; 
    System.out.println(target + " is present in the input array at index - " + obj.search(input_array, target)); // returns 11
    target = 5;
    System.out.println(target + " is present in the input array at index - " + obj.search(input_array, target)); // returns -1
      
    }
}
