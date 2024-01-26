// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time Complexity : 
/*
*   (O(log(m)+O(log(n))) where 
*    log(m) comes from first while loop, where we are doubling r pointer and reducing search space by half
*    log(n) comes from second while loop, where we are binary searching in l-r range found in second while loop
*/

// Space Complexity : Constant space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Find in comments in code


class Problem3 {
    public int search(ArrayReader reader, int target) {


        int l=0, r=1;
        // Find range containing target by comparing the right pointer with target
        // until we reach or cross the target
        while(reader.get(r)<target){
            l=r;
            r*=2;
        }

        // Use the range from previous step, and employ binary search
        while(l<=r){
            int mid=l+(r-l)/2;
            if(reader.get(mid)==target) return mid;
            if(target<reader.get(mid))  r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
