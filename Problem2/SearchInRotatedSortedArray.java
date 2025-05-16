package Problem2;
// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class SearchInRotatedSortedArray {
    static  int search(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len-1;

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(arr[mid] == target) return mid;

            if(arr[mid] < arr[high]) {
                if(arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if(arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = search(nums, target);
        if( index == -1) {
            System.out.println(target + "not present in array");
        } else {
            System.out.println(target + " is present at "+ index );
        }
    }
}
