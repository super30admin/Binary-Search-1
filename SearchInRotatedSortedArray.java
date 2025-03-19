class Solution {
    public boolean search(int[][] nums, int target) {
        int m = nums.length;
        int n = nums[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = low +(high - low)/2;
            if(nums[mid/n][mid%n] == target) //
                return true;
            else if(nums[mid/n][mid%n] < target){
                low = mid+1;
            }
            else
                high = mid -1;
        }
        return false;
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int[][] myMap = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 17;
        boolean result = solution.search(myMap, target);
        System.out.println(result);
    }
}