class ArrayReader{
    private int k;
    public int get(int index){
        //function here to return value at passed index
        //not needed to implement here
       return k;
    }

}
class SearchInArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start + end)/2;
            if (reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

}