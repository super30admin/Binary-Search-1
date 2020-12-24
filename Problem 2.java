//Time Complexity: O(log n) (Binary search algorithm)
//Space Complexity: O(1)

//Brute force approach will be to search for each and every element in the array: O(n)
//Using Binary Search algorithm, we are reducing the interval for search and hence not every element needs to be 
//traversed: O(log n)

class RotatedSearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right)
        {
            int mid = (left + right) / 2;
            
            if(nums[mid] == target)
                return mid;        
            else if(nums[mid] <= nums[right])
            {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else
            {
                if(target < nums[mid] && target > nums[right])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
