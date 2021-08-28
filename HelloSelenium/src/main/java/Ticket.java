public class Ticket
{
    private String destination;
    private double price;
    private int startMonth;
    private int startDay;
    private int endMonth;
    private int endDay;


    Ticket() {}

    Ticket(String dest, double price, int month, int startDay, int endMonth, int endDay)
    {
        this.destination = dest;
        this.price = price;
        this.startMonth = month;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }


    @Override
    public String toString()
    {
        return "The cheapest flight we've found for you to  " + destination +
                "  is $" + price + "  from  " + startMonth +
                "/" + startDay + "/2019  to  " + endMonth +
                "/" + endDay + "/2019.";
    }


    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getStartMonth() {
        return startMonth;
    }
    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }
    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndMonth() {
        return endMonth;
    }
    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }
    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }


}
