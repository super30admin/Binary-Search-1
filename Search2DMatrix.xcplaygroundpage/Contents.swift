
// Time complexity: O(logN)
// Space complexity: O(n)

func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
    var row = 0, column = matrix[row].count - 1
    
    while row < matrix.count && column >= 0 {
        if matrix[row][column] == target {
            return true
        }
        // Target element is in next row
        if matrix[row][column] < target {
            row += 1
        } else {
            // target is in previous row
            column -= 1
        }
    }

    return false
}

let array = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
let target = 17
searchMatrix(array, target)
