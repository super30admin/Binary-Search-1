public class SearchInRotatedArray {

	public static void main(String[] args) {
		int s[] = {4,5,6,7,0,1,2}; //rotated
		//int s[] = {0,1,2,4,5,6,7}; //sorted array.
		Solution ss= new Solution();
		System.out.println(ss.search(s, 7));
	}
}


class Solution {
    public int search(int[] nums, int target) {

    if (nums == null || nums.length == 0) {
        return -1;
    }


    int left = 0, right = nums.length - 1;
     //Make Sure  left is less than right.
    while (left <= right) {
        //left bias
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        //if left part is monotonically increasing, or the pivot point is on the right part
        if (nums[left] <= nums[mid]) {
            //must use "<=" at here since we need to make sure target is in the left part,
            //then safely drop the right part
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            }
            else {
                //right bias
                left = mid + 1;
            }
        }

        //if right part is monotonically increasing, or the pivot point is on the left part
        else {
            //must use "<=" at here since we need to make sure target is in the right part,
            //then safely drop the left part
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
}
