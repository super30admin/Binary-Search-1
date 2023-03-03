// Time Complexity : O(log n + logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public boolean searchMatrix(int[][] m, int t) {
       int l=0,h= m.length-1, mid=0;
        while(l<=h){
            mid=(l+h)/2;
            if(m[mid][0]==t)return true;
            if(m[mid][0]<t) l=mid+1;
            else h=mid-1;   
        }
        if(h<0)return false;
        mid=h;
          l=0;h= m[0].length-1;int m1=0;
        while(l<=h){
            m1=(l+h)/2;
            if(m[mid][m1]==t)return true;
            if(m[mid][m1]<t) l=m1+1;
            else h=m1-1;   
        }
        return false;
    }
}