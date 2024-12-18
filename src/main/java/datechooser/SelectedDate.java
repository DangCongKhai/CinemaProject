package datechooser;

public class SelectedDate {

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        String day_text = String.valueOf(day);
        String month_text = String.valueOf(month);
        if (day < 10){
            day_text = "0" + day_text;
        }
        if (month < 10){
            month_text = "0" + month_text;
        }
        return day_text+"-"+month_text+"-"+year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SelectedDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SelectedDate() {
    }

    private int day;
    private int month;
    private int year;
}
