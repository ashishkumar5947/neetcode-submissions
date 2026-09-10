class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String word : operations) {
            switch (word) {
                case "C" -> stack.pop();
                case "D" -> {
                    int num = stack.peek();
                    stack.push(num + num);
                }
                case "+" -> {
                    int prev1 = stack.pop();
                    int prev2 = stack.pop();
                    stack.push(prev2);
                    stack.push(prev1);
                    stack.push(prev1 + prev2);
                }
                default -> stack.push(Integer.valueOf(word));
            }
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }

        return sum;
    }
}