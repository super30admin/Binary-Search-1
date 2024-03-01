// tc = o(log n)
//sc = o(1);
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){ //check if left array is sorted
                if(target >= nums[low] && target < nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{ //right array is sorted
                 if(target > nums[mid] && target <= nums[high]){
                     low = mid + 1;
                 }
                 else {
                     high = mid -1;
                 }   
            }


        }
        return -1;
    }
}

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(s.search(nums, 0));
        
    }
}
