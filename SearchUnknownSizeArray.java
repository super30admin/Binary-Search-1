// Time Complexity : O(log(n))
// Space Complexity : Auxiliary space complexity is O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : -

//Default ArrayReader given in problem statement which fetches the array values from infinite stream
interface ArrayReader{
    public int get(int index);
}
/* Given a sorted array of unknown length and a number to search for,
return the index of the number in the array. Accessing an element out of bounds throws exception.
 If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.
*/
public class SearchUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        int low = 0,  high = 1;
        //Step1: Get the range of search
        //As it is sorted array in asc order, if high gets smaller than target, that means we got the range of our search
        while(reader.get(high) < target) {
            low = high;
            high = high*2;
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target)
                high = mid -1;
            else
                low = mid + 1;

        }

        return -1;
    }
}
