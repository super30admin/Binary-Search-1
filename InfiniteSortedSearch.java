// Time Complexity :O(log n) where n are the number of elements in the array
// Space Complexity :O(1) since the operation is performed on a fixed number of elements and no auxillary data is produced.
// Did this code successfully run on Leetcode : Couldn't check
// Any problem you faced while coding this : No

interface ArrayReader{
    public int get(int index);
}

public class InfiniteSortedSearch {
    public int search(ArrayReader reader, int target)
    {
        int low=0;int high=1;
        while(target<=reader.get(high))
        {
            low = high;
            high = 2*high;
        }

        return binarySearch(target,low,high,reader);

    } 

    private int binarySearch(int target,int low,int high,ArrayReader reader)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(low) == target)
            {
                return low;
            }
            else if(reader.get(high) == target)
            {
                return high;
            }

            else if(target> reader.get(mid))
            {
                low = mid+1;
            }
            else
            {
                high= mid-1;
            }
        }

        return -1;
    }
}