
// Time Complexity : O log(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Find the range which justifies target or where 
 * your array starts to be out of bound
 * Perform Binary search on found range
 */

public class SearchSortedArrayUnknownSize {
	/**
	 * // This is ArrayReader's API interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface ArrayReader {
	 *     public int get(int index) {}
	 * }
	 */
	

	class Solution {
	    public int search(ArrayReader reader, int target) {
	        int start =0;
	        int end = 1;
	        int mid;
	        
	        //find my target range
	        while(reader.get(end) != Integer.MAX_VALUE && 
	              reader.get(end) <= target){
	            start = end;
	            end = end * 2;
	        }
	        
	        //perform BS on found range
	        while(start<=end){
	            mid = start + (end-start)/2;
	            
	            if(reader.get(mid) == target) return mid;
	            
	            if(reader.get(mid) > target){
	                end = mid-1;
	            }else {
	                start = mid+1;
	            }
	        }
	      return -1;  
	    }
	}
}
