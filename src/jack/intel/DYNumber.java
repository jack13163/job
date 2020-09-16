package jack.intel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 计算岛屿的个数
 */
public class DYNumber {
    // 顶点数据结构
    static class Vertex {
        int value;
        int row;
        int col;
        boolean visited = false;
    }

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public static int solve(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        // 存储
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Vertex vertex = new Vertex();
                vertex.value = grid[i][j];
                vertex.row = i;// 记录行列值
                vertex.col = j;
                vertices.add(vertex);
            }
        }

        if(vertices.size() == 1 && vertices.get(0).value == 1){
            return 1;
        }

        // 遍历
        int rows = grid.length;
        int columns = vertices.size() / grid.length;
        int res = 0;
        Queue<Vertex> queue = new LinkedList<>();
        for (int i = 0; i < vertices.size(); i++) {
            // 初始化
            if (!vertices.get(i).visited && vertices.get(i).value == 1) {
                // 标记是否已经遍历过
                vertices.get(i).visited = true;
                queue.add(vertices.get(i));
                // 计算岛屿个数
                res++;
            } else {
                continue;
            }

            // 逐层遍历
            while (!queue.isEmpty()) {
                int row = queue.peek().row;
                int col = queue.peek().col;
                // 判断上一行的元素是否是海洋或者已经遍历过
                if (row > 0) {
                    int ind = (row - 1) * columns + col;
                    if (vertices.get(ind).value == 1 && !vertices.get(ind).visited) {
                        vertices.get(ind).visited = true;
                        queue.add(vertices.get(ind));
                    }
                }
                // 判断下一行的元素是否是海洋或者已经遍历过
                if (row < rows - 1) {
                    int ind = (row + 1) * columns + col;
                    if (vertices.get(ind).value == 1 && !vertices.get(ind).visited) {
                        vertices.get(ind).visited = true;
                        queue.add(vertices.get(ind));
                    }
                }
                // 判断左边的元素是否是海洋或者已经遍历过
                if (col > 0) {
                    int ind = row * columns + col - 1;
                    if (vertices.get(ind).value == 1 && !vertices.get(ind).visited) {
                        vertices.get(ind).visited = true;
                        queue.add(vertices.get(ind));
                    }
                }
                // 判断右边的元素是否是海洋或者已经遍历过
                if (col < columns - 1) {
                    int ind = row * columns + col + 1;
                    if (vertices.get(ind).value == 1 && !vertices.get(ind).visited) {
                        vertices.get(ind).visited = true;
                        queue.add(vertices.get(ind));
                    }
                }
                // 移除队首元素
                queue.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        char[][] a = new char[][]{{1, 1, 0, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 1}};
        char[][] a = new char[][]{{1}};
        System.out.println(solve(a));
    }
}