class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 1, row = triangle.length; i < row; i++ ) {
            for(int j = 0, col = triangle[i].length; j < col; j++) {
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j == i) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }

                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}