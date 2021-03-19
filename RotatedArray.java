class Solution {
    public int search(int[] nums, int target) {
        if (nums == null && nums.length ==0){
            return -1;
        }
        int l = 0; int h = nums.length-1;
        
        while (l<=h){
            int mid = l + (h-l)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[l] <= nums[mid]){
                //left is sorted
                if (nums[l] > target || target > nums[mid] ){
                    //go right
                    l = mid+1;
                }else{
                    //go left
                    h = mid-1;
                }
                
            } else{
                //right is sorted
                if (target > nums[h] || target < nums[mid]){
                    //go left
                    h = mid-1;
                }else{
                    //go right
                    l = mid+1;
                }
            }
        }
        return -1;
        
    }
}
