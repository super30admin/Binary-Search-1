public class SearchInUnknownSizeSortedArray {
    public int searchInArray(int[] array, int target) {

        int high = 1;
        int low = 0;
        int mid=0;
        while (array[high] < target) {
            low = high;
            high = 2 * high;
        }
        while(low<=high){
            mid=low+(high-low)/2;
            if(array[mid]==target){
                return mid;
            } else if(array[mid]>target){
                high=mid-1;
            } else{
                low=mid+1;
            }
        }

        return -1;
    }
}
