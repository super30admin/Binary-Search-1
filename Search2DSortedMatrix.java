//Time Complexity - O(logN)
//Space Complexity - O(1)

class Search2DSortedMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {

      int rows = matrix.length;
      int cols = matrix[0].length;

      int left = 0;
      int right = rows * cols - 1;

      while(left <= right){
          int mid = (left + right)/2;

          int middleElement = matrix[mid / cols][mid % cols];

          if(middleElement == target)
              return true;
          else if(middleElement < target)
              left = mid + 1;
          else
              right = mid - 1;
      }
      return false;
  }
}
