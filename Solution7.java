class Solution7 {
    public int search(ArrayReader reader, int target) {
        int left = 0, 
        right = 1;

        while(reader.get(right) < target){
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (reader.get(mid) == target) {
                return mid;
            } 

            if (reader.get(mid) < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            } 
        return -1;
    }
}
