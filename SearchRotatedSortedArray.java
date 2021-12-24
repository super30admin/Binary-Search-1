class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int count = 0;
            boolean forward = nums[i] > 0 ? true : false;
            block: {
                while (nums[index] != 0) {
                    int steps = nums[index];
                    if (forward && steps < 0 || !forward && steps > 0) {
                        break block;
                    }
                    nums[index] = 0;
                    index = (index + steps + nums.length) % nums.length;
                    count++;
                }
                if (index == i && count > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}