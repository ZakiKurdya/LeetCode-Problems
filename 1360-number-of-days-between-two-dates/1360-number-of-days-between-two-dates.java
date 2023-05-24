class Solution {
    private static int[] dayOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(dateToDays(date1) - dateToDays(date2));
    }
    
    private static int dateToDays(String date) {
        int days = 0;
        
        String[] str = date.split("-");
        
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);
        
        for (int y = 1971; y < year; y++)
            days += isLeap(y) ? 366 : 365;
        
        for (int m = 1; m < month; m++)
            days += dayOfMonths[m];
        
        days += Integer.parseInt(str[2]);
        
        if (month > 2 && isLeap(year))
            days++;
        
        return days;
    }
    
    private static boolean isLeap(int year) {
        return (
            ((year % 4 == 0) && (year % 100 != 0)) ||
            (year % 400 == 0)
        );
    }
}