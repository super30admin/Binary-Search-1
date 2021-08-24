package BinarySearch1;

public class Search2DMatrix {
//  determining the length
	 public boolean searchMatrix(int[][] matrix, int target) {
 int m= matrix.length;
 if(m==0) return false;
 int n=matrix[0].length;
 
 
//  applying binary search
 int left=0;
 int right=m*n-1;
 int middle=0,middlelement;
 while(left<=right){
     middle=left+(right-left)/2;
//      imp
     middlelement=matrix[middle/n][middle%n];
     if(target==middlelement) return true;
     else if(target>middlelement) left=middle+1;
     else if(target<middlelement) right=middle-1;
 }
 return false;
	 }
}
