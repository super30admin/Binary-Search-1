using System;
namespace Algorithms
{
    public class SearchInUnknownSizeArray
    {
        /// Time Complexity : O(log n)
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public int Search(ArrayReader reader, int target)
        {
            int low = 0;
            int high = 1;

            while (reader.get(high) < target)
            {
                low = high;
                high = high * 2;
            }


            int mid;
            //do BST in the boundary
            while (low <= high)
            {
                mid = low + (high - low) / 2;
                if (reader.get(mid) == target) return mid;
                if (reader.get(mid) > target)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            return -1;

        }
    }
}
