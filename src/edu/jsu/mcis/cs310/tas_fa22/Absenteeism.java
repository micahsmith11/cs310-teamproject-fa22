
package edu.jsu.mcis.cs310.tas_fa22;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

public class Absenteeism {
   private final Employee employee;
   private final LocalDate payPeriod;
   private final double percentage; 
   
   public Absenteeism (Employee employee, LocalDate payPeriod, double percentage){
       this.employee = employee;
       this.payPeriod = payPeriod;
       this.percentage = percentage;
   }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getPayPeriod() {
        return payPeriod;
    }

    public double getPercentage() {
        return percentage;
    }
   
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DecimalFormat df = new DecimalFormat("0.00");
        
        s.append('#').append(employee.getBadge().getId()).append(' ');
        s.append("(Pay Period Starting ").append(payPeriod.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).format(formatter)).append("): ");
        s.append(df.format((percentage))).append('%');
        
        return s.toString();
    }
}
