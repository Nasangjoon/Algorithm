import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 1. 돗자리 크기를 오름차순 정렬 후, 뒤에서부터(큰 것부터) 확인
        Arrays.sort(mats);
        
        int rows = park.length;
        int cols = park[0].length;

        // 2. 가장 큰 돗자리부터 가능한지 체크
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            // 공원 전체를 순회하며 size 크기의 돗자리를 놓을 수 있는지 확인
            for (int r = 0; r <= rows - size; r++) {
                for (int c = 0; c <= cols - size; c++) {
                    if (canPlace(park, r, c, size)) {
                        return size; // 놓을 수 있다면 즉시 해당 크기 반환
                    }
                }
            }
        }

        // 3. 아무것도 깔 수 없는 경우
        return -1;
    }

    // 특정 위치(r, c)에서 시작하여 size 크기의 정사각형을 깔 수 있는지 확인하는 함수
    private boolean canPlace(String[][] park, int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 사람이 있으면("-1"이 아니면) 깔 수 없음
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}