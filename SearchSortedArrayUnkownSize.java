//Time Complexity: O(logn+logm)
//Space Complexity: O(1)

class SearchSortedUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 10;

        while(target > reader.get(high)){
            low = high+1;
            high = high*2;
        }

        while(low <= high){
            int mid = low+(high-low)/2;
            int middle = reader.get(mid);

            if(middle == target){
                return mid;
            }else if(target < middle){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}