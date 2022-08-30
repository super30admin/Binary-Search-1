
class Solution {
    // Time complexity is O(logn)
    // Space complexity is O(1)
    // This solution is not submitted on leetcode since I do not have leetcode premium
    
    public int search(int[] reader, int target) {
        int low = 0;
        int high = 1;
        while(reader[high] < target) {
            low = high;
            high = high*2;
        }
        // will get our low and high index now
        while(low<=high) {
            int mid = low + (high - low)/2;
            if (reader[mid] == target) return mid;
            if (reader[mid] > target) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}
// Driver code 
class Main { 
    public static void main(String args[]) 
    { 
        int[] reader = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        int target = 5;
        Solution s = new Solution();
        s.search(reader, target);
        System.out.println("Result: " + s.search(reader, target)); 
    } 
}
