TC= O(logn)
SC= O(1)
class Solution {
     /**
     * @reader: reader.get(k) returns the element of the array at index k (0-indexed).
     * @return: return target index
     */
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        //Finding the range
        while(target > reader.get(high))
        {
            low = high;
            high = high*2;
        }

        //Normal Binary search
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target)
            {
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}