    /* Time complexity: O(log n)
    */
    /*
    Solution successfully passed all the test cases on Leetcode 
    */
   /* Approach:
        1. Repeatedly divided the sorted array into two halves to find the target element
        2. Declared and initialized the left and right pointers which denote the first and 
        last index of the rotated sorted array
        3. Calculated the mid of the array
        4. Divided the array into two halves by comparing the target element with the mid element
        5. If the target element is equal to the mid element, return the index of the mid element
        6. Else if check if the mid element value is greater than the value at the left most index 
        of the array, if yes then check if the target element is greater than the left element and 
        less than the mid element then the right pointer will be on the left of the mid pointer, 
        therefore reduce the right pointer by 1, if not then the target element lies in the right
        half of the array therefore the left pointer will be mid + 1
        7. Else if the mid element is less than the left element then the target element will be present 
        in the right half of the mid element
        8. Loop will repeat till the mid element equals the target, if target element is present otherwise 
        the method will return -1;
   */
    
  class SearchRotatedArray {
   public int search(int[] nums, int target) {
    int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;
        
        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[left]) {
                if(target <= nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {
                if(target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return  -1;
    }
   } 
