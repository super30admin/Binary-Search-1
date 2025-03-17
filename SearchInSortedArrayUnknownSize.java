/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

//Time Complexity: O(logn)+O(logk)
//Space Complexity: O(1)
//Did this code successfully run on Leetcode : yes

/*
1. Identify the search space of target by increasing the search window size by 2
2. Do a binary search on the identified search space

 */

class Solution {
    public int search(ArrayReader reader, int target) {

        int low=0;
        int high=1;

        //Find the search space of target
        while(target>reader.get(high)){
            low=high;
            high=high*2;
        }

        //Find the target in the identified search space
        while(low<=high){
            int mid=low+(high-low)/2;

            if(reader.get(mid)==target)
                return mid;

            else if(reader.get(mid)<target)
                low=mid+1;

            else
                high=mid-1;
        }
        return -1; //if target not found
    }
}