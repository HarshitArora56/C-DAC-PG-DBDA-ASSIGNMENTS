use hr;
-- 1.	Write a stored procedure to retrieve all employees from the Employees table for a given department ID.
delimiter $$
create procedure get_emp(in dept_id int)
begin
	select * 
    from employees
    where department_id = dept_id;
end$$
delimiter ;
call get_emp(90);

-- 2.	Create a function that calculates the total salary expenditure for a given department ID.

delimiter $$
create function dept_total_expenditure(dept_id int)
returns decimal(10,2)
deterministic
reads sql data
begin
	declare total_salary decimal(10,2);
    select sum(salary) into total_salary
    from employees
    where department_id = dept_id;
    
    if total_salary is null then
		set total_salary = 0;
	end if;
    
    return total_salary;
end$$
delimiter ;

select dept_total_expenditure(100);

-- 3.	Develop a stored procedure that accepts an employee ID as an input parameter and increases the salary of that employee by a specified percentage.
delimiter $$
create procedure salary_increment(in emp_id int, in inc_percentage decimal(5,2))
begin
	update employees
    set salary = salary * (1 + inc_percentage/100)
    where employee_id = emp_id;
    
    select employee_id, salary from employees where employee_id = emp_id;
end$$
delimiter ;
call salary_increment(101, 20);


-- 4.	Write a function to determine the average salary for employees in a specific job title category.
delimiter $$
create function avg_salary_for_job (j_id varchar(50))
returns decimal(10,2)
deterministic
reads sql data
begin
	declare avg_sal decimal(10,2);
	select avg(salary) into avg_sal
    from employees
    where job_id = j_id;
    
    return avg_sal;
end$$
delimiter ;

SELECT avg_salary_for_job('IT_PROG') AS it_programmer_avg;
SELECT avg_salary_for_job('SA_MAN') AS sales_manager_avg;
SELECT avg_salary_for_job('FI_ACCOUNT') AS accountant_avg;

select distinct job_id, avg_salary_for_job(job_id) as avg_sal from employees order by avg_sal desc;

-- 5.	Create a stored procedure that takes an employees first name and last name as input parameters and returns the full name in uppercase letters.
delimiter $$
create procedure getFullNameUppercase(in first_name varchar(50), in last_name varchar(50), out full_name varchar(100))
begin
	set full_name = upper(concat(first_name,' ',last_name));
end$$
delimiter ;
call getFullNameUppercase('harshit','arora',@full_name);
select @full_name as full_name;

-- 6.	Write a stored procedure to insert a new employee into the Employees table with the provided first name, last name, and department ID.
delimiter $$
create procedure add_emp(in e_first_name varchar(50), in e_last_name varchar(50), in e_department_id int)
begin
	insert into employees(first_name,last_name, department_id) values (e_first_name, e_last_name, e_department_id);
end$$
delimiter ;

call add_emp('Harshit','Arora', 101);
desc employees;

-- 7.	Create a function to calculate the total number of employees in a specific department.

delimiter $$
create function total_emp_dept(dept_id int)
returns int
not deterministic
reads sql data
begin
	declare emp_count int;
	select count(employee_id) into emp_count 
    from employees
    where department_id = dept_id;
    
    return emp_count;
end$$
delimiter ;

select total_emp_dept(100) as emp_count_dept;
select total_emp_dept(60) as emp_count_dept;

-- 8.	Develop a stored procedure that accepts an employee ID as input and deletes that employees record from the Employees table.

delimiter $$
create procedure remove_emp(in emp_id int)
begin
	delete from employees where employee_id = emp_id;
end$$
delimiter ;
show triggers;
drop trigger before_employee_delete;
call remove_emp(102);
select * from employees;

-- 9.	Write a function to determine the highest salary in the Employees table.

delimiter $$
create function max_sal()
returns decimal(10,2)
deterministic
reads sql data
begin
	declare m_sal decimal(10,2);
	select max(salary) into m_sal
    from employees;
    
    return m_sal;
end$$
delimiter ;

select max_sal() as max_salary_employees;

-- 10.	Create a stored procedure that takes a department ID as an input parameter and returns the list of employees sorted by their salary in descending order within that department.

delimiter $$
create procedure emp_of_dept(in dept_id int)
begin
	select employee_id, concat(first_name,' ',last_name) as emp_name, salary
    from employees 
    where department_id = dept_id
    order by salary desc;
end$$
delimiter ;

call emp_of_dept(90);

-- 11.	Write a stored procedure to update the job title of an employee based on their employee ID.

delimiter $$
create procedure update_job_title(in emp_id int) 
begin
	
end$$
delimiter ;

-- 12.	Create a function that returns the number of employees hired in a specific year.

-- 13.	Develop a stored procedure that accepts an employee ID as input and retrieves the employees details, including their name, department, and salary.

-- 14.	Write a function to calculate the average tenure (in years) of employees in the company.

-- 15.	Create a stored procedure that takes a department ID as an input parameter and returns the department name along with the count of employees in that department.

-- 16.	Write a stored procedure to retrieve the top N highest-paid employees in the company, where N is an input parameter.

-- 17.	Create a function that calculates the total bonus amount for all employees based on their performance ratings.

-- 18.	Develop a stored procedure that accepts a salary threshold as an input parameter and retrieves all employees with salaries above that threshold.

-- 19.	Write a function to determine the average age of employees in the company based on their birthdates.

-- 20.	Create a stored procedure that takes an employees last name as an input parameter and returns all employees with a similar last name.

-- 21.	Write a stored procedure to update the email address of an employee based on their employee ID.

-- 22.	Create a function that calculates the total experience (in years) of all employees combined in the company.

-- 23.	Develop a stored procedure that accepts a department ID as input and returns the department name along with the average salary of employees in that department.

-- 24.	Write a function to determine the number of employees who have been with the company for more than a specified number of years.

-- 25.	Create a stored procedure that takes a job title as an input parameter and returns the count of employees holding that job title.

-- 26.	Write a stored procedure to retrieve the details of employees who have a salary within a specified range.

-- 27.	Create a function that calculates the total number of working hours for an employee in a given month.

-- 28.	Develop a stored procedure that accepts an employee ID as input and retrieves the employees department name and managers name.

-- 29.	Write a function to determine the total number of employees hired in each year, grouped by the year of hire.

-- 30.	Create a stored procedure that takes a city name as an input parameter and returns the list of employees residing in that city.

-- 31.	Write a stored procedure that calculates the average salary increase percentage for employees who have been with the company for more than five years.

-- 32.	Create a function that calculates the total sales revenue generated by each employee in the Sales department, considering both individual and team contributions.

-- 33.	Develop a stored procedure that accepts a date range as input and retrieves all employee attendance records within that period, including late arrivals and early departures.

-- 34.	Write a function that determines the average number of projects handled by employees in each department and identifies departments with exceptionally high or low project volumes.

-- 35.	Create a stored procedure that takes a job title as an input parameter and returns the list of employees holding that job title, along with the total compensation considering bonuses and allowances.

-- 36.	Write a stored procedure that calculates the performance rating for each employee based on various criteria, such as project completion, client feedback, and adherence to deadlines.

-- 37.	Create a function that determines the average time taken to resolve customer issues for each support agent, considering different issue categories and urgency levels.

-- 38.	Develop a stored procedure that accepts a date range and a specific project ID as input and retrieves all employee work hours dedicated to that project within the given period.

-- 39.	Write a function that calculates the employee turnover rate for each department, considering the number of new hires and the number of departures over a specified time frame.

-- 40.	Create a stored procedure that takes a location as an input parameter and returns the list of employees who have been involved in projects related to that location, along with their project contributions and performance ratings.

