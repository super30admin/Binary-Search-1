public class RotatedSortedArray{
    public static int binSearchInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[low] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] array1 = {4,5,6,7,8,9,0,1};
        int[] array2 = {4,5,6,7,8,9,0,1};
        int[] array3 = {7,8,9,0,1,2,3,4,5};
        int[] array4 = {7,8,9,0,1,2,3,4,5};
    
        System.out.println(RotatedSortedArray.binSearchInRotatedArray(array1,6));
        System.out.println(RotatedSortedArray.binSearchInRotatedArray(array2,0));
        System.out.println(RotatedSortedArray.binSearchInRotatedArray(array3,9));
        System.out.println(RotatedSortedArray.binSearchInRotatedArray(array4,5));

    }
}