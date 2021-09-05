Time complexity: O(log(n))
Space complexity: O(1)

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = Integer.MAX_VALUE; //initialising start to 0 and end to max integer
        while (start + 1 < end) { 
            int mid = start + (end - start) / 2; //initialising mid
            if (target == reader.get(mid)) { //if target is equal to the current mid, then return mid
                return mid;
            } else if (target < reader.get(mid)) { //else if target is less than mid element, then move end to mid-1
                end = mid - 1;
            } else {
                start = mid + 1; //else move start to mid+1
            }
        }
        if (reader.get(start) == target) { //checking if start and end pointer values are equal to target, then return true
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        return -1; //else return -1
        
    }
}