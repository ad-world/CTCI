import java.util.Arrays;

public class DynamicProgramming {
    // 8.1 Triple Step
    public int tripleStep(int numStep) {
        // for nth step, the num will be (n - 1) + (n - 2) + (n - 3)
        // we can memoize the solution like this
        int[] dp = new int[numStep + 1];
        Arrays.fill(dp, -1);
        return tripleStep(numStep, dp);
    }

    // 8.1 helper
    private int tripleStep(int numStep, int[] dp) {
        if(numStep < 0) return 0;
        if(numStep == 0 || numStep == 1) return 1;
        if(dp[numStep] > -1) {
            return dp[numStep];
        }

        dp[numStep] = tripleStep(numStep - 1, dp)
                + tripleStep(numStep - 2, dp)
                + tripleStep(numStep - 3, dp);
        return dp[numStep];
    }
}
