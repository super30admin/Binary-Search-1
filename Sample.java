/*
**************SEARCH IN A ROTATED SORTED ARRAY**************

APPROACH 1: Iterate approach

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach */

class Solution {
    public int search(int[] nums, int target) {
        /*We are just iterating through the array and searching for the target.
        If found return its index else return -1 */

        for (int i=0; i<nums.length;i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}

/*
APPROACH 2: Binary Search
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach */

class Solution {
    public int search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1 ;
        
        while (low <= high){
            int mid = low + (high - low )/2;    //Calculating the middle element
        
            if (nums[mid] == target){       //If mid is equal to target, return mid as its index
                return mid;
            }
            else if (nums[mid] >= nums[low]){       //If the middle element is greater than the initial/first element, then the target would be between low to mid
                /*if target is between low and mid, then search in left part of the array i.e. between low and mid
                else serach in right part of the array i.e. mid to high*/
                if ((nums[low] <=target) && (target < nums[mid])){      
                    high = mid -1;                                      
                }
                else {
                    low=mid + 1;
                }
            }
            else{
                if ((nums[mid] < target) && (target <=nums[high])){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;      //If target not found, return -1
    }
}


/*
**************SEARCH IN A SORTED ARRAY OF UNKNOWN SIZE**************

APPROACH 1: Binary Search

Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : No


Your code here along with comments explaining your approach */


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
     
        if (reader.get(0) == target){
            return 0;
        }
        int slow = 0;
        int fast = 1 ;
        /*Two pointers + windown approach. 
        if the element is greater than target, the loop exists. 
        I.e. target is between slow and fast window. */
        
        while (reader.get(fast) < target){
            slow = fast;
            fast = fast * 2;
        }
        // Perform Binary serach on the array
        while (slow <= fast){
            int mid = slow + (fast - slow)/2;
            int midEle = reader.get(mid);
            
            if (midEle == target)
                return mid;
            if (midEle>target)
                fast = mid - 1;
            else
                slow = mid + 1;
        }
        return -1;
    }
}