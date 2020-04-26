//Time Complexity : O(logn)
//Space Complexity : O(1) As no auxilary space is used
// It did run successfully on Leetcode
// Problems :  No problem



/*
Here, we are using binary search to find the element
After we find the mid element, either left or right side will always be sorted
We'll search for our element in both the sides
 */


public class Binary_Search_1_Problem_1 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0)
        {
            return -1;
        }
        int left = 0 ;
        int right = nums.length -1;

        while(left<=right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[left]<=nums[mid]) //Sorted Left Path
            {
                if(target>=nums[left] && target <=nums[mid])
                {
                    right = mid -1;
                }
                else
                {
                    left = mid +1;
                }
            }
            else
            {
                if(target >= nums[mid] && target<=nums[right])
                {
                    left = mid +1;
                }
                else
                {
                    right = mid -1;
                }
            }

        }
        return -1;
    }



}
