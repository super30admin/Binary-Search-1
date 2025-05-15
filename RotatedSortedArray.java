// Time Complexity: O(log n) 
// Space Complexity: O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchSortedArray {
    public int search(int[] nums, int target) {
       int left = 0;
       int right = nums.length-1;

       while(left <= right){
        int val = (left+right)/2;
        if(nums[val] == target){ // checking val is target
            return val;
        }
       

       if(nums[left] <= nums[val]){ // left sorted array
            if(nums[left] <= target && nums[val] > target){
                right = val - 1;            
            }
            else{
                left = val + 1;
            }

       }
       else{ //right sorted array
         if(nums[right] >= target && nums[val] <target){
            left = val + 1;
         }
         else{
            right = val - 1;
         }
       }
       }

       return  -1;
    
    }

  public static void main(String[] args) {
        SearchSortedArray sArr = new SearchSortedArray();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
    
        int target = 0;
        int result = sArr.search(arr, target);
        System.out.println("Test Case 1 " + target + ": " + result);

        target = 3;
        result = sArr.search(arr, target);
        System.out.println("Test Case 2 " + target + ": " + result);

        target = [1];
        result = sArr.search(arr, target);
        System.out.println("Test Case 3 " + target + ": " + result);
    }
}
