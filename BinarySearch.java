//Search an array in an sorted unknown size. You can only access the array using an ArrayReader interface, where ArrayReader.get(i) returns the element of the array at index i  (0-indexed).
/*
time complexity: O(log m + log n) where m is the index of the target and n is the size of the array 
space complexity: O(1)
 */

//Did not run in leetcode as it is required premium subscription to run the code. Ran successfully in local IDE.
//so far no challenges faced

class BinarySearch {

    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2* high;
        }
        while(low <= high){
            int mid = low + (high - low)/2; //calculating mid like this to avoid integer overflow error.
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;
    }
    
}
