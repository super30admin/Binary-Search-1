/*
  Time complexity: O(log n)
  Space complexity: O(1)

  Code ran successfully on Leetcode: yes

  Approach: The search space is doubled in every iteration until the reader returns a value that is between low and high. Binary search is then performed on it to retrieve the index is the element is available or -1 otherwise.


*/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *     public int Get(int index) {}
 * }
 */

class Solution {
    public int Search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high)<target)
        {
            low = high;
            high = 2*high;
        }

        return BinarySearch(reader,target,low,high);
    }

    private int BinarySearch(ArrayReader reader, int target, int low,int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(reader.get(mid)==target)
            {
                return mid;
            }
            else
            {
                if(reader.get(mid)<target)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
