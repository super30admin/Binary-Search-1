package BinarySearch1;

public class Search_Rotated_Array {
    public int searchRotatedArray(int [] nums, int target) {
        // initialize pointers
        int begin = 0;
        int end = nums.length -1;
        // binary search over the rotated array
        while(begin <= end) {
            int middle = begin + (end - begin)/ 2;
            // target is in the mid
            if (nums[middle] == target) return middle;
            // pivot larger than start
            else if (nums[begin] <= nums[middle]) {
                //left non-rotated sorted subarray
                if(nums[begin] <= target && nums[middle] > target)
                    end = middle - 1;
                else
                    begin = middle + 1;
            }
            // pivot smaller than start
            else {
                //right non-rotated sorted subarray
                if (nums[middle] <= target && nums[end] > target)
                    begin = middle + 1;
                else
                    end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_Rotated_Array object = new Search_Rotated_Array();
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        // {4, 5, 6, 7, 0, 1, 2}, target = 5
        int result = object.searchRotatedArray(rotatedArray,9);
        System.out.println("result = "+result);
    }
}
