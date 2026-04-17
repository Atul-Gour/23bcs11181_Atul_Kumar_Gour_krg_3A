import java.io.*;
import java.util.*;

public class B_Flip_the_Bit_Easy_Version {

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static void solve() {
        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = fs.nextInt();

        int p = fs.nextInt();
        int x = a[p];

        int L = 0, R = 0;

        int prev = 0;
        for (int i = n; i > p; i--) {
            int b = a[i] ^ x;
            if (b != prev) {
                R++;
                prev = b;
            }
        }

        prev = 0;
        for (int i = 1; i < p; i++) {
            int b = a[i] ^ x;
            if (b != prev) {
                L++;
                prev = b;
            }
        }

        int ans = Math.max(L, R);
        if ((ans & 1) == 1) ans++;

        out.println(ans);
    }

    public static void main(String[] args) {
        int t = fs.nextInt();
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