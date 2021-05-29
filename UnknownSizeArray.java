
//Time Complexity: O(logn)
//Space complexity: O(1)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //Initialize 2 pointers 1 and j;
        int i=0, j=1;
        while(reader.get(j) < target )
        {

            i=j;
            j=2*j;
            //if j pointer exceeds max length of array then set j= max last index possible
            if(j>=10000)
                j=10000-1;
        }
        return binarySearch(reader, target, i, j);

    }

    public int binarySearch(ArrayReader reader, int target, int low, int high)
    {
        if(low > high)
            return -1;
        int mid=low+(high-low)/2;

        if(reader.get(mid)==target)
        {
            return mid;
        }
        else if(reader.get(mid)>target)
        {
            return binarySearch(reader, target, low, mid-1);
        }
        else
        {
            return binarySearch(reader, target, mid+1, high);
        }
    }
}