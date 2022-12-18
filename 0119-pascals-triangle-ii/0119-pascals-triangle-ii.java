class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascal.add(firstRow);

        for (int row = 1; row < rowIndex + 1; row++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 1; i < row; i++)
               temp.add(pascal.get(row - 1).get(i) + pascal.get(row - 1).get(i - 1));
            temp.add(1);
            pascal.add(temp);
        }

        return pascal.get(rowIndex);
    }
}