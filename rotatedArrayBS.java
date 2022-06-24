class Solution {
    public int search(int[] nums, int target) {
        
        return binarySearch(nums,0 , nums.length-1, target);
    }
    
    public static int binarySearch(int[] nums,int s , int e,  int target){
        
        if(s>e){
            return -1;
        }
        int mid = (s + e)/2;
        if(nums[mid]==target){
            return mid;
        }        
        if(nums[s]<= nums[mid]){
             if (nums[s] <= target && target <= nums[mid]){
                 return binarySearch(nums, s, mid - 1, target);
             }
            else{
                 return binarySearch(nums, mid + 1, e, target);
            }          
        }

        if (nums[mid] <= target && target <= nums[e]){
                 return binarySearch(nums, mid + 1, e, target);
             }
          
        
         return binarySearch(nums, s,mid-1, target);
        
        
        
    }
}