public class SecretArraySearch {
    public int search(ArrayReader reader, int target) {
        return search(reader, 0, Integer.MAX_VALUE, target);
    }

    private int search(ArrayReader reader, int l, int r, int target) {
        int left = l;
        int right = r;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid) < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }  
}
