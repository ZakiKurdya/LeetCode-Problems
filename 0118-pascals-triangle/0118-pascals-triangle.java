class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int row = 1; row < numRows; row++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 1; i < row; i++)
               temp.add(result.get(row - 1).get(i) + result.get(row - 1).get(i - 1));
            temp.add(1);
            result.add(temp);
        }

        return result;
    }
}