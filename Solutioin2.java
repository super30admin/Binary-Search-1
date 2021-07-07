class Solution {

    // here size of array is unknown so we will assume end at first index 
    //if the target is more then first index then multiply the index by 2 
    // to get more scope and as soon as its more then target then break the loop and assign starting point to the previous end node that is multiplied.
    // do the binary between start to end.
    // Time :  O(logn)  Space : O(1)
    public int search(ArrayReader reader, int target) {
        
        int end = 1; 

        while(reader.get(end) < target){
            end = end * 2;
        }
        int start = end/2;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if ( reader.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        
        
        return -1 ;
        
    }
}