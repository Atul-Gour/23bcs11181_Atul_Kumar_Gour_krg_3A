
import java.util.*;

public class Lab_mst_code_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++)nums[i] = sc.nextInt();

        int ans = 0;

        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums) {
                sum += num >> i & 1;
            }
            sum %= 3;
            ans |= sum << i;
        }

        System.out.println(ans);
    }
}
