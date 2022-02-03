// Time Complexity : - To find pivot : O(n) if rotated at the last index, so we need to iterate the whole arr till the pivot and BinSearch complexity O(Log n); so O(n) + O(Log n)
// Space Complexity : O(1), Storing only variables, no extra space required.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// My Notes : Pending - Make it O(Log n); get clue from constraints.
public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        // if empty arr, then return -1
        if (nums.length > 0) {
            boolean isRotated = false;
            int lastIdx = nums.length - 1;
            // Check if the array is possibly rotated
            if (nums[0] > nums[lastIdx]) {
                isRotated = true;
            }
            // BinSearch  variables
            int start = 0, end = lastIdx, mid = 0;
            // If rotated then find pivot else do the normal B.S
            if (isRotated) {
                int idx = 0;
                int firstElem = nums[idx];
                while (firstElem < nums[++idx]) {}
                //System.out.println("Pivot rotated at : " + idx);
                // Checking the range, target fits in range then check
                if(target <= nums[idx] || target <= nums[lastIdx]){
                    start = idx;
                    end = lastIdx;
                }else{
                    start = 0;
                    end = idx-1;
                }
            } 
            // // Traditional iterative binary search
            while (start <= end) {
                mid = start + (end - start) / 2;
                 //System.out.println("Value of start,end,mid " + start + "," + end + "," + mid);
                if (target == nums[mid]) {
                    return mid; // returing idx of elem found
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        RotatedSortedArray obj = new RotatedSortedArray();
        System.out.println(obj.search(nums,0));
    }
}
