
public class SearchInArrayOfUnknownSize {
    public static int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new ArrayReader(new int[] {1, 2, 3, 4, 5}), 8));
    }
}
