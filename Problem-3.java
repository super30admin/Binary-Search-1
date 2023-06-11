Class Solution{
    //Time Complexity:-O(logn).
    //Space Complexity:-O(1);
    public int search(ArrayReader reader,int target){
        int low=0;int high=10001;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid)==target){
                return mid;
            }
            else if(reader.get(mid)<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}