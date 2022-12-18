class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() { // sorting based on array elements
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        Stack<int[]> s = new Stack<int[]>();
        s.push(properties[0]);
        int count = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][0] < s.peek()[0] && properties[i][1] < s.peek()[1]) { // since s.peek() is greater array than properties[i] so we will increment the count
                count++;
            }
            else {
                s.push(properties[i]); // push the max array into the stack
            }
        }
        return count;
    }
}