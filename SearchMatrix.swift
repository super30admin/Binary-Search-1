// Time Complexity : O(Log M N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
   // Take the each row from the matrix , since the elements of the each row are in sorted order so check if the target element is present in row or not by comparing it with last element in the row, it the target is less than last element in the row then apply binary search in that row.   

func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        for row in 0..<matrix.count {
                var start = 0
                var end = matrix[0].count - 1
            if target < matrix[row][end] {
                while start <= end {
                    var mid = start + (end-start) / 2
                    if target > matrix[row][mid] {
                        start = mid + 1
                    }
                    else if target < matrix[row][mid] {
                        end = mid - 1
                    }
                    else {
                        return true
                    }
                }
            } else if target ==  matrix[row][end] {
                return true
            }
        }
        return false
    }
