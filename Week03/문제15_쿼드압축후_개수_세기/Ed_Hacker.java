public class Solution {
    private static class Count {
        public final int zero;
        public final int one;
        //불변으로 만들어 주는 이유 생각해보기

        //A{0,0}  B{0,0} value object -> A = B? 값은 같긴해 ->
        //오픈소스기여 -> lombok 안 씀  //

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one); //메서드 체이닝?
        }       //불변성 고려해서 짯구나
    }

    private Count count(int offsetX, int offsetY, int size,
                        int[][] arr) {
        int h = size / 2;
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
}