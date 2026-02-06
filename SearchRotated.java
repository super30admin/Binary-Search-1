class SearchRotated {
    public int search(int[] nums, int target) {
        int LEFT = 0, RIGHT = nums.length - 1, MID = (nums.length)/2;
        while (LEFT < RIGHT) {
            MID = (LEFT + RIGHT + 1) / 2;
            if ( nums[MID] == target) {
                return MID;
            }
            ///  check if the left side is the side that is sorted
            if (nums[LEFT] < nums[MID]) {
                if (nums[MID] > target && nums[LEFT] <= target) {
                    RIGHT = MID - 1;
                } else {
                    LEFT = MID;
                }
            } else {
                if (nums[RIGHT] >= target && nums[MID] < target) {
                    LEFT = MID;
                } else {
                    RIGHT = MID - 1;
                }
            }
        }
        return (LEFT < nums.length && nums[LEFT] == target) ? LEFT: -1;
    }
}