// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Length of array not given
//Constraint is give as 10 ^4
//How do we do binary search on array where length is not defined?
//First define the search limits
//take two first indexes, 0 and 1, as left and right boundaries. If the target value is not among these zeroth and the first element, then it's outside the boundaries, on the right.
//That means that the left boundary could moved to the right, and the right boundary should be extended. 
//To keep logarithmic time complexity, let's extend it twice as far: right = right * 2
//If the target now is less than the right element, we're done, the boundaries are set.
// If not, repeat these two steps till the boundaries are established

//Then do binary search

class BinarySearchInSortedArrayOfUnknowSize {
    public int search(ArrayReader reader, int target) {
        //Initializing low to first index(0) and high to second index (1)
        int low = 0, high = 1;
        while(reader.get(high) <= target)
        {
           low = high;
           high = high*2;
        }
        //doing binary search on the identified boundary
        return binarySearch(reader, target, low, high);
        
    }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        
    while(low <= high){
        int mid = low + (high-low)/2;
        
        if(reader.get(mid) == target)
            return mid;
        else if(reader.get(mid) > target)
            high = mid -1;
        else
            low= mid +1;
        
    }
        return -1;
        
    }
}

