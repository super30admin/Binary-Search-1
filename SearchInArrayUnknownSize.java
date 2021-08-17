public class SearchInArrayUnknownSize<ArrayReader> {
    
    public int search(ArrayReader reader, int target) {

        int low =0;
        int high = Integer.MAX_VALUE;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(reader.get(mid)==target)
            {
                return mid;
            }
            else if(reader.get(mid)==Integer.MAX_VALUE || reader.get(mid)>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid +1;
            }

        }
        return -1;

    }
}
