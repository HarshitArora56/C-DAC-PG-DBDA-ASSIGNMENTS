use hr;
-- 1. Write a query to find the addresses (location_id, street_address, city, state_province, country_name) of all the departments.

select l.location_id, l.street_address, l.city, l.state_province, l.country_id, c.country_name 	
from departments d
join locations l on d.location_id = l.location_id
join countries c on l.country_id = c.country_id;  

-- 2. Write a query to find the name (first_name, last name), department ID and name of all the employees

select e.first_name, e.last_name, e.department_id 
from employees e
join departments d
on e.department_id = d.department_id;

-- 3. Write a query to find the name (first_name, last_name), job, department ID and name of the employees who works in London.

select concat(e.first_name, ' ' , e.last_name) full_name, e.department_id, j.job_title, l.city
from employees e
join jobs j on e.job_id = j.job_id
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
where l.city = 'london';

-- 4. Write a query to find the employee id, name (last_name) along with their manager_id and name (last_name).
select * from employees;
select e.employee_id, e.last_name as e_last_name , m.manager_id, m.last_name as m_last_name
from employees e
left join employees m on m.employee_id = e.manager_id;

-- 5. Write a query to find the name (first_name, last_name) and hire date of the employees who was hired after 'Jones'.
select * from employees;
-- with subquery
select concat(first_name,' ', last_name), hire_date 
from employees 
where hire_date > (
select hire_date 
from employees 
where last_name = 'Jones' 
limit 1
);

-- with joins
SELECT 
    e.first_name,
    e.last_name,
    e.hire_date
FROM employees e
JOIN employees j ON j.last_name = 'Jones'
WHERE e.hire_date > j.hire_date;
-- 6. Write a query to get the department name and number of employees in the department.
select * from departments;

select d.department_name, count(e.employee_id) as total_emp
from departments d 
join employees e on d.department_id = e.department_id 
group by d.department_id;

-- 7. Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 90.
select * from job_history;
select jh.employee_id, j.job_title, jh.department_id, datediff(jh.end_date, jh.start_date) as duration_days
from job_history jh
join jobs j on j.job_id = jh.job_id
where jh.department_id = 90;

-- 8. Write a query to display the department ID and name and first name of manager.

select * from departments;
select d.department_id, d.department_name, e.first_name 
from departments d 
join employees e on d.manager_id = e.employee_id; 

-- 9. Write a query to display the department name, manager name, and city.
select d.department_name, e.first_name as manager_name, l.city
from departments d 
join employees e on d.manager_id = e.employee_id
join locations l on d.location_id = l.location_id;

-- 10. Write a query to display the job title and average salary of employees.
select j.job_title, avg(salary) as avg_salary
from jobs j
join employees e on j.job_id = e.job_id
group by j.job_title;

-- 11. Write a query to display job title, employee name, and the difference between salary of the employee and minimum salary for the job.

select * from jobs;
select * from employees;
select j.job_title, concat(e.first_name,' ',e.last_name) as emp_name, e.salary - j.min_salary as sal_diff 
from jobs j 
join employees e on e.job_id = j.job_id;

-- 12. Write a query to display the job history that were done by any employee who is currently drawing more than 10000 of salary.

select * from job_history;
select jh.* 
from job_history jh 
join employees e on jh.employee_id = e.employee_id 
where e.salary > 10000;

-- 13. Write a query to display department name, name (first_name, last_name), hire date, salary of the manager for all managers whose experience is more than 15 years.

select department_name, concat(first_name,' ', last_name) as name, hire_date, salary, timestampdiff(year,e.hire_date,curdate()) 
from departments d
join employees e on d.manager_id = e.employee_id
where timestampdiff(year,e.hire_date,curdate()) > 15;


