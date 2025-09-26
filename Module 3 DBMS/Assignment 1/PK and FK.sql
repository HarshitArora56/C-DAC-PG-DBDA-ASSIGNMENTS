create database Assignment1;

# Ques1
use assignment1;
create table Department(
	dept_id int primary key,
    dept_name varchar(100)
);

# Ques2
create table Employee(
	emp_id int primary key,
    emp_name varchar(70),
    salary double(10,2),
    dept_id int,
    foreign key (dept_id) references department(dept_id)
);

# Ques3
insert into department(dept_id, dept_name)
values (101, "Finance"),
(102, "Information Technology"),
(103, "Operations");

select * from department;

insert into employee(emp_id, emp_name, salary, dept_id)
values (1, "Harshit", 50000, 102),
(2,"Naman", 40000, 103),
(3, "Suresh", 60000, 101),
(4, "kriti", 50000, 102),
(5, "Simran", 35000, 103);

select * from employee;

# Ques 4
# All Employees with their department names
# trying "join"

select 
	e.emp_id,
    e.emp_name,
    e.salary,
    d.dept_name
from 
	Employee e
join
	Department d on e.dept_id = d.dept_id;
    
    
# Ques 5
select 
	e.emp_id, e.emp_name, e.salary, d.dept_name 
from 
	Employee e 
join 
	department d on e.dept_id = d.dept_id 
where 
	d.dept_name = "Information Technology";

# Ques 6
# Ques 7
insert into employee(emp_id, emp_name, salary, dept_id) value(6, "Meena", 50000, 101);
select * from employee;

# Ques 8 
insert into employee(emp_id, emp_name, salary, dept_id) value (6, "Sirish", 40000, 104);
# Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`assignment1`.`employee`, CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`))
# This happens because foreign is refering to the primary key of the department table so it can only contain the entries which are present in deptartment table 

# Ques 9
delete from department where dept_name = "Finance";
# Output without CASCADE MySQL refuses to delete the department due to foreign key constraints
# Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`assignment1`.`employee`, CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`))

# Ques 10
show create table employee;
alter table employee drop foreign key employee_ibfk_1;
alter table Employee 
add foreign key (dept_id) references department(dept_id)
on delete cascade;


# Ques 11
# Trying to delete after altering table
delete from department where dept_name = "Finance";

select * from employee;
select * from department;

# Ques 12
show create table employee;
alter table employee drop foreign key employee_ibfk_1;
alter table employee
add foreign key (dept_id) references department(dept_id)
on update cascade
on delete cascade;


# Ques 13
update department set dept_id = 101 where dept_name = "Information Technology"; 

select * from employee;
select * from department;

# Ques 14
show create table employee;
alter table employee drop foreign key employee_ibfk_1;
alter table employee
add foreign key (dept_id) references department(dept_id)
on update cascade
on delete set null;

# Ques 15
delete from department where dept_name = "Operations";

select * from employee;
select * from department;
