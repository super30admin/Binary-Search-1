/*complexity analysis:
Time: O(N*M)- where N is #rows and M is #Columns.
Space: O(1)- const auxilliary space

I will try to optimize the code.

*/
class Solution {
public boolean searchMatrix(int[][] matrix, int target) {
int m=matrix.length;
int n=matrix[0].length;
int i=0; int j=m*n-1;

while(i<=j){
    
    int mid=(i+j)/2;
    
if(matrix[mid/n][mid%n]==target) return true;
    
    else if(matrix[mid/n][mid%n]>target){
        j=mid-1;
    }
    else{
        i=mid+1;
    }

}

return false;
