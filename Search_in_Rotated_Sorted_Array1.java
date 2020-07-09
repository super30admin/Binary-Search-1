//1. Iterative Approach
public class Search_in_Rotated_Sorted_Array1 {
	//Approach: 1. Since the array is rotated, either any one part of the array is sorted, 
	//so we will search the range of sorted part of the array. 
	//2. If target falls between that range of first and last element of the sorted part, 
	//we will apply binary search and search the target. 
	//3. If not we are sure, the other part of the array contains target, 
	//so we will search the unsorted part with binary search again 
	
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            //if array is left sorted
            else if(nums[left] <= nums[mid])
            {
                if(nums[left] <= target &&  target < nums[mid])
                {
                    right = mid - 1;
                }else
                    left = mid + 1;
            }
            //right array is sorted
            else
            {
                if(nums[mid] < target &&  target <= nums[right])
                {
                    left = mid + 1;
                }else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
//Time Complexity : O(log n)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//2. Recursive approach - Same solution as above but with recursion
class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return binarySearch(0, nums.length-1);
    }
    int binarySearch(int left, int right)
    {
        
        if(left > right)
            return -1;
        
        if(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[left] <= nums[mid])
            {
                if(nums[left] <= target && target < nums[mid])
                    return binarySearch(left, mid-1);
                else
                    return binarySearch(mid+1, right);
            }
            else
            {
                if(nums[mid] < target && target <= nums[right])
                    return binarySearch(mid+1, right);
                else
                    return binarySearch(left, mid-1);
            }
        }
        return left;
    }
}
//Time Complexity : O(log n)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//3. Finding rotated index using binary search and then finding target using binary search
class Search_in_Rotated_Sorted_Array3 {
    int target = 0;
    
    //Approach 1. find rotated index with binary search and then split array into two parts,
    //so you can check the range of both the parts and apply binary search to find the target. 
    public int search(int[] nums, int target) {
        this.target = target;
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0]== target?0:-1; 
        
        int pivot = findingPivot(nums, 0, nums.length-1); 
       // System.out.println(pivot);
        
        int index =0;
        if(pivot == -1)
        {
            index = binarySearch(nums, 0, nums.length-1);
            return index;
        }     
        if(nums[0] > target)
            index = binarySearch(nums, pivot, nums.length-1);
        else 
            index =binarySearch(nums, 0, pivot);
        return index;
    }
    public int findingPivot(int[] nums, int left, int right)
    {
        if(nums[left] < nums[right])
            return -1;
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid + 1])
                return mid+1;
            else{
                if(nums[mid] < nums[left] )
                    right = mid -1;
                else 
                    left = mid +1;
            } 
        }
        return -1;
    }
    public int binarySearch(int[] nums, int left, int right)
    {
        while(left <= right)
        {
            int mid = (left + right)/2;
            if( nums[mid] == target)
                return mid;
            else 
            {
                if(target < nums[mid])
                    right = mid-1;
                else if(target > nums[mid])
                    left = mid +1;
            }
        }
           return -1;
    }
}
//Time Complexity : O(log n) + O(log n) = O(log n), 2 binary search for finding rotated index and
// finding target using binary search
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
