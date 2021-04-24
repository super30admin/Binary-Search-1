class Solution{
    public int search(ArrayReader reader, int target){
        int low =0; int high=1;
        while (target> reader.get(high)){
            low =high;
            high=high*2;
        }
        return BinarySearch(reader, high, low, target);
    }
    private int BinarySearch(ArrayReader reader, int high, int low, int target){
        while(low<=high){
            int mid =low+(high-low)/2;
            if (reader.get(mid) == target)return mid;
            else if (reader.get(mid) > target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return -1;
    }
}
