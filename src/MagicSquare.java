public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int point : array2d[0]){
            sum+=point;
        }
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        for (int row = 1; row< array2d.length;row++){
            int sumRow = 0;
            for (int column = 0; column < array2d[row].length;column++){
                sumRow += array2d[row][column];
            }
            if (sumRow!=checkSum){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        for (int column = 0; column < array2d[0].length;column++){
            int sumColumn = 0;
            for (int row = 0; row < array2d.length;row++){
                sumColumn += array2d[row][column];
            }
            if (sumColumn!=checkSum){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        //Upper left to bottom right
        int sumDiagonalOne = 0;
        for (int row = 0; row < array2d.length; row++){
            sumDiagonalOne += array2d[row][row];
        }
        //Upper right to bottom left
        int sumDiagonalTwo = 0;
        for (int row = 0; row < array2d.length;row++) {
            int column = array2d[row].length - row - 1;
            sumDiagonalTwo += array2d[row][column];
        }
        if (sumDiagonalOne==checkSum&&sumDiagonalTwo==checkSum)
            return true;
        return false;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int commonValue = calculateCheckSum(array2d);
        if (magicRows(array2d, commonValue) && magicColumns(array2d, commonValue) && magicDiagonals(array2d, commonValue)){
            return true;
        }
        return false;
    }

}
