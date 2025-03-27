package _09_ExhausitiveSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PandaIsCute {
    static int N,M,K;
    static int[][] RC;

    static int unsatisfactory(int r, int c){
        int result = 0;
        for(int i = 0; i < K; i++ ){
            result += (r-RC[i][0])*(r-RC[i][0]) + (c-RC[i][1])*(c-RC[i][1]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받기
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        RC = new int[K][2];

        //R과 C입력
        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");
            RC[i][0] = Integer.parseInt(input[0]);
            RC[i][1] = Integer.parseInt(input[1]);
        }

        int ans =  Integer.MAX_VALUE;

        for(int r= 1; r <= N; r++){
            for(int c = 1; c <= M; c++){
                boolean existPanda = false;

                //현재 좌표 (r,c)에 판다가 있는지 확인 -> K개의 위치라면 판다가 있음.
                for(int i = 0; i < K; i++){ //입력한 K개의 위치 중에 있는지 확인.
                    if(r==RC[i][0] && c==RC[i][1]){
                        existPanda = true;
                        break;
                    }
                }

                //판다가 있으면
                if(existPanda){
                    continue;
                }

                ans = Math.min(ans,unsatisfactory(r, c));
            }
        }

        System.out.println(ans);
    }
}
