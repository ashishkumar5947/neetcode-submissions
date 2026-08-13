
// class NumMatrix {
//     int[][] matrix;
//     public NumMatrix(int[][] matrix) {
//         this.matrix = matrix;
//     }

//     public int sumRegion(int row1, int col1, int row2, int col2) {
//         int sum = 0;

//         for (int i = row1; i <= row2; i++) {
//             for (int j = col1; j <= col2; j++) {
//                 sum += matrix[i][j];
//             }
//         }

//         return sum;
//     }
// }

// OPTIMAL
class NumMatrix {
    private final int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        prefix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int above = (i > 0) ? prefix[i - 1][j] : 0;
                int left = (j > 0) ? prefix[i][j - 1] : 0;
                int corner = (i > 0 && j > 0) ? prefix[i - 1][j - 1] : 0;

                prefix[i][j] = matrix[i][j] + above + left - corner;
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        int total = prefix[r2][c2];
        int above = (r1 > 0) ? prefix[r1 - 1][c2] : 0;
        int left = (c1 > 0) ? prefix[r2][c1 - 1] : 0;
        int corner = (r1 > 0 && c1 > 0) ? prefix[r1 - 1][c1 - 1] : 0;

        return total - above - left + corner;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */