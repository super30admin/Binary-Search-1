// Time Complexity : O(logT) where T is the target element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out the time complexity.
// Is saying O(logT) correct or we should say O(logN)


// Your code here along with comments explaining your approach
/**
The initial while loop takes logT iterations to come to the correct start and end index. 2^k < T < 2^(k+1). logT = K
The second while loop performs binary search on an array of length 2^(k+1)-2^k = 2^K = T. Hence this loop also takes logT
**/
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        while(target > reader.get(end)){
            start = end;
            end = end * 2;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            int num = reader.get(mid);
            if (num == target){
                return mid;
            }else if(num < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}