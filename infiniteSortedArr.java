import javax.lang.model.util.ElementScanner6;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : None.

// Binary Search solution
class infiniteSortedArr {

    public int search(ArrayReader reader, int target) {
        //Using slow and fast pointers

        int slow, fast;
        slow = 0;
        fast = 1;

        while(reader.get(fast) < target) {
            // Moving right till the target val is passed with fast
            slow = fast;
            fast = fast * 2;
        }
        
        // Perform binary search
        while (fast >= slow) {
            int mid; // middle element

            mid = slow + (fast - slow) / 2;
            if(reader.get(mid) == target) return mid;
            // move left if the target is smaller than mid
            else if (reader.get(mid) > target) {
                mid = fast - 1;
            }
            // move right if the target is greater than mid
            else 
                mid = slow + 1;
        }

        return -1; // not found

    }

}