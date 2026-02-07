//Time complexity: O(m+n) where m is the number of rows and n is the number of columns in the matrix
//Space complexity: O(1) as we are using constant space to store the indices
class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        if(matrix.isEmpty() || matrix[0].isEmpty()) return false

        var i = 0
        var j = matrix[0].size-1

        while(i < matrix.size && j >= 0){

            if(matrix[i][j] == target){
                return true
            }
            else{
                if(target < matrix[i][j]){
                    j-=1
                }else{
                    i+=1
                }
            }

        }


        return false
    }
}