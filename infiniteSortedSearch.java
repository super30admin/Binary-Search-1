public class infiniteSortedSearch {
    public int search(ArrayReader reader, int target){
        int lowerBound = 0;
        int upperBound = 1;
        while(reader.get(upperBound) < target){
            lowerBound = upperBound;
            upperBound = 2 * upperBound;
        }
        while (lowerBound <= upperBound){
            int mid = lowerBound + (upperBound - lowerBound)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                lowerBound = mid + 1;
            }
            else{
                upperBound = mid - 1;
            }
        }
        return -1;
    }
    
}
