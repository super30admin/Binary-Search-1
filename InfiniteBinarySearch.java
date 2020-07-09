//Time Complexity: O(log n) + O(log n) ~= O(log n )
//Space Complexity: O(1)
//Difficulty:
  //
//Leetcode accepted: yes
//Algo description and code with comments:
  // try to get the first value greater than target.
  // assume it as end. do binary seacrh on reader.get(mid) > target.
  // if so move left of mid, other wise move right of mid.

class Solution {
    public int search(ArrayReader reader, int target) {
        //find first out of bound;
        int strt = 0;
        int end = 1;
        while(reader.get(end) <= target){
            end *= 10;
        }

        while(strt <= end){
            int mid = strt+(end-strt)/2;
            int val = reader.get(mid);
            if( val == target)
                return mid;

            if(val > target)
                end = mid -1;
            else
                strt = mid+1;
        }
        return -1;
    }
}
