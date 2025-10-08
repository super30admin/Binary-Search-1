/*
Time complexity: O(log(n))
Space complexity: O(1)

Approach:
    Since we don't know the upper bound, we can start with index 0 and 1 and increase the search space by twice
        until we exceed the upper limit.

   Now do binary search on that limit

 ****Question I had:
 Please correct me if my understanding is wrong***
 Why twice: We can increase if by any value but it won't have any effect. It will for sure reduce number of steps in finding
            the range but the search space in that range increases
 */
public class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        // Initialising the local variables
        int low = 0;
        int high =1;
        int mid;

        // While loop to find the search range
            // Will stop if we find the range or if upper limit exceeds the length of the array.
        while(target > reader.get(high)){
            low = high;
            high = high*2;
        }

        // Apply binary search on the range found above and do the search
        while(low<= high){
            mid = low + (high-low)/2;
            if (reader.get(mid) == target) return mid;
            if(reader.get(mid)>=target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        // Return -1 if the value isn't present
        return -1;
    }
}
