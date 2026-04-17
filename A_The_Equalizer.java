import java.io.*;
import java.util.*;

public class A_The_Equalizer {

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static void solve() {
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] arr = new int[n];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            sum += arr[i];
        }

        if( (sum % 2  != 0) || ( ((k*n) - 1) % 2 != 0 ) ){
            out.println("YES");
            return;
        }

        out.println("NO");
    }

    public static void main(String[] args) {
        int t = 1;
        t = fs.nextInt(); // uncomment if multiple test case
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}