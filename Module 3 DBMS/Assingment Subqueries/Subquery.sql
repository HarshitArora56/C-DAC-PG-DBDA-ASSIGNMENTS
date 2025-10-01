use hr;
-- 1. Write a query to find the name (first_name, last_name) and the salary of the employees who have a higher salary than the employee whose last_name='Bull'. 
select concat(first_name, " ",last_name) as emp_name, salary 
from employees
where salary > (Select salary from employees where last_name = 'Bull') order by salary;

-- 2. Write a query to find the name (first_name, last_name) of all employees who works in the IT department.

select * from departments;
select concat(first_name, " ",last_name) as emp_name, department_id 
from employees
where department_id in(Select department_id from departments where department_name like '%IT%');

select concat(first_name, " ",last_name) as emp_name, department_id 
from employees
where job_id in(Select job_id from employees where job_id like '%IT%');

-- 3. Write a query to find the name (first_name, last_name) of the employees who have a manager and worked in a USA based department. 
-- Hint : Write single-row and multiple-row subqueries

select * from departments;
select * from countries;
select * from locations;

Select concat(first_name, ' ', last_name) as emp_name from employees where manager_id is not null and department_id in(
select d.department_id 
from departments d
join locations l on d.location_id = l.location_id
join countries c on l.country_id = c.country_id
where c.country_id = 'US');

-- 4. Write a query to find the name (first_name, last_name) of the employees who are managers.
 
select concat(first_name,' ',last_name) as emp_name 
from employees where employee_id in(
	select e.employee_id 
    from departments d
    join employees e on d.manager_id = e.employee_id
);

-- 5. Write a query to find the name (first_name, last_name), and salary of the employees whose salary is greater than the average salary. 
select concat(first_name,' ', last_name) as emp_name, salary from employees 
where salary > (select avg(salary) from employees) order by salary;

-- 6. Write a query to find the name (first_name, last_name), and salary of the employees whose salary is equal to the minimum salary for their job grade. 

select concat(first_name, ' ', last_name) as emp_name, salary, job_id 
from employees e
where salary = (
select min_salary 
from jobs j 
where e.job_id = j.job_id
);

-- 7. Write a query to find the name (first_name, last_name), and salary of the employees who earns more than the average salary and works in any of the IT departments. 

select concat(first_name,' ', last_name) as emp_name , salary
from employees 
where salary > (select avg(salary) from employees where job_id like '%IT%') and job_id like '%IT%' order by salary;

-- 8. Write a query to find the name (first_name, last_name), and salary of the employees who earns more than the earning of Mr. Bell.
select concat(first_name,' ',last_name) as emp_name, salary 
from employees 
where salary > (select salary from employees where last_name = 'Bell');

-- doubt
-- 9. Write a query to find the name (first_name, last_name), and salary of the employees who earn the same salary as the minimum salary for all departments. 

select concat(first_name,' ',last_name) as emp_name, salary 
from employees 
where salary = (select min(min_salary) from jobs);

-- 10. Write a query to find the name (first_name, last_name), and salary of the employees whose salary is greater than the average salary of all departments.
select concat(e.first_name, ' ' , e.last_name) as emp_name, e.salary,d.department_name 
from employees e 
join departments d on e.department_id = d.department_id 
where e.salary > (
    select avg(e2.salary)
    from employees e2
    join departments d2 ON e2.department_id = d2.department_id
);

-- 11. Write a query to find the name (first_name, last_name) and salary of the employees who earn a salary that is higher than the salary of 
-- all the Shipping Clerk (JOB_ID = 'SH_CLERK'). Sort the results of the salary of the lowest to highest. 

select concat(first_name,' ',last_name) as emp_name, salary 
from employees 
where salary > 
all(select salary 
from employees 
where job_id = "SH_CLERK"
) 
order by salary asc;

-- 12. Write a query to find the name (first_name, last_name) of the employees who are not supervisors. 

select concat(first_name,' ',last_name) as emp_name 
from employees 
where employee_id not in(Select distinct manager_id from employees where manager_id is not null);

-- 13. Write a query to display the employee ID, first name, last name, and department names of all employees. 

select employee_id, concat(first_name,' ', last_name) as emp_name, (select department_name from departments where department_id = e.department_id) as dept_name from employees e;

-- 14. Write a query to display the employee ID, first name, last name, salary of all employees whose salary is above average for their departments.

select employee_id, first_name, last_name, salary from employees e where e.salary > (select avg(salary) from employees where department_id = e.department_id);

-- 15. Write a query to fetch even numbered records from the employees table. 

select * from employees;
select * from employees where employee_id in(select employee_id from employees where mod(employee_id,2) = 0);

-- 16. Write a query to find the 5th maximum salary in the employees table. 

select distinct salary as fifth_max_salary from employees where salary = (select distinct salary from employees order by salary desc limit 1 offset 4);

-- 17. Write a query to find the 4th minimum salary in the employees table. 

select distinct salary as fourth_min_salary from employees where salary = (select distinct salary from employees order by salary asc limit 1 offset 3);

-- 18. Write a query to select the last 10 records from a table. 
-- doubt
-- select * from employees where employee_id  in(select employee_id from employees order by employee_id desc limit 10);

-- 19. Write a query to list the department ID and name of all the departments where no employee is working. 

select * from departments;
select department_id, department_name from departments where department_id not in (select department_id from employees where department_id is not null); 

-- 20. Write a query to get 3 maximum salaries. 

select distinct salary from employees where salary > (select distinct salary from employees order by salary desc limit 1 offset 3);

-- 21. Write a query to get 3 minimum salaries. 

select distinct salary from employees where salary < (select distinct salary from employees order by salary asc limit 1 offset 3);

-- 22. Write a query to get nth max salaries of employees. 
select salary as nt_max_salary from employees where salary = (select distinct salary from employees order by salary desc limit 1 offset n - 1);

-- Write a query that returns all employees who have a salary greater than the average salary of their department.
select employee_id, concat(first_name,' ', last_name) as emp_name, salary
from employees e
where salary > (select avg(salary) from employees where department_id = e.department_id);

-- Write a query that returns the names of all departments that have more than 10 employees.
select d.department_name
from departments d
where department_id in (
	select department_id 
    from employees 
    group by department_id 
    having count(employee_id)>10
);

-- Write a query that returns the names of all employees who work in departments that have a total salary greater than $1,000,000.
select concat(first_name,' ', last_name) as emp_name 
from employees e
where department_id  in(
	select department_id 
	from employees 
	group by department_id 
	having sum(salary) > 1000000
);

-- Write a query that returns the average salary of all employees who have been with the company for less than 3 years.
select 

-- Write a query that returns the names of all employees who have the same manager as the employee with ID 123.


-- Write a query that returns the department name and average salary of the department with the highest average salary.


-- Write a query that returns the names of all employees who have a salary greater than the highest salary in the sales department.


-- Write a query that returns the names of all employees who have a manager with a salary greater than $100,000.


-- Write a query that returns the names of all departments that have at least one employee who has been with the company for more than 5 years


-- Write a query that returns the name and salary of the employee with the second-highest salary in the company.
