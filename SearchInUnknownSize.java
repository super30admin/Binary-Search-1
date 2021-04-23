// Time Complexity : O(logMN): N is the number of actual elements in the array and M is the extra elements we might search 
// through due to not being able to set the higher limit to the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
/** 
 * Struggled with the logic of how to find out the upper limit
*/


// Your code here along with comments explaining your approach
/** 
 * 1. Find the upper limit of the array. Which can be done by choosing 1 as the higher index to begin with, and then 
 * keep increasing higher index by 2 times. We could have choosen any number instead of 2, but that would be a tradeoff 
 * if the target actually lies in the last indexes that are out of bounds
 * 2. We will have a higher bound that is closer to the actual length-1 index. But it still might be pointing to an 
 * index that is out of bounds
 * 3. Perform binary search using the higher index calculated on above steps. 
*/
class SearchInUnknownSize {
    public int search(ArrayReader reader, int target) {
        int min=0;
        int max=1;
        
        while(target>reader.get(max))
        {
            min = max;
            max = max*2;
        }
        return binarySearch(reader, target, min, max);
    }
    private int binarySearch(ArrayReader reader, int target, int min, int max)
    {
            while(min<=max)
            {
                int mid=min+(max-min)/2;
                if(reader.get(mid)==target)
                    return mid;
                else if(reader.get(mid)>target)
                    max=mid-1;
                else
                    min=min+1;
            }
            return -1;
    }
}