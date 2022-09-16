#time complexity O(log n)
#space complexity O(1)
class SearchInUnknownSizeArray {
    public int search(ArrayReader reader, int target) {

        if(reader.get(0) == Integer.MAX_VALUE){
            return -1;
        }

        int low = 0;
        int high = 1;

        
        while(reader.get(high) < target)
        {
            low = high;
            high = high * 2;
        }

        
        while(low <= high){

            int mid = low + (high-low)/2;

            if(reader.get(mid) == target){
                return mid;
            }

            if(reader.get(mid) > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }
}