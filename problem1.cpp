// Time Complexity : T(n) = O(logn)
// Space Complexity :S(n)=O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
public:

    bool searchMatrix(vector<vector<int>>& matrix, int target) 
    {
        //base case 
        if(matrix.size()==0) return false;
        int m=matrix.size();
        int n=matrix[0].size();
        int low=0;
        int high=m*n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int c=mid%n;
            int r=mid/n;
            if(matrix[r][c]==target)
            {
                return true;
            }
            else if(matrix[r][c]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return false;
    }
};
