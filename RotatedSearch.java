// Time Complexity : Binary Search - O(logn). Comparing to check if array is left or right sorted - O(1). So total Aysmtotic in the order of - O(logn)
// Space Complexity : O(n) - size of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class RotatedSearch {
    
    public int search(int[] nums, int target) { //searching using an iterative while loop
        if(nums == null || nums.length == 0)  // base case. If array is null or empty, there is no need to search anything. Just return -1.
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high)           
        {
            int mid = low + (high - low) / 2;   // Formula to calculate mid avoiding the integer overflow probelem
            if(nums[mid] == target)             // target value will always converge at nums[mid] if it is present in the input array. This is the only success point in the function.
                return mid;
            else if(nums[mid] >= nums[low]){   // Check if elements on the left side of the mid index are sorted.
            if(target >= nums[low] && target < nums[mid]) // If the above condition satisfies, Check if target is contained in the left sorted side of the array.
            {
                high = mid - 1;  //don't consider right side of the array for searching if above condition satisfies. 
            }else{
                low = mid + 1;   // if it does not contain in the left sorted side, change low pointer and do not consider left sorted side.
            }
            
            }
            else{  // if left side is not sorted then right side has to be sorted. 
                if(target > nums[mid] && target <= nums[high]) //Check if target is contained in the right sorted side of the array.
                {
                    low = mid +1; //don't consider left side of the array for searching if above condition satisfies. 
            }else{
                    high = mid -1 ; //if it does not contain in the right sorted side, change high pointer and do not consider right sorted side.
                }
            }
            
        }
          return -1;  //finally, after all iterations if low = high = mid and nums[mid] != target , return -1 as number does not exist.
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    RotatedSearch obj = new RotatedSearch();
    int[] input_array = {4,5,6,7,0,1,2};  //Sample input array rotated
    int target = 6;
    System.out.println(target + " is present in the input array at index - " + obj.search(input_array, target)); // returns 2
    target = 8;
    System.out.println(target + " is present in the input array at index - " + obj.search(input_array, target)); // returns -1
      
    }
}

