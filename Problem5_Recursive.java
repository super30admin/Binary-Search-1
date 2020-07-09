// Search Time Complexity : O(logn)

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        
        return findPivot(nums, 0, end, target);
    }
    
    //Recursive method of finding through the rotated array
    private int findPivot(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] <= nums[end]){
                if(nums[mid]<target && target<=nums[end]){
                    return findPivot(nums, mid+1, end, target);
                } else{
                    return findPivot(nums, start, mid-1, target);
                }
            } else if(nums[mid] >= nums[start]){
                if(nums[start]<=target && target<nums[mid]){
                    return findPivot(nums, start, mid-1, target);
                } else{
                    return findPivot(nums, mid+1, end, target);
                }
            }
        }
        return -1;
    }
}

//Driver Class
class Main{
	public static void main(String[] args){
		Solution obj = new Solution();
        int[] nums = [4,5,6,7,0,1,2];
        int target = 0;
        int result = obj.search(nums, target);
        System.out.println("Result: " + result);
	}
}