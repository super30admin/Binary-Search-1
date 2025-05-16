package Problem3;
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Any problem you faced while coding this : no
public class SearchInSortedArrayofUnknownSize {

    static class  UniqueArray{
        private int[] arr;

        UniqueArray() {
            arr =  new int []  {-1, 0, 3, 5, 9, 12};
        }
        int get(int index) {
            if(index < arr.length) {
                return arr[index];
            }

            return  Integer.MAX_VALUE;
        }
    }
    static int searchIndex(UniqueArray reader , int target) {
        int low =  0;
        int high  = 1;

        while(reader.get(high) <  target) {
            if(reader.get(low)== target) return low;
            low = high;
            high *= 2;
        }

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(reader.get(mid) == target) return mid;

            if(target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int target = 9;
        UniqueArray reader = new UniqueArray();
        int index = searchIndex( reader, target);

        if( index == -1) {
            System.out.println(target + "not present in array");
        } else {
            System.out.println(target + " is present at "+ index );
        }
    }
}
