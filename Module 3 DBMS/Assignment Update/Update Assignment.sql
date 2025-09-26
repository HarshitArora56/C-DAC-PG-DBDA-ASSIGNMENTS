create database assignment4;
use assignment4;


alter table employees drop constraint emp_email_uk;

-- 1. Write a SQL statement to change the email column of the employees table with 'not available' for all employees.
update employees set email = "not available";

-- 2. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for all employees.
show columns from employees;
update employees set commission_pct = 0.10;

-- 3. Write a SQL statement to change the email and commission_pct column of employees table with 'not available' and 0.10 for those employees whose department_id is 110.
update employees set email = "not available" , commission_pct = 0.10 where department_id = 110;

-- 4. Write a SQL statement to change the email column of employees table with 'not available' for those employees whose department_id is 80 and gets a commission_pct is less than .20
update employees set email = "NOT AVAILABLE" where department_id = 80 and commission_pct < 0.20;

-- 5. Write a SQL statement to change the email column of the employees table with 'not available' for those employees who belong to the 'Accounting' department.
update employees set email = "Not Available" where department = "Accounting";

-- 6. Write a SQL statement to change the salary of an employee to 8000 whose ID is 105, if the existing salary is less than 5000.
update employees set salary = 8000 where employee_id = 105 and salary < 5000;

-- 7. Write a SQL statement to change the job ID of the employee whose ID is 118, to SH_CLERK if the employee belongs to the department, whose ID is 30 and the existing job ID does not start with SH.
update employees set job_id = "SH_CLERK" where employee_id = 118 and department_id = 30 and job_id not like "%sh";

-- 8. Write a SQL statement to increase the salary of employees under the department 40, 90 and 110 according to the company rules that salary will be increased by 25% for department 40, 15% for department 90 and 10% for department 110 and the rest of the departments will remain the same.
update employees set salary = salary * 1.25 where department_id = 40;
update employees set salary = salary * 1.15 where department_id = 90;
update employees set salary = salary * 1.10 where department_id = 110;

-- 9. Write a SQL statement to increase the minimum and maximum salary of PU_CLERK by 2000 as well as the salary for those employees by 20% and commission percent by .10.

	
show columns from employees;
select * from employees;