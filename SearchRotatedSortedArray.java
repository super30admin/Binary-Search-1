// Time Complexity : O(log n) since binary search
// Space Complexity : O(1) - no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
// 1. Use binary search
// 2. In rotated sorted array, either half of the array is guaranteed to be sorted,
//      use that property to eliminate one half i.e reduce the search space by half in each iteration

public class SearchRotatedSortedArray {
    private static int search(int[] nums, int target) {
        int l=0, h=nums.length-1;

        while(l <= h) {
            int mid = l + (h-l)/2;
            if(nums[mid] == target) {
                return mid;
            }
            // left half is sorted
            else if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // right half is sorted
            else {
                if(target > nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,1,2,3}, 4)); //0
        System.out.println(search(new int[]{4,5,6,1,2,3}, 5)); //1
        System.out.println(search(new int[]{4,5,6,1,2,3}, 6)); //2
        System.out.println(search(new int[]{4,5,6,1,2,3}, 1)); //3
        System.out.println(search(new int[]{4,5,6,1,2,3}, 2)); //4
        System.out.println(search(new int[]{4,5,6,1,2,3}, 3)); //5
        System.out.println(search(new int[]{4,5,6,1,2,3}, 23)); //-1
        System.out.println(search(new int[]{4,5,6,1,2,3}, -3)); //-1
        System.out.println(search(new int[]{40,50,60,10,20,30}, 15)); //-1
        System.out.println(search(new int[]{40,50,60,10,20,30}, 45)); //-1

        System.out.println(search(new int[]{4,5,6,1,2}, 4)); //0
        System.out.println(search(new int[]{4,5,6,1,2}, 5)); //1
        System.out.println(search(new int[]{4,5,6,1,2}, 6)); //2
        System.out.println(search(new int[]{4,5,6,1,2}, 1)); //3
        System.out.println(search(new int[]{4,5,6,1,2}, 2)); //4
        System.out.println(search(new int[]{4,5,6,1,2}, 13)); //-1
    }
}
