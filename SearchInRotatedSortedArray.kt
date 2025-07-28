// Time Complexity :  O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while(left <= right){
            val mid = left + (right - left)/2
            when{
                nums[mid] == target -> return mid
                //find where mid lies
                nums[left] <= nums[mid] -> {
                    //is target part of left
                    if(nums[left] <= target && target < nums[mid]){
                        right = mid - 1
                    }else{
                        left = mid + 1
                    }
                }

                nums[mid] <= nums[right] -> {
                    if(nums[mid] < target && target <= nums[right]){
                        left = mid + 1
                    }else{
                        right = mid - 1
                    }
                }
            }
        }
        return -1
    }
}