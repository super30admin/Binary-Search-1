/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        //Finding Boundaries by shifting right by 1 bit or multiplying right by 2 to make it in log n time
        while(reader.get(right)<target)
        {
            left=right;
            right<<=1;
        }

        //Normal binary search
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return -1;
    }
}