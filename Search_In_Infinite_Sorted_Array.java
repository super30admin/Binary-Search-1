// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


 //if arr[low] <= target <= arr[high], apply binary search
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 10;

        while(target > reader.get(high))
        {
            low = high + 1; // low = prev high + 1
            high = high * 2; // high = prev high * 2 as it is increasing exponentially
        }

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int midEle = reader.get(mid);

            if(midEle == target){
                return mid;
            }

            else if(target < midEle)
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