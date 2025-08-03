//Time Complexity :O(log n)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : No ( Leetcode Premium Proplem)
//Any problem you faced while coding this : I was supposed to write the ArrayReader method to do this coding

package Samples;

//You would normally be given this interface.
interface ArrayReader {
 public int get(int index);
}

//This is your main solution class.
public class SearchInUnknownSizedArray {

 public int search(ArrayReader reader, int target) {
     int left = 0;
     int right = 1;

     // First, find the upper bound for binary search.
     while (reader.get(right) < target && reader.get(right) != Integer.MAX_VALUE) {
         left = right;
         right *= 2;
     }

     // Binary search within found range
     while (left <= right) {
         int mid = left + (right - left) / 2;
         int val = reader.get(mid);

         if (val == target) {
             return mid;
         } else if (val > target || val == Integer.MAX_VALUE) {
             right = mid - 1;
         } else {
             left = mid + 1;
         }
     }

     return -1; // Target not found
 }

 // Example stub for testing purposes
 public static void main(String[] args) {
     // Simulate the secret array and reader
     int[] secret = {-1, 0, 3, 5, 9, 12,19,23,29,37,41,43,47,51,55,58,66,69,71,89,93,99};
     int target = 41;

     ArrayReader reader = new ArrayReader() {
         @Override
         public int get(int index) {
             if (index >= secret.length) return Integer.MAX_VALUE;
             return secret[index];
         }
     };

     SearchInUnknownSizedArray sol = new SearchInUnknownSizedArray();
     int result = sol.search(reader, target);
     System.out.println("Output: " + result); 
 }
}

