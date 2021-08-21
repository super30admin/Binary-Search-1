// Time Complexity : o(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //we make use of two pointer slow and fast
        int slow=0;
        int fast=1;
        //cant use for loop as we dont know the size of array
        while(reader.get(fast)<target){
            slow=fast;
            fast=fast*2;
        }
        while(slow<=fast){
            int mid= slow + (fast-slow)/2;
            if(reader.get(mid)==target)return mid;
            else if(reader.get(mid)>target){
                fast=mid-1;
            }
            else{
                slow=mid+1;
            }
        }     
        return -1;
    }
}