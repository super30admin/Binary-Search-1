// Time Complexity log(m * n)
// Space complexity O(1)

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var left = 0
        var right = m*n - 1
        var mid : Int
        var pivotElement : Int
        while (left <= right) {
            mid = left + (right - left) /2
            pivotElement = matrix[mid/n][mid%n]
            if (target == pivotElement) return true
            else if(target < pivotElement) right = mid - 1
            else left = mid + 1
        }
        return false
    }
}