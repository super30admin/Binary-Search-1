//Time Complexity: O(lon n)
//Space complexity: O(1)
//running on leetcode: yes
class Solution {
    public int search(ArrayReader reader, int target) {
        //initialize low and high
        int low = 0;
        int high = 1;
        while (reader.get(high) < target)
        {
            low = high;
            high = high*2;
        }
        return binarySearch(low, high, target, reader);
    }
    
    public int binarySearch(int low, int high, int target, ArrayReader reader)
    {
        while (low <= high)
        {
            int mid = low + (high-low)/2;
            if (reader.get(mid) == target)
            {
                return mid;
            }
            else if (target < reader.get(mid))
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}
