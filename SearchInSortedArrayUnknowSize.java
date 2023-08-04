class SearchInSortedArrayUnknowSize{
// TC : log(n)
// SC : (1)
//// Did this code successfully run on Leetcode : yes
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){ // Here we are defining the window size.
            low = high;
            high = high * 2;
        }
        while (low<=high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(low) < target && target < reader.get(mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return -1;
    }
}