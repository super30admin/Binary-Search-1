/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int max = Integer.MAX_VALUE;
        while(reader.get(max)<2147483647)
            max=max/2;
        while(reader.get(max)!=2147483647)
            max++;
        max--;
        
        int low=0;
        int high=max;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(target==reader.get(mid))
                return mid;
            else if(target<reader.get(mid))
                high = mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}