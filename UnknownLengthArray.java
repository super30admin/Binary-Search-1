public class UnknownLengthArray {
    private int[] arr;
    public UnknownLengthArray( int[] arr) {
        this.arr = arr;
    }

    public int Search(int target) {
        int high = this.arr.length - 1;
        int low = 0;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(this.arr[mid] == target) {
                return mid;
            } else if (this.arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,7,8};
        int target = 6;
        UnknownLengthArray unknownLengthArray = new UnknownLengthArray(arr);
        System.out.println(unknownLengthArray.Search(target));

    }
}
