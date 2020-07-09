// Time Complexity :O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Problem1 {

    /**Search for target's index in the array */
    public int search(final int[] nums, final int target) {

        int start = 0;
        int end = nums.length - 1;

        // using iterative binary search
        while (start <= end) {

            // finding mid by avoid Integer Overflow error
            final int mid = start + (end - start) / 2;

            // target found
            if (nums[mid] == target)
                return mid;

            // check if 1st sub-sequence is increasing
            if (nums[start] <= nums[mid]) {

                // checking target in the 1st sequence
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                // else check in 2nd sequence
                else
                    start = mid + 1;

                // else 2nd is the increasing sub-sequence
            } else {

                // check in 2nd sequence
                if (target <= nums[end] && target > nums[mid])
                    start = mid + 1;

                // else check in 1st sequence
                else
                    end = mid - 1;
            }
        }

        // not found
        return -1;
    }

    /**
     * Main function
     * @param args
     */
    public static void main(final String[] args) {
        int [] input = {4,5,6,7,0,1,2};
        System.out.println("Array: " + input);
        int target = 0;
        System.out.println("-----------------------------------------");
        System.out.println("Target: "+target);
        System.out.println("Index of the target: "+target);
        System.out.println("-----------------------------------------");
        target = 3;
        System.out.println("Target: "+target);
        System.out.println("Index of the target: "+target);
    }
}