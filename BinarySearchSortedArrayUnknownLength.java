class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        while(reader.get(high)!=Integer.MAX_VALUE && reader.get(high)<=target){
            high = high*2;
            
        }
    return binarySearch(reader, target, 0, high);
    }
        private int binarySearch(ArrayReader reader, int target, int low, int high){
            while(low<=high){
               int mid = low+(high-low)/2;
                if(reader.get(mid) == target){
                    return mid;
                }
                else if(reader.get(mid)>target){
                    high = mid-1;
                }
                else 
                    low = mid+1;
            }
            return -1;
        }
        
}
