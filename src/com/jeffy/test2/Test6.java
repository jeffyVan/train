package com.jeffy.test2;
import java.awt.*;
import java.util.ArrayList;
public class Test6 {
    private static int X = 6;//列
    private static int Y = 6;//行
    private static int[][] chess = new int[Y][X];//棋盘
    private static boolean[] visited = new boolean[X * Y];//记录位置是否走过
    private static boolean finished = false;//是否遍历完棋盘
    private static int step=1;

    public static void main(String[] args) {
//        go(chess,1,1,1);
        long start = System.currentTimeMillis();
        go(chess,2,2);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        for (int[] row : chess) {
            for (int box : row) {
                System.out.print(box + "\t");
            }
            System.out.println();
        }
    }

    private static void go(int[][] chess, int row, int col) {
        chess[row][col] = step;//棋盘置步数值
        visited[row * X + col] = true;//设置走过标记
        //获取下一步可走的集合
        ArrayList<Point> points = nextSteps(new Point(col, row));
//        points.sort((o1, o2)-> nextSteps(o1).size()-nextSteps(o2).size());
        while (!points.isEmpty()) {
            Point p = points.remove(0);
            if (!visited[p.y * X + p.x]) {//没访问过
                ++step;
                go(chess, p.y, p.x);
            }
        }
        if (step < X * Y) {
            //重置
            --step;
            chess[row][col] = 0;
            visited[row * X + col] = false;
        }
    }
    /*private static void go(int[][] chess, int row, int col, int step) {
        chess[row][col] = step;//棋盘置步数值
        visited[row * X + col] = true;//设置走过标记
        //获取下一步可走的集合
        ArrayList<Point> points = nextSteps(new Point(col, row));
        points.sort((o1, o2)-> nextSteps(o1).size()-nextSteps(o2).size());
        while (!points.isEmpty()) {
            Point p = points.remove(0);
            if (!visited[p.y * X + p.x]) {//没访问过
                go(chess, p.y, p.x, ++step);
            }
        }
        if (step < X * Y && !finished) {
            //重置
            chess[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }*/

    //下一步可以走的位置
    private static ArrayList<Point> nextSteps(Point nowPoint) {
        ArrayList<Point> points = new ArrayList<>();
        int y, x;
        if ((y = nowPoint.y - 1) >= 0 && (x = nowPoint.x - 2) >= 0) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y - 2) >= 0 && (x = nowPoint.x - 1) >= 0) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y - 2) >= 0 && (x = nowPoint.x + 1) < X) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y - 1) >= 0 && (x = nowPoint.x + 2) < X) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y + 1) < Y && (x = nowPoint.x + 2) < X) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y + 2) < Y && (x = nowPoint.x + 1) < X) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y + 2) < Y && (x = nowPoint.x - 1) >= 0) {
            points.add(new Point(x, y));
        }
        if ((y = nowPoint.y + 1) < Y && (x = nowPoint.x - 2) >= 0) {
            points.add(new Point(x, y));
        }
        return points;
    }
}
