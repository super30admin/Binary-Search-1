class Solution{
    public int search(ArrayReader reader, int target){
        int hi=1;
        while(reader.get(hi)<target){
            hi = hi <<1;
        }
        int low = hi >>1;
        while(low<=hi){
            int mid=(low+high)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            if(reader.get(mid)<target){
                low=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return -1;
    }
}