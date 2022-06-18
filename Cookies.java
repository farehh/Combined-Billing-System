public class Cookies {
    private int previousMonth = -1;
    private int currentMonth = 0;
    private int previousYear = -1;
    private int currentYear = 0;

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public int getPreviousMonth() {
        return previousMonth;
    }

    public int getPreviousYear() {
        return previousYear;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void setPreviousMonth(int previousMonth) {
        this.previousMonth = previousMonth;
    }

    public void setPreviousYear(int previousyear) {
        this.previousYear = previousyear;
    }
}
