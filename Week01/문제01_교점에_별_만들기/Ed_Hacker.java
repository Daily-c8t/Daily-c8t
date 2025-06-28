import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_1 {
    private static class Point{
        public final long x,y;
        //long으로 나타낸 이유는 별이 1000x1000이내에 찍힌다는 것으로
        //실제 좌표값이 작다는 의미가 아니기 때문이다.(오버플로우 방지)
        private Point(long x,long y){
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1,long c1, long a2, long b2 , long c2){
        //교점 구해서 반환하기
        double x = (double)(b1*c2-b2*c1) / (a1*b2-a2*b1); //Java의 타입 승격 규칙에 의해 double / long = double이 된다
        double y = (double)(a2*c1-a1*c2) / (a1*b2-a2*b1); //따라서 분자만 double로 만들어줘도 충분하다

        if( x % 1 != 0 || y % 1 != 0 )return null; //정수인지 확인

        return new Point((long) x, (long)y); //double 타입인데 파라미터 long으로 바꿔줘야한다
    }
    private Point getMinimumPoint (List <Point> points) {
        long x = Long.MAX_VALUE; // 9,223,372,036,854,775,807
        long y = Long.MAX_VALUE;  // 가능한 가장 큰 long 값


        for (Point p : points) {
            if (p.x < x) {
                x = p.x;
            }
            if (p.y < y) {
                y = p.y;
            }
        }//가장 작은 좌표 찾기
        return new Point(x, y);
    }

    private Point getMaximumPoint (List <Point> points) {
        long x = Long.MIN_VALUE; // -9,223,372,036,854,775,807
        long y = Long.MIN_VALUE; // 가능한 가장 작은 long 값
        //가장 큰 좌표 찾기

        for (Point p : points) {
            if (p.x > x) {
                x = p.x;
            }
            if (p.y > y) {
                y = p.y;
            }
        }
        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) { //j = i + 1을 하면 했던거 반복 안해도 됨
                Point intersection = intersection(line[i][0], line[i][1], line[i][2]
                        ,line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }//교점이 존재하면 points List에 넣는다
            }
        }


        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (p.y - minimum.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;


    }

}