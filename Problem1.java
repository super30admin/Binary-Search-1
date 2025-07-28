// Time Complexity :O(log(n*m))
// Space Complexity :O(1)
//We assume as a 1D array because of second property mentioned in the question 
// and apply binary search to find the target element.

import java.util.Scanner;
class Problem1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int target=sc.nextInt();
        boolean ans=searchMatrix(a,target);
        System.out.println(ans);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int r=mid/m;
            int c=mid%m;
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c]>target)
                h=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}