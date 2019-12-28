// Time Complexity : Binary Search - O(logn). Comparing to check if array is left or right sorted - O(1). So total Aysmtotic in the order of - O(logn)
// Space Complexity : O(k) depending on how deep the search can go (k levels). Everytime a recursive call is made, the recursion stack grows. Therefore, recursion is not encouraged in Binary Search
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class RotatedSearchRecursive {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1; //return -1 if input array is empty and/or length of array is 0
        int low = 0;
        int high = nums.length -1;
        return helper(nums, target, high, low); //call the helper function with initial parameters.
    }

    //Creating a helper function which will have the recursive logic
    private int helper(int[] nums, int target, int high, int low)
    { 
        if(low > high) return -1;  //low can never be greater than high, if this is the case then element is not present in the array
        int mid = low + (high - low) / 2; //calculate mid index with this formula avoiding integer overflow.
        //base case for recusion 
        if(nums[mid] == target) return mid; 
        
        //recursive logic
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
        return helper(nums, target, high, low);
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    RotatedSearchRecursive obj = new RotatedSearchRecursive();
    int[] input_array = {4,5,6,7,0,1,2};  //Sample input array rotated
    int target = 6;
    System.out.println(target + " is present in the input array at index - " + obj.search(input_array, target)); // returns 2
    target = 8;
    System.out.println(target + " is present in the input array at index - " + obj.search(input_array, target)); // returns -1
      
    }
}