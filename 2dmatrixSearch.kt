class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val row = matrix.size
        val column = matrix[0].size

        var i = 0
        var j = row*column - 1

        while(i<=j) {
            val mid = i+(j-i)/2
            val element = matrix[mid/column][mid%column]

            if(element>target) j=mid-1
            else if(element<target) i=mid+1
            else return true
        }
        return false

    }