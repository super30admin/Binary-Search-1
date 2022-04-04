// Time Complexity                                  : O(N)
// Space Complexity                                 : O(2*N) = O(N)
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : using char and string with maps in c++. I tried using something like - 
//                                                    unordered_map<char,string> mp but the comparison threw me some weird error. 
//                                                    But finally used this solution and it worked.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    
    bool search(vector<vector<int>>& matrix,int row, int l, int r, int target) {
        
        while(l <= r) {
            int md = l + (r-l)/2;
            
            if(target == matrix[row][md]) return true;
            else if (target > matrix[row][md]){
                l = md + 1;
            } else {
                r = md - 1;
            }
        }
        
        return false;
    }
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int n = matrix.size();
        int m = matrix[0].size() - 1;
        
        if(n == 1) {
            return search(matrix,0,0,m,target);
        }
        
        
        
        int l = 0;
        int r = n-1;
        
        while(l <= r) {
            int md = l + (r-l)/2;
            // cout << l << "," << r << "," << md << "\n";
            
            if(matrix[md][0] == target) {
                return true;
            } else if (target > matrix[md][0]) {
                
                if(target <= matrix[md][m]) {
                    return search(matrix,md,0,m,target);
                }
                
                l = md+1;
            } else {
                r = md - 1;
            }
        }
        
        return false;
        
    }
};