class Diamond {
    public static String print(int n) {
        if(n%2 == 0 || n < 1) return null;
        StringBuilder star = new StringBuilder();
        for(int i =0;i<n;i++) {

            if(i <= n/2) {
                for(int a = 0;a < n/2 - i;a++) {
                    star.append(" ");
                }
                for(int b = 0; b<i*2+1;b++) {
                    star.append("*");
                }
            } else {
                for(int a = 0;a < i - n/2;a++) {
                    star.append(" ");
                }
                for(int b = 0; b<(n-i-1)*2+1;b++) {
                    star.append("*");
                }
            }
            star.append("\n");
        }
        return star.toString();
    }
}