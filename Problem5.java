
// Search TimeCpmplexity - O(logn)

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        
        return findPivot(nums, 0, end, target);
    }
    
    private int findPivot(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] <= nums[end]){
                if(nums[mid]<target && target<=nums[end]){
                    start = mid + 1;
                } else{
                    end = mid -1;
                }
            } else if(nums[mid] >= nums[start]){
                if(nums[start]<=target && target<nums[mid]){
                    end = mid -1;
                } else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

class Main{
    public static void main(String[] args){
        Solution obj = new Solution();
        int[] nums = [4,5,6,7,0,1,2];
        int target = 0;
        int result = obj.search(nums, target);
        System.out.println("Result: " + result);
    }
}