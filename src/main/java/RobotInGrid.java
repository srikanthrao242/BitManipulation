import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGrid {
    public class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    ArrayList<Point> getPaths(int[][] maze, int row, int col){
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> visited = new HashSet<>();
        getPath(maze, row, col, path, visited);
        return path;
    }

    boolean getPath(int[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> visitedPoints){
        if(row < 0 || col < 0 || maze[row][col] == 0 ){
            return false;
        }
        Point p = new Point(row, col);
        if(visitedPoints.contains(p)){
            return false;
        }

        boolean isOrigin = (row == 0) && (col == 0);

        if(isOrigin || getPath(maze, row, col-1, path, visitedPoints) || getPath(maze, row-1, col, path, visitedPoints)){
            path.add(p);
            return true;
        }
        visitedPoints.add(p);
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{1,1,1}, {0,0,1}, {0,0,1}};
        RobotInGrid rg = new RobotInGrid();
        ArrayList<Point> res = rg.getPaths(maze, 2, 2);
        res.forEach(v -> System.out.println("(" + v.row+", "+ v.col+")"));
    }
}
