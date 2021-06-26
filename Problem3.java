//Time Complexity: O(log N) ; Space Complexity : 0(1);
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high)<target){
            low = high+1;
            high = high*2;
        }
        return binarySearch(low,high,target,reader);
    }

    public int binarySearch(int low,int high,int target,ArrayReader reader){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target > reader.get(mid)) {
                low = mid+1;
            } else if(target < reader.get(mid)) {
                high = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}