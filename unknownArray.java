//Search in an sorted unkown array leetcode problem no 702

class Solution {
    public int search(ArrayReader reader, int target)
    {
        int low=0;
        int high = 1;
        while(reader.get(high)<target)
        {
            low=high;
            high=high*2;
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(reader.get(mid) == target)return mid;
            else if(reader.get(mid)>target)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }


        }
        return -1;
    }
}