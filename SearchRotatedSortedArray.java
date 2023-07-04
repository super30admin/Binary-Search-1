/*
 * Time Complexity: O(LogN)
 * Space Complexity: O(1)
 */

class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = low + (high -low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && nums[mid] > target){
                    high = mid -1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(obj.search(arr, 0));
    }
}
