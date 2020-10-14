class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int midValue = reader.get(mid);
            if(midValue == Integer.MAX_VALUE) {
                
                right = mid - 1;
            }
            if(midValue == target) {
                return mid;
            }
            if(midValue > target) {
                right = mid - 1;
            }
            if(midValue < target) {
                left =  mid + 1;
                right = right * 2;
            }
        }
        
        return -1;
    }
}