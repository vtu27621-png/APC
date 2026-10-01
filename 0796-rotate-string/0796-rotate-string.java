public class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths don't match, goal cannot be a shift of s
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself and check if goal is a substring
        return (s + s).contains(goal);
    }
}