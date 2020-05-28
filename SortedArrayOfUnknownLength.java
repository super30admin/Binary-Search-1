/*
* Time complexity - O(log(n))
* Space Complexity - O(1)
* Applied binary search method in expanding way in multiples of 2.
*/


class SortedArrayOfUnknownLength {
    public int search(ArrayReader reader, int target) {
        int low = 0; int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }
        return binarySearch(reader, target, low, high);
    }
    
     private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            } else if (reader.get(mid) > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
}
