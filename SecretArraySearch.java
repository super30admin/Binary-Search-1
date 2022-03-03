/**
 * O(log(n)) time complexity as it is binary search of the array followed by int max values
 * 
 * no additional space was allocated to perform the computation, so O(1)
 */
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
