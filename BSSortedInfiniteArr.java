class BSSortedInfiniteArr  {
    public static void main(String args[]) {
        int[] arr = new int[]{1,3,5,7,9,10,12,15,17,19};
        System.out.print(findPosition(arr, 10)); // target = 10 here
    }

    public static int findPosition(int[] nums, int targetKey) {
        int low = 0, high = 1; // set low to 1st index and high to 2nd index since we do not know size of array
        int value = nums[0]; //1st value

        while (value < targetKey) {
            //store previous high
            low = high;
            
            //check if 2*high is less than array length to avoid array out of bound exception
            if ((2 * high) < nums.length - 1) {
                high = 2 * high;
            } else {
                high = nums.length - 1;
            }

            value = nums[high];
        }

        return binarySearch(nums, low, high, targetKey);
    }

    //binary search algorithm - basic
    public static int binarySearch(int[] nums, int low, int high, int target){
        int mid = (low + high)/2;

        if (low <= high) {
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return binarySearch(nums, low, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, high, target);
            }
        }

        return -1;
    }
}