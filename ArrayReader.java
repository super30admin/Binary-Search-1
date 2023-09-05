public class ArrayReader {
    int[] nums;
    public ArrayReader(int[] nums) {
        this.nums = nums;
    }
    public int get(int index) {
        if(index >= nums.length) return Integer.MAX_VALUE;
        return nums[index];
    }
}
