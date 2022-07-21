class Solution {
    public int search(ArrayReader reader, int target) {
        int startIndex = 0,endIndex = Integer.MAX_VALUE;
        while(startIndex<=endIndex){
            int mid = startIndex + (endIndex-startIndex)/2;
            if(reader.get(mid)==target)
                return mid;
            if(reader.get(mid) > target)
                endIndex = mid-1;
            else
                startIndex = mid + 1;

        }
        return -1;
    }
}
