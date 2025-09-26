use hr;
show tables;
-- 1.	Write a SQL query to find the number of employees hired in each year.
select year(hire_date), count(employee_id) from employees group by year(hire_date);

-- 2.	Write a SQL query to find the number of employees in each department.
select * from employees;
select department_id, count(employee_id) from employees group by department_id;

-- 3.	Write a SQL query to find the department with the highest total salary.
select department_id, sum(salary) from employees group by department_id order by sum(salary) desc limit 1;

-- 4.	Write a query to list the number of jobs available in the employees table.

Select sum(job_count) as total_job_count
from (
	select count(job_id) as job_count
	from hr.jobs
	group by job_id
) as grouped;

-- 5.	Write a query to get the total salaries payable to employees.
select sum(salary) from employees;

-- 6.	Write a query to get the minimum salary from the employees table.
select min(salary) from employees;

-- 7.	Write a query to get the maximum salary of an employee working as a Programmer. 
select * from employees;
select max(salary) from employees where job_id = "IT_PROG";

-- 8.	Write a query to get the average salary and number of employees working the department 90. 
select avg(salary), count(employee_id) from employees where department_id = 90;

-- 9.	Write a query to get the highest, lowest, sum, and average salary of all employees. 
select max(salary), min(salary), sum(salary), avg(salary) from employees;

-- 10.	Write a query to get the number of employees with the same job
select job_id, count(employee_id) from employees group by job_id;

-- 11.	Write a query to get the difference between the highest and lowest salaries. 
select max(salary), min(salary) , max(salary) - min(salary) as diff_salary from employees; 

-- 12.	Write a query to find the manager ID and the salary of the lowest-paid employee for that manager. 
select manager_id, min(salary) as min_sal from employees where manager_id is not null group by manager_id order by manager_id;

-- 13.	Write a query to get the department ID and the total salary payable in each department.
select department_id, sum(salary) from employees group by department_id;

-- 14.	Write a query to get the average salary for each job ID excluding programmer. 
select job_id, avg(salary) from employees where job_id <> "IT_PROG" group by job_id;

-- 15.	Write a query to get the total salary, maximum, minimum, average salary of employees (job ID wise), for department ID 90 only. 
select job_id, sum(salary), max(salary), min(salary), avg(salary) from employees where department_id = 90 group by job_id;

-- 16.	Write a query to get the job ID and maximum salary of the employees where maximum salary is greater than or equal to $4000.
select job_id, max(salary) from employees group by job_id having max(salary) > 4000;

-- 17.	Write a query to get the average salary for all departments employing more than 10 employees.
select department_id, avg(salary) from employees group by department_id having count(employee_id) > 10; 