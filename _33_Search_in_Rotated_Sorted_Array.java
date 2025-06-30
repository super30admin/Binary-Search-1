/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// Take a loop and traverse all the elements in the array,and return true if it is found else false.

/**** Method 2 ****/
//Time Complexity: O(logn)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

// So we will perform a binary search but the deciding condition to move left section of the array or right section, is to find out if the left part is sorted and then check if target present in left if yes we move to left section, we move to right section. Same with else case when right section is sorted.

/**** Method 1 ****/
// public class _33_Search_in_Rotated_Sorted_Array {

//     public int search(int[] nums, int target) {

//         for(int i =0;i<nums.length;i++){
//             if(nums[i] == target){
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

/**** Method 2 ****/
public class _33_Search_in_Rotated_Sorted_Array {

  public int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] <= nums[hi]) {
        if (nums[mid] <= target && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      } else {
        if (nums[lo] <= target && target <= nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
    }

    return -1;
  }
}
