package leetCode.array.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    private Direction findDirection(int[][] mark, int posX, int posY) {
        if (posX + 1 < mark.length && mark[posX + 1][posY] == 0) {
            return Direction.DOWN;
        }
        if (posY + 1 < mark[0].length && mark[posX][posY + 1] == 0) {
            return Direction.RIGHT;
        }
        if (posX - 1 >= 0 && mark[posX - 1][posY] == 0) {
            return Direction.UP;
        }
        if (posY - 1 >= 0 && mark[posX][posY - 1] == 0) {
            return Direction.LEFT;
        }
        return null;
    }

    private boolean isReachEnd(int posX, int posY, int[][] mark, Direction d) {
        switch (d) {
            case UP:
                if (posX - 1 < 0 || mark[posX - 1][posY] == 1) {
                    return true;
                }
                break;
            case DOWN:
                if (posX + 1 >= mark.length || mark[posX + 1][posY] == 1) {
                    return true;
                }
                break;
            case LEFT:
                if (posY - 1 < 0 || mark[posX][posY - 1] == 1) {
                    return true;
                }
                break;
            case RIGHT:
                if (posY + 1 >= mark[0].length || mark[posX][posY + 1] == 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    // 瞎写了个很蠢的方法...不删了hhhhhh
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        Direction d    = Direction.RIGHT;  // 初始方向向右
        int[][]   mark = new int[matrix.length][matrix[0].length];    // 标记走过的地方


        int posX = 0, posY = 0;

        while (true) {


            mark[posX][posY] = 1;
            res.add(matrix[posX][posY]);

            // 检测是否到了终点
            if (findDirection(mark, posX, posY) == null) {
                return res;
            }

            // 当走到一个方向的头时
            if (isReachEnd(posX, posY, mark, d)) {
                d = findDirection(mark, posX, posY);    // 换方向
            }

            switch (d) {
                case UP:
                    posX--;
                    break;
                case DOWN:
                    posX++;
                    break;
                case LEFT:
                    posY--;
                    break;
                case RIGHT:
                    posY++;
                    break;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int maxRow = matrix.length - 1;
        if (maxRow == -1) {
            return res;
        }
        int maxColumn = matrix[0].length - 1;

        int beginRow = 0, beginColumn = 0;

        while (true) {
            // 向右走
            for (int i = beginColumn; i <= maxColumn; i++) {
                res.add(matrix[beginRow][i]);
            }
            if (++beginRow > maxRow) {
                break;
            }

            // 向下走
            for (int i = beginRow; i <= maxRow; i++) {
                res.add(matrix[i][maxColumn]);
            }
            if (--maxColumn < beginColumn) {
                break;
            }

            // 向左走
            for (int i = maxColumn; i >= beginColumn; i--) {
                res.add(matrix[maxRow][i]);
            }
            if (--maxRow < beginRow) {
                break;
            }

            // 向上走
            for (int i = maxRow; i >= beginRow; i--) {
                res.add(matrix[i][beginColumn]);
            }
            if (++beginColumn > maxColumn) {
                break;
            }
        }
        return res;
    }
}


