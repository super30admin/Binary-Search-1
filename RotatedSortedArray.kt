class Solution {

    fun search(nums: IntArray, target: Int): Int {

        var left = 0
        var right = nums.size - 1

        while (left < right) {

            val mid = left + (right - left) / 2

            if (nums[mid] == target) return mid

            if (nums[left] <= nums[mid]) {
                if (target in nums[left]..nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else if (nums[mid] < nums[right]) {
                if (target in nums[mid]..nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }

            }

        }



        return -1

    }

}