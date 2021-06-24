// Time Complexity : O(logN) where N is an index of target value.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
As we dont know the input before hand but know its sorted, find boundaries and do binary search
we can check if it atleast has 2 elements and mark them as left and right
and if our target is greatr than right we keep updated left to right's index and right to right*2;
and so on until target is less than the right index's value
Now we got the boundaries and we can do the binary search
 */


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target) return 0;

        //set boundaries
        int left=0, right=1;
        while(reader.get(right)< target){
            left = right;
            right = right*2;

        }

        //Binary Search
        int mid, num;
        while(left<=right){
            mid = (left+right)/2;
            num=reader.get(mid);
            if(num==target) return mid;
            if (num > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;

    }
}