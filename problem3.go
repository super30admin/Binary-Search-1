// Time Complexity :  O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * type ArrayReader struct {
 * }
 *
 * func (this *ArrayReader) get(index int) int {}
 */

func search(reader ArrayReader, target int) int {
    left := 0
    right:=1
    
    for reader.get(right) < target{
            left = right
            right = 2*right
    }
    
    
    
    for left <= right{
        mid := left + (right-left)/2
        val := reader.get(mid)
        if val == target{
            return mid
        }else if val < target{
            left = mid+1 
        }else if val > target {
            right = mid-1
        }
    }
    
    return -1
}
