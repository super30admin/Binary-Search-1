/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//Time complexity: O(log t), t=target index
//Space complexity:O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target)
            return 0;
       int left=0; int right=1;
        while(reader.get(right)<target)
        {
            left=right;
            right= right *2;
            
        }
        int mid;int num;
        while(left<=right)
        {
            mid=(left+((right-left)/2));
            num=reader.get(mid);
            if(num==target)
                return mid;
            else if(num < target)
            {
                left=mid+1;
            }
            else if(num>target)
            {
                right=mid-1;
            }
        }
        return -1;
    }
}