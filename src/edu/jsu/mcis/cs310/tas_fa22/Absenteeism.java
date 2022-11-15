
package edu.jsu.mcis.cs310.tas_fa22;
import java.time.LocalDate;

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
   
    public String ToString() {
        StringBuilder s = new StringBuilder();
        
        s.append('#').append(employee.getBadge()).append(' ');
        s.append("Pay Period Starting ").append(payPeriod).append("): ");
        s.append(percentage).append('%');
        
        return s.toString();
    }
}
