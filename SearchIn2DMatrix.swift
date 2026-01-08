//
//  SearchIn2DMatrix.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/1/26.
//

/*
 The rows are sorted and columns are also sorted.
 1 4 8 10 12
 14 16 22 25 29
 32 37 42 48 50
 52 60 62 71 80
 82 84 89 97 100
 12 < 14
 29 < 32
 80 < 82
 
 Search for a particular element
Bruteforce = O(mn)
solution 2 - Just check the range - first and last element and see if the element lies in this range. If it is present - do linear search on it to find the element. Complexity = O(m + n). m steps to check the range in worst case. n steps to search for an element
 Solution 3 - Check the last element - if the last element is greater than the element given. After finding the row, apply binary search on the identified row. Time compelxity - O(m + log n) -> m steps to identify the row and log n to find the element in the row using binary search.
 Solutio 4 - If we apply binary search on each column to find the element. The time complexity = O(n * log m) n - no of columns
 log m = to perform the bianry search on the column. m is elements in the row.
 
 Solution 5 (the best )- Apply binary search on rows. If we find the correct row where element lies, apply binary search on the row to find the element. Time complexity - O(log m) + O(log n)
 log(m * n) = log(m) + log(n)
 
 New technique - Consider this as a 1-D array. [We will just imagine it as a 1-D array. Creating it will take O(mn) time.]
 row = index / n
 column = index % n
 Binary search is performed on m*n elements. SO time compelxity - log(m * n)
 */

class SearchIn2DMatrix {
    
    init() {
        let isFound = search(in: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target: 40)
        print("index of the element i 2D matrix is \(isFound)")
    }
    
    func search(in matrix: [[Int]], target: Int) -> Bool {
        let m = matrix.count
        let n = matrix[0].count
        var low = 0
        var high = m * n - 1
        while (low <= high) {
            let mid = low + (high - low)/2
            if (matrix[mid/n][mid%n] == target) {
                return true
            } else if (matrix[mid/n][mid%n] < target) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return false
    }
}
