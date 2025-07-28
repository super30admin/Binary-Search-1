// Time Complexity :  O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
class Solution {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val ROWS = matrix.size
        val COLS = matrix[0].size
        var left = 0
        var right = (ROWS * COLS) - 1
        while(left <= right){
            val mid = left + (right - left)/2
            //change mid index into 2D matrix index by first dividing by "COLS" and then taking MOD by COLS to get index within range
            val midV = matrix[mid / COLS][mid % COLS]
            when {
                midV == target -> return true
                target < midV -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return false
    }
}

// Time Complexity :  O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// line 37 did incorrect value check soon corrected

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val ROWS = matrix.size
        val COLS = matrix[0].size
        for(r in 0 until ROWS){
            if(matrix[r][0] <= target && target <= matrix[r][COLS - 1]){
                if(binarySearch(matrix[r], target)){ return true } else { continue }
            }
        }
        return false
    }

    fun binarySearch(nums:IntArray, target:Int): Boolean{
        var left = 0
        var right = nums.size - 1

        while(left <= right){
            val mid = left + (right - left) / 2
            when{
                nums[mid] == target -> return true
                target < nums[mid] -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return false
    }
}