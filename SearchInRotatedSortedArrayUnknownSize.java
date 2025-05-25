
class SearchInRotatedSortedArrayUnknownSize {
    private static int OUT_OF_BOUND = 2147483647;

    public int search(ArrayReader reader, int target) {

        int lo = 0;
        int hi = Integer.MAX_VALUE;

        while(lo <= hi){

            int mid =  (lo + hi) / 2;

            int midVal = reader.get(mid);

            if( midVal == target){
                return mid;
            }

            if(midVal == OUT_OF_BOUND || midVal > target ){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}