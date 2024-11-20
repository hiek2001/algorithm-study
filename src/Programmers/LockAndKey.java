package Programmers;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.print(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int m = key.length;
        int n = lock.length;

        int len = n+(m-1)*2; // lock + (key-1)*2;
        int[][] map = new int[len][len];

        // 확장시킨 배열에 lock 표시
        for(int i=m-1 ; i<m+n-1 ; i++) {
            for(int j=m-1 ; j<m+n-1 ; j++) {
                map[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }

        // key가 lock에 맞는지 확인
        // 회전은 4번
        for(int i=0 ; i<4 ; i++) {
            if(check(map, key, n)) {
                return true;
            }
            rotate(key); // 시계 방향 90도 회전하면서 확인
        }
        return false;
    }

    public static boolean check(int[][] map, int[][] key, int lockLen) {
        int keyLen = key.length;
        int mapLen = map.length;

        for(int i=0 ; i<mapLen-keyLen+1 ; i++) {
            for(int j=0 ; j<mapLen-keyLen+1 ; j++) {

                // map에 key를 더하기
                for(int k=0 ; k<keyLen ; k++) {
                    for(int l=0 ; l<keyLen ; l++) {
                        map[i+k][j+l] += key[k][l];
                    }
                }

                // lock이 전부 1이 됐는지 확인
                boolean flag = true;
                for(int k=keyLen-1 ; k<keyLen+lockLen-1 ; k++) {
                    for(int l=keyLen-1 ; l<keyLen+lockLen-1 ; l++) {
                        if(map[k][l] != 1) { // 1이 아니면 홀이 안 맞는 것
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break; // ?
                }
                if(flag) return true; // 전부 1이면 true

                // key를 맞춰보기 위해 map에 값을 더했기 때문에
                // 원래 map 상태로 복구
                for(int k=0; k<keyLen; k++){
                    for(int l=0; l<keyLen; l++){
                        map[i+k][j+l] -= key[k][l];
                    }
                }
            }
        }
        return false;
    }

    public static void rotate(int[][] key) {
        int len = key.length;
        int[][] temp = new int[len][len];

        // 시계 방향으로 회전시킨 key 배열을 temp 배열에 저장
        for(int i=0 ; i<len ; i++) {
            for(int j=0 ; j<len ; j++) {
                temp[i][j] = key[j][len-i-1];
            }
        }

        // temp 배열을 key 배열에 다시 저장
        for(int i=0 ; i<len ; i++) {
            for(int j=0 ; j<len ; j++) {
                key[i][j] = temp[i][j];
            }
        }
    }
}

