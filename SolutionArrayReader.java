// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SolutionArrayReader {
    public int search(ArrayReader reader, int target) {

        int start = 0;
        int end = Integer.MAX_VALUE;
        int mid = -1;
        int idx = -1;       
        
        // Basic Binary Search but instead search in initial range of 0 to Integer.MAX_VALUE
        while(start<=end){
            mid = (start + end)/2;
            if(target < reader.get(mid)){
                end = mid - 1;
            }else if(target > reader.get(mid)){
                start = mid + 1;
            }else{
                return mid;
            }
        }        
        
        return -1;
        
    }
}
