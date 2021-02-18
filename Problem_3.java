
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(target > reader.get(high)){
            low = high;
            high *= 2;
        } 
        int mid= 0;
        while(low <= high){
            mid = low + (high - low)/2;

            if(reader.get(mid) == target)
                return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
            
        return -1;
    }
}
