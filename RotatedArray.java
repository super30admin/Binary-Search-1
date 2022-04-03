// Time Complexity : O(log N)  where N is number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach : Binary Search 


class RotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int mid;
        
        while(low<=high){
            mid = high - (high - low)/2;
            if(target == nums[mid]){
                return mid;
            }
            
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid] ){
                    high = mid -1;
                }else{
                    low = mid +1;
                }
                
            }else{
                if(target <= nums[high] && target > nums[mid] ){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
                
            }
            
        }
        return -1;
    }

    public static void main(String args[]){
        RotatedArray array = new RotatedArray();
        int[] nums = {2,3,7, 9, 1};
        System.out.println(array.search(nums, 7)); 
    }
}