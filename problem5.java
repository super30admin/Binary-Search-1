// Time Complexity :o(n^2) for checking every row first element greater than target and creating array within for loop.
// Space Complexity :o(n) for array.
// Did this code successfully run on Leetcode :yes, ran successfully.
// Any problem you faced while coding this : yes, faced wrong in one test case but modified later.


// Your code here along with comments explaining your approach: basically for every row first element check target >=that element ,for all those rows make it as array and do binary search in loop.








class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int y=0;
        int [] a=new int[n];
        for(int i=0;i<m;i++){
            if(target>=matrix[i][0]){
                for(int j=0;j<n;j++){
                    a[j]=matrix[i][j];
                    
                }
                int l=0;
                int h=n-1;
                y=y+search(a,target,l,h);
                    
            }
        }
        if(y>=1){
            return true;
        }
    return false;
    }

   

     static int search(int[]a,int x,int l1, int h1){
                int middle1 = (int) ( l1+ Math.floor((h1-l1)/2));
                while(l1<=h1){
                    if(x==a[middle1]){
                        return 1;
            }
                    else if(x<a[middle1]){
                         h1=middle1-1;
                        return search(a,x,l1,h1);
                    }
                    else if(x>a[middle1]){
                     l1=middle1+1;
                     return search(a,x,l1,h1);
                }
                    
     }
   return 0;  }
}
    
    
                
     
    
                