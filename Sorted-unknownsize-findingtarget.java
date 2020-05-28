class Solution{
    public int search(ArrayReader reader, int target){
        int low=0;
        int high=1;
        while(reader.get(high)<target){
            low=high;
            high=high*3;
        }
        return binarySearch(reader, target, low, high);
    }

    public int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            } else if(target>reader.get(mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}