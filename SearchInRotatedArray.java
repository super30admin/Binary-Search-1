// Time Complexity :O(logn)
// Space Complexity :O(n) for size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int start=0, end=nums.length-1;

        while(start<=end){
            if(nums[start]==target) return start;
            if(nums[end]==target) return end;
            int mid = start + (end - start)/2;
            if(nums[mid]==target) return mid;

            else if(nums[mid]>nums[start]){//Everything is good.
                if(target>nums[start] && target<nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else {
                if (target > nums[mid] && target < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
    }
}