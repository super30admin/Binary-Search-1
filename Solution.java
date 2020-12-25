
//Time Complexity:O(log(m*n);
//Space Complexity: O(1)
//Did this code successfully run on Leetcode :yes
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if(m==0) {
			return false;
		}
		int left = 0;
		int right = m*n-1;
		while(left<=right) {
			int middleIndex = left + (right-left)/2;
			int middleElement = matrix[middleIndex/n][middleIndex%n];
			if(middleElement == target) {
				return true;
			}
			else if(target>middleElement) {
				right = middleIndex-1;
			}
			else if(target<middleElement){
				left = middleIndex+1;
			}
		}return false;
	}
}
