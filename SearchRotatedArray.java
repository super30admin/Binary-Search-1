// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. In a rotated sorted array atleast one of the side is going to be sorted when divided from middle
2. We will compare the corner elements to figure out which side is sorted
3. If middle element is greater than or equal to first element then left is sorted
4. First we check if the element we are at is equal to target or not, if yes return the middle index
5. if not, check which side is sorted, that will help us in deciding where to move
6. If the left side is sorted and the target falls in range of nums[low] and nums[middle], go left else right;
7. If the right side is sorted and the target falls in range of nums[middle] and nums[high], go right else left;
*/



public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int low=0; int high=nums.length-1;
        while(low<=high)
        {
            int middle=low+(high-low)/2;
            if(nums[middle]==target)
                return middle;
            else if(nums[middle]>=nums[low])
            {
                if(nums[low]<=target && nums[middle]>target)
                {
                    high=middle-1;
                }
                else low=middle+1;
                //left sorted
            }
            else{
                //right sorted
                if(nums[middle]<target && nums[high]>=target)
                    low=middle+1;
                else high=middle-1;
            }
           
        }
        return -1; 
    }

    public static void main(String[] args)
    {
        int[] nums = {4,5,6,7,0,1,2};
        SearchRotatedArray binarySearch=new SearchRotatedArray();
        System.out.println(binarySearch.search(nums, 0)); 
    }
}
