class SearchUnknownSize{

    // log(N) time complexity
    public int search(ArrayReader reader, int target) {
        int first_val = reader.get(0);
        if(target< first_val){
            return -1;
        }
        int first = 0;
        int last = target - first_val; // at most these many values in the array for this to be possible
        //normal binary search
        while( first <= last){
            int mid = first+(last - first)/2;
            int value = reader.get(mid);
            
            if(target < value){
                last = mid-1;
            }
            else if(target > value){
                first = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}