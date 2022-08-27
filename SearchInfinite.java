public class SearchInfinite {
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high)>target){
            low = high;
            high *= 2;
        }
        while (low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
    }
}
