# mod is column number
# div is row number
# calculate position in the matrix from the mid and continue with binary search

def find_row_col(mid, rows, cols) -> ():
    print(mid)
    row = int(mid // cols)
    col = int(mid % cols)
    return (row, col)

def binary_search(matrix, left, right, target, rows, cols) -> []:
    while (left < right):
        mid = int(left + (right -left)/2)
        row, col = find_row_col(mid, rows, cols)
        if matrix[row][col] == target:
            return [row, col]
        
        if matrix[row][col] > target:
            return binary_search(matrix, left, mid, target,rows, cols)
        else:
            return binary_search(matrix, mid+1, right, target, rows, cols)
    row, col = find_row_col(left, rows, cols)
    if matrix[row][col] == target:
        return [row, col]
    return -1

if __name__ == "__main__":
    matrix = [[1,3], [4, 5]]
    rows = len(matrix)
    cols = len(matrix[0])
    size_of_matrix = rows * cols
    print(size_of_matrix)
    print(binary_search(matrix, 0, size_of_matrix-1, 3, rows, cols))
