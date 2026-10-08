class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int input : asteroids) {
            boolean exploded = false;
            while (!s.isEmpty() && s.peek() > 0 && input < 0) {
                int top = s.peek();

                if (top < -input) {
                    s.pop();
                } 
                else if (top == -input) {
                    s.pop();
                    exploded = true;
                    break;
                } 
                else {
                    exploded = true;
                    break;
                }
            }
            if (!exploded) {
                s.push(input);
            }
        }
        int[] result = new int[s.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }
        return result;
    }
}
