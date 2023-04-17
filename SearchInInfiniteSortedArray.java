// Time Complexity :O(log(n))
// Space Complexity :O(1)

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (target > reader.get(high)) {
            low = high; 
            high = high * 2;
        }
        return binarySearch(reader, target, low, high);
       
}

private int binarySearch(ArrayReader reader, int target, int low, int high) {
    while (low <= high) {
        int mid = high - (high-low/2);
        if (reader.get(mid) == target) {
            return mid;
        }
        else if (reader.get(mid) < target) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }
    return -1;

}