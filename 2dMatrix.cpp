/*Time Complexity :O(log(mn))
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No

Your code here along with comments explaining your approach
We try to flatten the 2d matrix and then do the usual binary search.
But if we copy the elements to a new flattened array then it would take O(m*n)->Not useful.
So we use the row major formula to access a 2d matrix like a 1d matrix.
If we have to find mid element
Row -> mid/row_size;
Col -> mid%row_size;
*/




class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
//         int i;
//         for(i = 0; i < matrix.size();i++){

//             if(target < matrix[i][0])break;
//         }
//         cout << i;
        
//         if (i != 0 )return binarySearch(matrix[i-1],target);
//         else return binarySearch(matrix[i],target);
        int n = matrix.size();
        int m = matrix[0].size();
        int low = 0;
        int high = n*m -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int i = mid/m;
            int j = mid%m;
            if(matrix[i][j]==target)return true;
            else if (matrix[i][j]< target)low = mid+1;
            else high = mid -1;
            
        }
        return false;

    }
    
//     bool binarySearch(vector<int>row,int target){
//         int low = 0;
//         int high = row.size()-1;
//         while(low <= high){
//             int mid = low + (high-low)/2;
//             if(target == row[mid])return true;
//             if(target > row[mid])low = mid + 1;
//             else high = mid-1;
            
//         }
//         return false;
//     }
};