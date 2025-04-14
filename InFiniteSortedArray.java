
import java.util.*;

class InfiniteSortedArray {

    public int Search(ArrayReader r, int target) {
        int start = 0;
        int end = 1;
        int mid;

        while (target > r.get(end) && r.get(end) < Integer.MAX_VALUE) {
            start = end;
            end = end * 2;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            if (r.get(mid) == target) {
                return mid;
            }
            if (r.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}