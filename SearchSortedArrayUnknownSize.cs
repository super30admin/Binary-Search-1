using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms
{
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : The idea on doubling the search space and determining the left and right pointers
    // before binary search was not intutional. I had to review the class again on youtube to understand the logic
    class SearchSortedArrayUnknownSize
    {
        //Time Complexity - O(log n) + O(log m) where m+n = N (total length of the array)
        // First log n is the time complexity for increasing search space by 2 and 
        // and the second log m for performing binary search within that range
        // Space Complexity - O(1)
        public int Search(ArrayReader reader, int target)
        {
            var left = 0;
            var right = 1;
            while (reader.Get(right) != int.MaxValue && target > reader.Get(right))
            {
                left = right;
                right = 2 * right; //Expand the search space by 2 times
            }

            return BinarySearch(reader, left, right, target);
        }

        public int BinarySearch(ArrayReader reader, int left, int right, int target)
        {
            //Now search the element using binary search
            while (left <= right)
            {
                var mid = left + (right - left) / 2;
                if (reader.Get(mid) == target) return mid;
                else if (reader.Get(mid) > target)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return -1;
        }

    }
}
