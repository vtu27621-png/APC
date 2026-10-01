import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer
            // than the temperature at stack's top
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevDay = stack.pop();

                answer[prevDay] = i - prevDay;
            }

            // Store current day's index
            stack.push(i);
        }

        return answer;
    }
}