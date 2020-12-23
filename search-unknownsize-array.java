class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while(left <= right){
            if(reader.get(right) < target){
                left = right;
                right *= 2;
            }
            int mid = (right - left) / 2 + left;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) < target)
                left =  mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
