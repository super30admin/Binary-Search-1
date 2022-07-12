// Time Complexity :  O(log(n))
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) == 0{
        return false
    }
    m := len(matrix)
    n := len(matrix[0])
    left := 0
    right := m*n -1
    
    for left <= right{
        pivot_idx := left + (right-left)/2
        pivot_element := matrix[pivot_idx/n][pivot_idx%n]
        
        if pivot_element == target{
            return true
        }else if pivot_element > target{
            right = pivot_idx - 1
        }else{
            left = pivot_idx + 1
        }
        
    }
    
    return false
    
}
