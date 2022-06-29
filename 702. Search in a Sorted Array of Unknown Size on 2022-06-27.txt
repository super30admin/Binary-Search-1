class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(target > reader.get(high)){
            low = high;
            high = high * 2;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target < reader.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}