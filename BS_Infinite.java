/*
 * T.C: O(logn) where n:lenght of [].
 * S.C: O(1) no extra spaces used except the pointers.
 * 
 * Approach: I will initially try to find a range in which my target would be present by Doubling my jump on each iteration. 
 * Once i get the range i willl perform Binary Search on the received range to find the target. If not found, return -1; 
 */





/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader == null ) return -1;

        int slow = 0;
        int fast =1;

        while(reader.get(fast) <= target) {
            slow = fast;
            fast = fast *2;
            }

        slow -= 1;
        fast += 1;
        while(fast - slow > 1){
            int mid = (fast + slow)/2;

            if(reader.get(mid) < target) slow = mid;
            else fast = mid;
        }
        if(reader.get(fast) == target) return fast;
     return -1; 
    }
}