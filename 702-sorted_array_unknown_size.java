
//O(logN) -> the go to algorithm is Binary search

//Overall Time Complexity: O(log(N) + log(K))
//K-> steps taken to find the BS interval
//N-> # of elements in that interval
//Overall Space Complexity: O(1)
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;

        int slow = 0;
        int fast = slow + 1;

        while(reader.get(fast) <= target){
            slow = fast;
            fast = fast * 2;
        }

        int res = binarySearch(reader, slow, fast, target);

        return res;
    }

    private int binarySearch(ArrayReader reader, int start, int end, int target){
        int mid;

        while(start <= end){
            mid = start + (end - start) / 2; //To avoid integer overflow
            if(reader.get(mid) == target) return mid;
            else if(target < reader.get(mid)) end = mid - 1;
            else start = mid + 1;
        }

        return -1;

    }
}