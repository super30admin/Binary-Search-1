class SearchArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = low * 2;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            } else if(target < reader.get(mid)){
                high = mid -1;
            } else {
                 low = mid + 1;
                high = low *2; 
            }
        }
        return -1;
    }
}