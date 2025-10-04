create database trigg_Assignment;
use trigg_Assignment;
-- =============================================================================
-- MYSQL EMPLOYEE MANAGEMENT SYSTEM - COMPLETE PRACTICE DATASET
-- =============================================================================

-- Drop existing tables if they exist (for fresh start)
DROP TABLE IF EXISTS email_notifications;
DROP TABLE IF EXISTS employee_archive;
DROP TABLE IF EXISTS employee_audit;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

-- =============================================================================
-- TABLE CREATION
-- =============================================================================

CREATE TABLE departments (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(100) NOT NULL,
    manager_id INT,
    total_salary_budget DECIMAL(15,2) DEFAULT 0,
    max_employees INT DEFAULT 50,
    current_employee_count INT DEFAULT 0
);

CREATE TABLE employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    job_title VARCHAR(100),
    salary DECIMAL(10,2),
    dept_id INT,
    hire_date DATE,
    status ENUM('Active', 'Terminated') DEFAULT 'Active',
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

CREATE TABLE employee_audit (
    audit_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    action VARCHAR(50),
    old_dept_id INT,
    new_dept_id INT,
    old_salary DECIMAL(10,2),
    new_salary DECIMAL(10,2),
    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    changed_by VARCHAR(100)
);

CREATE TABLE employee_archive (
    archive_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    job_title VARCHAR(100),
    salary DECIMAL(10,2),
    dept_id INT,
    hire_date DATE,
    termination_date DATE,
    archived_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE email_notifications (
    notification_id INT PRIMARY KEY AUTO_INCREMENT,
    recipient VARCHAR(100),
    subject VARCHAR(200),
    message TEXT,
    emp_id INT,
    event_type VARCHAR(50),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sent BOOLEAN DEFAULT FALSE
);

-- =============================================================================
-- SAMPLE DATA INSERTION
-- =============================================================================

-- Insert Departments
INSERT INTO departments (dept_name, manager_id, total_salary_budget, max_employees, current_employee_count) VALUES
('Human Resources', NULL, 0, 10, 0),
('Information Technology', NULL, 0, 20, 0),
('Finance', NULL, 0, 15, 0),
('Marketing', NULL, 0, 12, 0),
('Sales', NULL, 0, 25, 0),
('Operations', NULL, 0, 18, 0),
('Customer Service', NULL, 0, 15, 0);

-- Insert Employees
INSERT INTO employees (first_name, last_name, email, job_title, salary, dept_id, hire_date, status) VALUES
-- HR Department
('Sarah', 'Johnson', 'sarah.johnson@company.com', 'HR Manager', 75000.00, 1, '2020-01-15', 'Active'),
('Michael', 'Chen', 'michael.chen@company.com', 'HR Specialist', 55000.00, 1, '2021-03-20', 'Active'),
('Emily', 'Rodriguez', 'emily.rodriguez@company.com', 'Recruiter', 52000.00, 1, '2021-06-10', 'Active'),

-- IT Department
('David', 'Williams', 'david.williams@company.com', 'IT Director', 95000.00, 2, '2019-05-01', 'Active'),
('Jessica', 'Brown', 'jessica.brown@company.com', 'Senior Developer', 85000.00, 2, '2020-02-14', 'Active'),
('Robert', 'Davis', 'robert.davis@company.com', 'Software Engineer', 72000.00, 2, '2021-01-08', 'Active'),
('Amanda', 'Martinez', 'amanda.martinez@company.com', 'Database Administrator', 78000.00, 2, '2020-08-22', 'Active'),
('James', 'Wilson', 'james.wilson@company.com', 'Junior Developer', 58000.00, 2, '2022-04-15', 'Active'),

-- Finance Department
('Patricia', 'Taylor', 'patricia.taylor@company.com', 'Finance Director', 92000.00, 3, '2018-11-20', 'Active'),
('Christopher', 'Anderson', 'chris.anderson@company.com', 'Senior Accountant', 68000.00, 3, '2020-07-01', 'Active'),
('Jennifer', 'Thomas', 'jennifer.thomas@company.com', 'Financial Analyst', 62000.00, 3, '2021-09-12', 'Active'),
('Daniel', 'Moore', 'daniel.moore@company.com', 'Accountant', 55000.00, 3, '2022-01-30', 'Active'),

-- Marketing Department
('Lisa', 'Jackson', 'lisa.jackson@company.com', 'Marketing Manager', 82000.00, 4, '2019-08-15', 'Active'),
('Kevin', 'White', 'kevin.white@company.com', 'Content Specialist', 58000.00, 4, '2021-05-20', 'Active'),
('Michelle', 'Harris', 'michelle.harris@company.com', 'Social Media Manager', 61000.00, 4, '2021-11-03', 'Active'),

-- Sales Department
('Brian', 'Martin', 'brian.martin@company.com', 'Sales Director', 88000.00, 5, '2019-03-10', 'Active'),
('Nicole', 'Thompson', 'nicole.thompson@company.com', 'Senior Sales Rep', 65000.00, 5, '2020-06-18', 'Active'),
('Steven', 'Garcia', 'steven.garcia@company.com', 'Sales Representative', 52000.00, 5, '2021-08-25', 'Active'),
('Rachel', 'Martinez', 'rachel.martinez@company.com', 'Sales Representative', 51000.00, 5, '2022-02-14', 'Active'),

-- Operations Department
('Matthew', 'Robinson', 'matthew.robinson@company.com', 'Operations Manager', 79000.00, 6, '2019-12-05', 'Active'),
('Angela', 'Clark', 'angela.clark@company.com', 'Operations Coordinator', 56000.00, 6, '2021-04-22', 'Active'),

-- Customer Service Department
('Andrew', 'Lewis', 'andrew.lewis@company.com', 'Customer Service Manager', 68000.00, 7, '2020-10-08', 'Active'),
('Rebecca', 'Lee', 'rebecca.lee@company.com', 'Customer Service Rep', 45000.00, 7, '2021-12-01', 'Active'),
('Joshua', 'Walker', 'joshua.walker@company.com', 'Customer Service Rep', 44000.00, 7, '2022-03-15', 'Active');

-- Update department managers
UPDATE departments SET manager_id = 1 WHERE dept_id = 1;  -- Sarah Johnson
UPDATE departments SET manager_id = 4 WHERE dept_id = 2;  -- David Williams
UPDATE departments SET manager_id = 9 WHERE dept_id = 3;  -- Patricia Taylor
UPDATE departments SET manager_id = 13 WHERE dept_id = 4; -- Lisa Jackson
UPDATE departments SET manager_id = 16 WHERE dept_id = 5; -- Brian Martin
UPDATE departments SET manager_id = 19 WHERE dept_id = 6; -- Matthew Robinson
UPDATE departments SET manager_id = 21 WHERE dept_id = 7; -- Andrew Lewis



-- 1.	How can MySQL triggers be used to automatically update employee records when a department is changed?

show tables;
delimiter $$
create trigger trg_emp_dept_change
after update on employees
for each row
begin
	if old.dept_id != new.dept_id then
		insert into employee_audit (emp_id, action, old_dept_id, new_dept_id) values (new.emp_id, 'dept changed', old.dept_id, new.dept_id);
    end if;
end$$
delimiter ;
drop trigger trg_emp_dept_change;
INSERT INTO departments (dept_name, manager_id, total_salary_budget, max_employees, current_employee_count) VALUES
('Fin dept', NULL, 0, 10, 0);
update employees set dept_id = 10 where dept_id = 3;
select * from employee_audit;

-- 2.	What MySQL trigger can be used to prevent an employee from being deleted if they are currently assigned to a department?
delimiter $$
create trigger trg_prevent_emp_del_dept
before delete on employees
for each row
begin
	if old.dept_id is not null then
		signal sqlstate '45000' 
        set message_text = 'Cannot delete employee assigned to a department';
	end if;
end$$
delimiter ;
delete from employees where first_name = 'Sarah';
drop trigger trg_prevent_emp_del_dept;
-- 3.	How can a MySQL trigger be used to send an email notification to HR when an employee is hired or terminated?
delimiter $$
create trigger trg_emp_hire_notification
after insert on employees
for each row
begin
	insert into email_notifications(recipient, subject, emp_id, event_type) values ('hr@company.com', 'New emp Hiring', new.emp_id, 'HIRE');
end$$
delimiter ;

delimiter $$
create trigger trg_emp_termination_notification
after delete on employees
for each row
begin
	insert into email_notifications(recipient, subject, emp_id, event_type) values ('hr@company.com', 'Emp Termination', old.emp_id, 'Terminated');
end$$
delimiter ;

INSERT INTO employees (first_name, last_name, email, job_title, salary, dept_id, hire_date, status) VALUES
-- HR Department
('Harsh', 'Arora', 'harshit.arora@company.com', 'HR Manager', 85000.00, 1, '2025-10-3', 'Active');

delete from employees where first_name = 'Harshit';
show triggers;
select * from employees;
select * from email_notifications;

-- 4.	What MySQL trigger can be used to automatically assign a new employee to a department based on their job title?
delimiter $$
create trigger trg_auto_assign_dept
before insert on employees
for each row
begin
	if new.dept_id is null then
		if new.job_title like '%Developer%' then
			set new.dept_id = 8;
		elseif new.job_title like '%Accountant%' then
			set new.dept_id = 10;
		elseif new.job_title like '%Sales%' then
			set new.dept_id = 5;
        end if;
    end if;
end$$
delimiter ;

INSERT INTO employees (first_name, last_name, email, job_title, salary, hire_date, status) VALUES
('Rujali', 'Nagbhidhkar', 'r.n@company.com', 'Developer', 85000.00, '2025-10-3', 'Active');

INSERT INTO employees (first_name, last_name, email, job_title, salary, hire_date, status) VALUES
('Yogesh', 'Sapkale', 'r.n@company.com', 'Accountant', 85000.00, '2025-10-3', 'Active');
select * from employees;

-- 5.	How can a MySQL trigger be used to calculate and update the total salary budget for a department whenever a new employee is hired or their salary is changed?

delimiter $$
create trigger trg_update_budget_dept
after update on employees
for each row
begin
	if old.salary <> new.salary and old.dept_id = new.dept_id then
		update departments
        set total_salary_budget = total_salary_budget - old.salary + new.salary
        where dept_id = new.dept_id;
        
        INSERT INTO employee_audit (emp_id, action, old_salary, new_salary, changed_by)
        VALUES (NEW.emp_id, 'Salary Changed', OLD.salary, NEW.salary, USER());
    end if;
end$$
delimiter ;

drop trigger trg_update_budget_dept;
update employees set salary = 100000 where first_name = 'Harsh';
select * from employees;
select * from departments;
select * from employee_audit;
desc departments;

-- 6.	What MySQL trigger can be used to enforce a maximum number of employees that can be assigned to a department?

delimiter $$
delimiter ;

-- 7.	How can a MySQL trigger be used to update the department manager whenever an employee under their supervision is promoted or leaves the company?


-- 8.	What MySQL trigger can be used to automatically archive the records of an employee who has been terminated or has left the company?

