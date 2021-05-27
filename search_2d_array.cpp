// Time Complexity : O(logm) + O(logn) - For mxn array
// Space Complexity :  O(m*n) - In Place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

// P.S. Will follow up with a better edited and styled code

class Solution {
public:
    
    int binSearchCol(vector<vector<int>>& matrix, int l, int r, int target)
    {
        int m = floor((l + r) / 2);
        
        if(l == m) //Exit Condition
        {
            if(target < matrix[r][0])
            {
                return l;
            }
            else
            {
                return r;
            }
        }
        
        if(matrix[m][0] == target)
        {
            return m;
        }
        else if(target < matrix[m][0])
        {
            return binSearchCol(matrix, l, m, target);
        }
        else
        {
            return binSearchCol(matrix, m, r, target);// testing m+1
        }
    }
    
    int binSearchRow(vector<vector<int>>& matrix, int idx, int l, int r, int target)
    {
        if(l == r)
        {
            if(target == matrix[idx][l])
            {
                return l;
            }
            else
            {
                return -1;
            }
            
        }
        
        int m = floor((l+r)/2);
        
        if(matrix[idx][m] == target)
        {
            cout << 1;
            return m;
        }
        else if(target < matrix[idx][m])
        {
            /*if(l == m)
            {
                return -1;
            }
            else*/
            {
                cout << 2;
                return binSearchRow(matrix, idx, l, m, target);
            }            
        }
        else
        {
            /*if(m+1 == r)
            {
                return -1;
            }
            else*/
            {
                cout << 3;
                return binSearchRow(matrix, idx, m+1, r, target);// testing m+1
            }
        }
        
        return -1;
    }
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int rowIdx;
        int colIdx;
        
        if(0 == matrix.size()-1)
        {
            rowIdx = 0;
        }
        else
        {
            rowIdx = binSearchCol(matrix, 0, matrix.size()-1, target);
        }
        
        cout << "Row  " << rowIdx << endl;
        
        if(0 == matrix[rowIdx].size()-1)
        {
            if(matrix[rowIdx][0] == target)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            colIdx = binSearchRow(matrix, rowIdx, 0, matrix[rowIdx].size()-1, target);
        }
        
        cout << "Column  " << colIdx << endl;
        
        if(colIdx == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
        
        return true;
    }
};