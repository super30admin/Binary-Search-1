//Time Complexity - O(log(n))
//Space Complexity - O(1) Not using any extra space.

// Implemented search in UnkownSize array using Binary search. Initially I have taken left=0 and right = 1 as size is unkown
// if the target is not in left and right I moved the right to right *2 and left to right then the low and high bound is founda nd performed binary search.
public class SearchInUnkownSize {

    public static class ArrayReader {
        private int[] secret;

        public ArrayReader(int[] arr) {
            this.secret = arr.clone();
        }

        public int get(int index) {
            if(index < 0 || index >= secret.length){
                return Integer.MAX_VALUE;
            }
            return secret[index];
        }
    }
    public static int search(ArrayReader reader, int target) {

        if(reader.get(0) == target) {
            return 0;

        }
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }
        while(left <= right) {
            int pivot = left + (right - left) /2;
            if(reader.get(pivot) == target) {
                return pivot;
            } else if(reader.get(pivot) > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;

    }
}
