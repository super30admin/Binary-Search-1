// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

//Question: 33. Search in a Sorted Array of Unknown Size

//So since we don't know the size of input array but we know 1 <= secret.length <= 10 to the power 4 so we set high pointer to to 10 to the power 4 -1



class SearchInInfiniteSortedArray {
    /*
        * linear search two loops and search for element - TC O(m*n) Space O(1)
     */
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 9999;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return -1;
    }
}

