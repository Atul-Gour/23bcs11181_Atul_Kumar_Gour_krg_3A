import java.io.*;
import java.util.*;

public class D_Flip_the_Bit_Hard_Version {

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static void solve() {
        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = fs.nextInt();

        int[] p = new int[k];
        for (int i = 0; i < k; i++) p[i] = fs.nextInt();

        int x = a[p[0]];

        int ans = 0;

        int start = 1;

        for (int i = 0; i < k; i++) {
            int end = p[i];

            int prev = 0;
            for (int j = start; j <= end; j++) {
                int b = a[j] ^ x;
                if (b != prev) {
                    ans++;
                    prev = b;
                }
            }

            start = p[i];
        }

        int prev = 0;
        for (int j = start; j <= n; j++) {
            int b = a[j] ^ x;
            if (b != prev) {
                ans++;
                prev = b;
            }
        }

        out.println(ans);
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