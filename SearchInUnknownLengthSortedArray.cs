using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class SearchInUnknownLengthSortedArray
    {

        //public bool Search(ArrayReader reader, int target)
        //{

        //    int low = 0;
        //    int high = 1;

        //    if(reader.read(1)<target)
        //    {
        //        low = high;
        //        high = 2 * high;
        //    }

        //    return BinarySearch(reader, low, high, target);
        //}

        //public bool BinarySearch(ArrayReader reader, int low, int high, int target)
        //{
        //    while(low<=high)
        //    {
        //        int mid = low + (high - low) / 2;

        //        if (reader.read(mid) == target)
        //            return true;

        //        if (reader.read(mid)>target)
        //        {
        //            high = mid + 1;
        //        }
        //        else
        //        {
        //            low = mid - 1;
        //        }
        //    }

        //    return false;
        //}
    }
}
