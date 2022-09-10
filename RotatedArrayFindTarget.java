//approach - one of the side from the mid must besorted, look frit and then find target with binary search.
//TC - O(log n)
//space: O(1)


class RotatedArrayFindTarget {
    public int search(int[] nums, int target) 
    {
        //arr = [5, 6, 7, 8, 0, 1, 2] , find 0's index
        
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length -1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) 
              return mid;
                            
            //look for the left side sorted
            else if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid - 1; //target on left
                }
                else
                {
                    low = mid + 1; //target on right                   
                }
            }
            else //obvious right side is sorted
            {
                if(nums[mid] < target && target <= nums[high] )
                {
                    low = mid +1; //target on right
                }
                else //target on left
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}


/*
* Time complexity : O(log N)        because its binary search
* space Complexity: O(1)             we are not using any auxiliary space, we are just doing search operation on the given array!
*
* approach:
* because the given array is Rotated, we can say that either of the side of the middle element will be sorted.
so, we will look for that sorted side first.
now once I get the sorted side, I willl check if the target lies ito the sorted side! if yes, I will upadate my pointers accordingly.
* if I found that target is not placed on the sorted side, I know it would be on unsorted side,
* so i will on that part and look for the target over there.
*/