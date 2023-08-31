//Time complexity: O(log(m*n)) M=number of rows 
// N=no of columns -> Hypothetically converting 
//2D matrix to linear array
//Space : O(1)

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m=matrix.size();
        int n= matrix[0].size();
        int left=0, right=m*n-1;

       
        while(left<=right)
        {
                int mid=left+(right-left)/2;
                int row=mid/n, col=mid%n;
                int num=matrix[row][col];
            if(target==num)
            {
                return true;

            }
             if(target<num)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;

            }
        }
        return false;
    }
};