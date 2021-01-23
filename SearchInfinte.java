// Time complexity - O(log n)
// works on leetcode

class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        int low = 0;
        while(reader.get(high) != Integer.MAX_VALUE && reader.get(high) <= target){
            low = high;
            high = high * 2;
        }
        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <=high ){
            int mid = low + (high - low) / 2;

            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    }
}
