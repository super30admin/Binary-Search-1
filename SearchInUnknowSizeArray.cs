using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    /*
     * T.C: O(log N)
     * S.C: O(1)
     */
    public class SearchInUnknowSizeArray
    {
        public int search(ArrayReader reader, int target)
        {
            int low = 0;
            int high = 1;

            while(ArrayReader.get(high)<target)
            {
                low = high;
                high = 2 * high;
            }

            return BinarySearch(reader, low, high, target);
        }

        private int BinarySearch(ArrayReader reader,int low, int high, int target)
        {
            while(low<=high)
            {
                int mid = low + (high - low) / 2;

                if (reader.get(mid) == target)
                    return mid;

                if(reader.get(mid)<target)
                {
                    low = mid + 1;
                }
                else
                {
                    mid = high - 1;
                }
            }

            return -1;
        }
    }
}
