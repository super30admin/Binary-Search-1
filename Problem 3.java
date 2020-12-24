//Time Complexity: O(log n)
//Space Complexity: O(n) (Recursive Calls)

//Approach: Modify binary seach to point the right pointer to the index next to the left pointer and if the target does 
//not fit in the range of left and right pointers, update left pointer to right and double the position of right pointer
//till the target fits in the range.

class SortedUnknown {
   
    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = 1;

        while(target > nums[right])
        {
            left = right;
            right = right * 2;
        }
        return binarySearch(nums, left, right, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target)
    {
        while(right >= left)
        {
            int mid = left + (right-left)/2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                return binarySearch(nums, left, mid-1, target);
            return binarySearch(nums, mid+1, right, target);
        
        }
        return -1;
    }
    
}
