import java.util.*;
public class Lab_mst_code_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tokens[] = new int[n];
        for(int i = 0 ; i < n ; i++)tokens[i] = sc.nextInt();

        Arrays.sort(tokens);
        
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        int power = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } 
            else if (score > 0) {
                power += tokens[right];
                score--;
                right--;
            } 
            else {
                break;
            }
        }

        System.out.println(maxScore);
    }
}
