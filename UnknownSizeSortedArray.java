///**
// This is ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
// interface ArrayReader {
//public int get(int index) {}
//* }
//*/

class UnknownSizeSortedArray{
    private int BinarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low) /2;
            if(reader.get(mid) == target){
                return mid;
            }
            if(reader.get(mid) > target){
                return BinarySearch(reader,target,low, mid-1);
            }else{
                return BinarySearch(reader,target,mid+1, high);
            }
        }
        return -1;
    }
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2* high;
        }
        return BinarySearch(reader,target,low,high);
            
    }
}