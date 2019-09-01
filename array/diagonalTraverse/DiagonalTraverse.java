package leetCode.array.diagonalTraverse;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] res = new DiagonalTraverse().findDiagonalOrder(test);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int posX = 0, posY = 0;
        int maxRow = matrix.length - 1;
        int maxColumn = matrix[0].length - 1;
        int elementNum = (maxRow + 1) * (maxColumn + 1);
        int[] res = new int[elementNum];
        int i = 0;
        boolean direction = true;   // true represent up.

        while (i < elementNum) {
            res[i] = matrix[posX][posY];

            // check if reach diagonal end
            if (direction) {
                if (posX == 0 || posY == maxColumn) {
                    if (posY < maxColumn) {
                        posY += 1;
                    } else {
                        posX += 1;
                    }
                    direction = false;
                } else {
                    posX -= 1;
                    posY += 1;
                }
            } else {
                if (posY == 0 || posX == maxRow) {
                    if (posX < maxRow) {
                        posX += 1;
                    } else {
                        posY += 1;
                    }
                    direction = true;
                } else {
                    posX += 1;
                    posY -= 1;
                }
            }

            i++;
        }

        return res;
    }
}
