package other;

public class CalendarTime {

   private int hours;
   private int minutes;
   private boolean meridiem;

   //Requires: 0 <= hours <= 12, 0 <= minutes <= 60
   public CalendarTime(int hours,int minutes,boolean meridiem) {
       this.hours = hours;
       this.minutes = minutes;
       this.meridiem = meridiem;
   }

   //Getters:
    public int getHours() {
        return hours;
    }
    public int getMinutes() {
        return minutes;
    }

    //Effects: returns time in format: hour:min:am
    public String getTime() {
       return hours+":"+minutes+" "+getMeridiem(meridiem);
    }

    private String getMeridiem(boolean meridiem) {
       if (meridiem) {return "am";}
       else {return "pm";}
    }
}
