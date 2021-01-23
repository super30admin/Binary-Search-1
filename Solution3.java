// Search in a Sorted Array of Unknown Size
// S: O(1)
// T: O(logN)
class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        while(reader.get(high)!=Integer.MAX_VALUE){
            high = high *2;
        }

        return binarySearch(0, high, target,reader);
    }

    public int binarySearch(int low, int high,int target,ArrayReader reader){

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target==reader.get(mid)){
                return mid;
            }else if(target<reader.get(mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}