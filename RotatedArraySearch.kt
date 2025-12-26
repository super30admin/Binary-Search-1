// Time Complexity O(logn)
// Space Complexity O(1)

class Solution {
    fun search(nums: IntArray, target: Int): Int {
            var l = 0 
            var r = nums.size - 1

            while(l <= r) {
                val mid = l + (r -l)/ 2
                if (nums[mid] == target) {
                    return mid
                }
                else if (nums[l] <= nums[mid]) {
                    if (nums[l] <= target && target < nums[mid]) {
                        r = mid -1
                    } else {
                        l = mid + 1
                    }
                } else {
                    if (nums[mid] < target && target <= nums[r]) {
                        l = mid + 1
                    } else {
                        r = mid -1
                    }
                }
            }
        return -1
    }
}