// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initially, check if the target is present at the 0th index.
// 2. If not, dynamically expand the search range by doubling high until reader.get(high) is greater than or equal to target.
// 3. After finding an appropriate search range, perform binary search between low and high.
// 4. Update low and high pointers based on the comparison of the middle element with the target.
// 5. Repeat steps 3-4 until low is less than or equal to high.
// 6. If the target is found, return its index; otherwise, return -1.

// Your code here along with comments explaining your approach in three sentences only
 // This is ArrayReader's API interface.
 // You should not implement it, or speculate about its implementation
 interface ArrayReader {
     public int get(int index) {}
 }


 class SearchInSortedArrayUnKnownSize {
    public int search(ArrayReader reader, int target) {
        
        if(reader.get(0) == target) return 0;
        int low =0;
        int high =1;
        while(reader.get(high) < target)
        {
            low = high;
            high = 2* high;
        }

        while(low <=  high)
        {
            int mid = low +(high -low)/2;
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) > target)
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
