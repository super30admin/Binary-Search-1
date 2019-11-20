// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : 124/196 test cases passed
// Any problem you faced while coding this : different edge cases were not passing because logic is flawed
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }else if(nums.length == 1){
            return (nums[0] == target) ? 0 : -1;
        }
        else if(nums.length == 2){
            int res = (nums[0] == target) ? 0 : -1;
            int res2 = (nums[1] == target) ? 1 : -1;
            if(res != -1){
                    return res;
                }
                else if(res2 != -1){
                    return res2;
                }
                else{
                    return -1;
                }
        }
        int pivot = findPivot(nums, target);
        System.out.println(pivot);
        if(pivot == -1){
            
            int index = Arrays.binarySearch(nums,target);
            return index < 0 ? -1 : index;
        }
        int binary1 = binarySearch(nums, 0, pivot-1 , target);
        int binary2 = binarySearch(nums, pivot, nums.length-1 , target);
        if(binary1 != -1){
            return binary1;
        }
        else if(binary2 != -1){
            return binary2;
        }
        else{
            return -1;
        }
    }
    
    
    static int findPivot(int[] nums, int target){
        int left = 0, right = nums.length -1;
        int pivot=-1;
        while (left <= right) {
            int mid = (left + right) / 2; 
        
        // Check if x is present at mid
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                pivot = mid;
                break;
            }
            else if(nums[left] < nums[right]){
                return -1;
            }
            else if(nums[mid] > nums[right]){
                left = mid ;
            }

            else if(nums[mid] < nums[left]){
                right = mid;
            }
            
            

        }
    return pivot;
}
    
    static int binarySearch(int[] arr,int l, int r, int x){
        while (l <= r) { 
        int m = (l + r) / 2; 
 
        if (arr[m] == x) 
            return m; 
  
        if (arr[m] < x) 
            l = m + 1; 
        else
            r = m - 1; 
    } 
    return -1; 
    }
    
    
    
}