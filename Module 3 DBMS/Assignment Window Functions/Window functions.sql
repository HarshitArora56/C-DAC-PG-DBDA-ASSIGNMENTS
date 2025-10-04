use hr;

-- Ranking Functions:

-- 1.	Find the top 3 highest paid employees in each department using RANK().
select employee_id, concat(first_name,' ',last_name) as emp_name, department_id, salary, salary_rank
from (
	select employee_id, first_name, last_name, department_id, salary,
	rank() over (partition by department_id order by salary desc) as salary_rank
	from employees
) as ranked_emp
where salary_rank <= 3;

-- 2.	Assign a unique row number to each employee within their department using ROW_NUMBER() based on salary descending.
select employee_id, first_name, salary, department_id, 
row_number() over (partition by department_id order by salary desc) as row_num
from employees; 

-- 3.	List departments where at least two employees share the same salary rank using DENSE_RANK().
with dept_same_salary_rank as (
	select department_id, salary,
    dense_rank() over (partition by department_id order by salary desc) as salary_rank
    from employees
), rank_counts as (
	select department_id, salary_rank, count(*) as emp_count
    from dept_same_salary_rank
    group by department_id, salary_rank
    having count(*) >= 2
)
select distinct dssr.department_id, d.department_name
from rank_counts rc
join dept_same_salary_rank dssr on rc.department_id = dssr.department_id and rc.salary_rank = dssr.salary_rank
join departments d on dssr.department_id = d.department_id;

-- 4.	Divide employees into 4 equal salary groups using NTILE(4) and display the group number along with employee details.
select employee_id, salary, 
ntile(4) over (order by salary desc) as salary_group
from employees
order by salary_group, salary;

-- 5.	Find the top 3 highest paid employees in each department using RANK().
-- with cte
with emp_salary_rank as (
	select employee_id, concat(first_name,' ' , last_name) as emp_name, department_id, salary,
    rank() over (partition by department_id order by salary desc) as salary_rank
    from employees
)
select * from emp_salary_rank where salary_rank <= 3;

-- 6.	Assign a unique row number to each employee within their department using ROW_NUMBER() based on salary descending.


-- 7.	List departments where at least two employees share the same salary rank using DENSE_RANK().


-- 8.	Divide employees into 4 equal salary groups using NTILE(4) and display the group number along with employee details.


-- Aggregate Window Functions


-- 1.	For each employee, show their salary and the average salary of their department using AVG() as a window function.
select employee_id, first_name, salary, department_id,
avg(salary) over (partition by department_id) as avg_salary_dept
from employees;

-- 2.	Show the running total of salaries for each department ordered by hire date using SUM() window function.
select employee_id, first_name, department_id, salary,
sum(salary) over (partition by department_id order by salary) as running_total
from employees;
 
-- 3.	Find the maximum salary in each department and compare it with each employee’s salary.
select employee_id, first_name, department_id, salary,
max(salary) over (partition by department_id) as max_salary_dept,
salary - max(salary) over (partition by department_id) as sal_comparison
from employees;

-- 4.	For each employee, show their salary and the average salary of their department using AVG() as a window function.
select employee_id, first_name, department_id, salary,
avg(salary) over (partition by department_id) as avg_sal_dept
from employees;

-- 5.	Show the running total of salaries for each department ordered by hire date using SUM() window function.


-- 6.	Find the maximum salary in each department and compare it with each employee’s salary.


--  Value Functions


-- 1.	For each employee, show their salary and the salary of the employee hired just before them using LAG().
select employee_id, hire_date, salary, prev_e_id, prev_salary
from (
	select employee_id, hire_date, salary, 
	lag(employee_id, 1) over (order by hire_date asc) as prev_e_id,
    lag(salary, 1) over (order by hire_date asc) as prev_salary
	from employees
) as ls;

-- 2.	Display each employee’s salary and the salary of the next hired employee in the same department using LEAD().
select employee_id, hire_date, salary, next_e_id, next_salary
from (
	select employee_id, hire_date, salary, 
	lead(employee_id, 1) over (order by hire_date asc) as next_e_id,
    lead(salary, 1) over (order by hire_date asc) as next_salary
	from employees
) as sl;

-- 3.	List each department and show the first and last hired employee using FIRST_VALUE() and LAST_VALUE() functions.

select distinct 
	e.department_id, d.department_name,
	first_value(e.employee_id) over (partition by e.department_id order by e.hire_date asc) as first_hire,
	last_value(e.employee_id) over (partition by e.department_id order by e.hire_date asc rows between unbounded preceding and unbounded following) as last_hire
from employees e
join departments d on e.department_id = d.department_id;

-- 4.	For each employee, show their salary and the salary of the employee hired just before them using LAG().


-- 5.	Display each employee’s salary and the salary of the next hired employee in the same department using LEAD().


-- 6.	List each department and show the first and last hired employee using FIRST_VALUE() and LAST_VALUE() functions.
