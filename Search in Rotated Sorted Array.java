class Solution {
    public int search(int[] nums, int target) {
        
        
        
        int begin = 0;
        int end = nums.length - 1;
        
        
        
        //Check if this mid is greater than the start. If it is greater than start then the 1st half is sorted.
        while(begin < end){
            int mid = begin + (end - begin) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[end]){
                begin = mid;
            }

            else{
                begin = mid + 1;
            }
        }

        return -1;
    }
}