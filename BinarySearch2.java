class BinarySearch2 {
    public static void main(String[] args) {

    }

    static int Search (int[] nums, int low, int high, int key) {
        int low =0;
        int high = 1;
        int mid;

        while (low <=high) {

            mid = low + high /2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }
        return -1;
    }

    //find the position of
    static int findPosition (int[] nums, int key) {
        int low =0;
        int high =1;

        int value = nums[0];
        //find high to do binary search
        while (value < key) {
            low = high;

            //length to prevent arrayOutofBoundException
            if (2*high < nums.length -1) {
                h = 2*high;
            }
            else {
                h = nums.length -1;
            }

            value = nums[high];
        }
        search(nums,low,high,key);
    }

}