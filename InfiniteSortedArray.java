//Ran all the test cases
/* 
    TC - O(logn + logn) = O(logn) where n is the index of the target value.
    One logarithmic TC for finding the boundaries and one logarithmic TC for binary search
    SC - O(1) - no auxilary space used
    Method - Since we dont know the array size, we start with first element, and continue checking the element in the exponential index, to see if the element is less than the target. (this will reduce the time complexity - we would not visit all the elements, only the exponential ones)
If we crossed the target element, it means the element is somewhere before it and we perform binary search starting from the current low and high  boundaries. 
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
        int low = 0;
        int high = 1;
        while(reader.get(high)!= (Integer.MAX_VALUE - 1) && target >reader.get(high) )
        {
            if(target==reader.get(high))
                return high;
            low = high;
            high = high * 2;
        }
        return binarySearch(low,high,target,reader);
    }
    public int binarySearch(int low, int high, int target, ArrayReader reader)
    {
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(target == reader.get(mid))
            {
                return mid;
            }
            else if(target > reader.get(mid))
            {
                low = mid + 1;
            }
            else 
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}