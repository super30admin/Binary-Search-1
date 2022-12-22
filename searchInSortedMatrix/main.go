package main

/*
   approach #1: brute force
   - flatten the matrix into 1d array
   - linear search left to right
   time: o(2mn)
   space: o(mn)


   approach #2: optimization of prev brute force
   - flatten the matrix into 1d array
   - binary search left to right
   time: o(mn) + o(logmn)
   space: o(mn)

   approach #3: brute force
   - linear search the entire matrix
   time: o(mn)
   space: o(1)

   approach #4: binary search each row
   - if target lies within a row,
       - then binary search that row
       - if not found, exit early
   - worse case target lies on the last row
   time: o(mnlogn)
   space: o(1)

   approach #5: 2 binary searches
   - binary search for a row
   - then binary search that row
   time: o(logm) + o(logn)
   space: o(1)

   approach #6: binary search entire matrix once
   - pretend like the entire matrix is a 1D array
   - search for target
   - we can get mid idx left(0) + (right(mn-1)-left(0))/2
   - we need to translate mid idx to row and col
       row = mid / n
       col = mid % m
   time: o(logmn)
   space: o(1)

   approach #7: stair case search
   - pick a corner ( top right || bottom left )
       - because these are the only 2 corners that we can make a valid decision from
       - to either go up/down left/right
   time: o(m+n)
   space: o(1)
*/
func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	n := len(matrix[0])
	left := 0
	right := m * n

	for left <= right {
		mid := left + (right-left)/2
		r := mid / n
		c := mid % n
		if r >= m || c >= n {
			return false
		}

		if matrix[r][c] == target {
			return true
		} else if matrix[r][c] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return false
}
