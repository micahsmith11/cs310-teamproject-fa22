# cs310-teamproject-fa22
Introduction

  This Project is an assignment I did for Software Engineering 1 and the objective of this project was to make a Time and Attendance System that was intended for     
  internal use by a local manufacturing company. We were assigned to do this project in teams of 5 - 6 people and while implementing the Scrum workflow. The purpose 
  of this lab was to give us more experience with database programming, Scrum, GitHub, and working in software development teams.
  
Methodology
  
  The company wanted to implement its own time and attendance system because of issues with their last one. The system we had to make had to automatically compute the   employees’ total hours, in a way that is fair to the employees while remaining in accordance with company policy. 
  Some of the other desired features included:

  •	The ability for employees to clock in and clock out from multiple clock terminals, which will be stationed across the various departments and connected to a       
    central server.

  •	The ability to automatically adjust an employee’s punches either forward or backward in time, for the purpose of computing their adjusted accrued hours, according   to the policies described earlier.

  •	The ability to automatically compute the total hours accrued by the employee, within a single day and over an entire pay period.

  We were given the SQL database that contained the company’s shift times, department information, employee punches, employee badges, and schedule. We had to make   
  methods that could retrieve shift, department, employee, badge, punch records, create; list; and adjust employee punches, calculate the accrued total time, and 
  calculate absenteeism for an employee. We worked on this project using the Scrum workflow and we did this for 4 sprints. Each sprint had a 2-week duration except 
  sprint 4 which was a week.

  Our professor was the Product owner, and we were the software development team. Each sprint he would release features he wanted us to implement in system. We needed 
  to be able to connect to the database using Java and get the information from the SQL tables and format it to the conditions of the product owners liking. We also 
  had to make calculations with time so we used the java.time package.

Results	

  The results were a time and attendance system that could retrieve shift, department, employee, badge, punch records, create; list; and adjust employee punches, 
  calculate the accrued total time, and calculate absenteeism for an employee. The time and attendance system that we made could apply the policies for late arrivals 
  and early departures, and for early arrivals and late departures automatically which the past system couldn’t. 	Our system provided an easy way to view an 
  employee’s attendance history, including the employee’s overall rate of absenteeism over time. All employees no longer have to use a single time clock in which had 
  created traffic problems.

Conclusions

  I learned the Scrum framework, got good experience with database programming, and how to work on a software development team. We used GitHub the entire project, so 
  I got a lot of experience with using it. This project could be improved on by making some of the methods more efficient and making changes to the database.
