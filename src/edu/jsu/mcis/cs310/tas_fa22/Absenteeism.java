
package edu.jsu.mcis.cs310.tas_fa22;
import java.time.LocalDate;

public class Absenteeism {
   private final Employee employee;
   private final LocalDate payPeriodStart;
   private final float percentage; 
   
   public Absenteeism (Employee employee, LocalDate payPeriodStart, Float percentage){
       this.employee = employee;
       this.payPeriodStart = payPeriodStart;
       this.percentage = percentage;
   }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getPayPeriodStart() {
        return payPeriodStart;
    }

    public float getPercentage() {
        return percentage;
    }
   
    public String ToString() {
        StringBuilder s = new StringBuilder();
        
        s.append('#').append(employee.getBadge()).append(' ');
        s.append("Pay Period Starting ").append(payPeriodStart).append("): ");
        s.append(percentage).append('%');
        
        return s.toString();
    }
}
