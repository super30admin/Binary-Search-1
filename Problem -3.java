// Time Complexity : O(log T) , T is the index of the element
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes

class SolutionUnkownSize {
    public int search(ArrayReader reader, int target){
        int low =0;
        int high =1;

        // Finding the search bounds
        while(target > reader.get(high)){
            low = high;
            high = 2*high;
        }

        // Perform binary search within the identified bounds
        while(low<=high){
            int mid = low +(high-low)/2;

            // If target found return the index
            if(reader.get(mid) == target) return mid;

            // Check the hald , based on it is greater or lesser
            else if(reader.get(mid) < target){
                low = mid+1;
            }else
                high = mid -1;
            }
        }
        return -1;
    }
}