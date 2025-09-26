create database Assignment2;
use assignment2;

# Ques 1
create table students(
	id int primary key, 
    name varchar(20) not null,
    age int default 18
);

# Ques 2
insert into students value(1,null, 20); -- error
#18:00:05	insert into students value(1,null, 20)	Error Code: 1048. Column 'name' cannot be null	0.000 sec

# Ques 3
insert into students(id, name) value(2,"Ravi"); # stores the default value 18



# Ques 4
insert into students(id) value(3); -- it failed because name column can't be null we must assign a value to it
# 18:01:46	insert into students(id) value(3)	Error Code: 1364. Field 'name' doesn't have a default value	0.000 sec

# Ques 5
alter table students 
alter column age set default 21;

insert into students(id, name) value(3,"Ram"); # stores the default value 18


# Ques 6 
alter table students 
modify name varchar(20) NULL;

insert into students(id, name) value(4,null); # stores the default value 18

select * from students; 

# Ques 7
create table department(
	dept_id int primary key,
    dept_name varchar(50)
);

# Ques 8
insert into department values(1,"IT"),
(1, "HR"); -- error due to primary key constraint
# 18:12:34	insert into department values(1,"IT"), (1, "HR")	Error Code: 1062. Duplicate entry '1' for key 'department.PRIMARY'	0.000 sec

# Ques 9
# no a table can't have two primary keys
create table two_primary_key(
	id int primary key,
    mobile_no int(10) primary key
); -- error 

# 18:14:25	create table two_primary_key(  id int primary key,     mobile_no int(10) primary key )	Error Code: 1068. Multiple primary key defined	0.000 sec
create table two_primary_key1(
	id int primary key,
    mobile_no int(10) unique not null
);
-- generally "unique & not null" constraints combined form a primary key but due to the prior declaration of a primary key it will remain unique only 
desc two_primary_key1;

# Ques 10
create table enrollment(
	student_id int,
    course_id varchar(10),
    primary key (student_id, course_id)
);

# Ques 11
insert into enrollment value(101, "DBMS"),
(101, "DBMS"); -- error
# 18:28:32	insert into enrollment value(101, "DBMS"), (101, "DBMS")	Error Code: 1062. Duplicate entry '101-DBMS' for key 'enrollment.PRIMARY'	0.016 sec


# Ques 12
create table users(
	user_id int primary key auto_increment,
    email varchar(50) unique
);
# Ques 13

insert into users(email) value("abc@mail.com");
insert into users(email) value("abc@mail.com"); -- error becase email column has unique constraint

select * from users;

# Ques 14

insert into users(email) values(null);
insert into users(email) values(null); -- works because null value can't be compared 

# Ques 15

create table products (
	sku varchar(50),
    region varchar(50),
    unique(sku, region)
);

# Ques 16
insert into products(sku, region) values ("A1", "US");
insert into products(sku, region) values ("A1", "US"); -- error Duplicate error
# 22:21:11	insert into products(sku, region) values ("A1", "US")	Error Code: 1062. Duplicate entry 'A1-US' for key 'products.sku'	0.047 sec

# Ques 17

create table department1 (
	dept_id int primary key,  
    department varchar(50)
);

insert into department1 values (1, "IT");

create table employee(
	emp_id int,
    name varchar(50),
    dept_id int,
    foreign key (dept_id) references department1(dept_id)
);

# Ques 18
insert into employee values (1, "Asha", 99); -- error because a foreign key constraint fails

# Ques 19
insert into employee(emp_id, name, dept_id) values (101, "Aman", 1);

# without on delete cascade
delete from department1 where dept_id = 1; -- error because a foreign key constraint fails

# Ques 20
show create table employee;
alter table employee drop foreign key employee_ibfk_1;
alter table employee add foreign key (dept_id) references department1(dept_id)
on delete cascade;

delete from department1 where dept_id = 1; -- executed and dept_id gets deleted from both the tables

# Ques 21
alter table employee drop foreign key employee_ibfk_1;
alter table employee add foreign key (dept_id) references department1(dept_id)
on delete set null;

insert into department1 values (1, "IT");
insert into employee(emp_id, name, dept_id) values (101, "Aman", 1);

delete from department1 where dept_id = 1; -- executed, deleted from department1 table and assigned null value to dept_id in employee table

Select * from employee;

# Ques 22
alter table employee add constraint fk_emp_dept foreign key (dept_id) references department1(dept_id)
on delete set null;

alter table employee drop foreign key fk_emp_dept; # drops foreign key constraint with name fk_emp_dept

# Ques 23
ALTER TABLE employee
ADD PRIMARY KEY (emp_id);

ALTER TABLE employee
ADD COLUMN manager_id INT;

ALTER TABLE employee
ADD CONSTRAINT fk_manager
FOREIGN KEY (manager_id)
REFERENCES employee(emp_id);


INSERT INTO employee (emp_id, name, dept_id) VALUES (201, 'Ravi', NULL);

INSERT INTO employee (emp_id, name, dept_id, manager_id) VALUES (202, 'Meena', NULL, 201);
select * from employee;

# Ques 24

create table accounts (
	acc_no int primary key,
    balance decimal(12,2),
    check(balance >= 0)
);

# Ques 25
insert into accounts values(1, -100); -- error due check constraint failure

# Ques 26
show create table accounts;
alter table accounts drop check accounts_chk_1;
alter table accounts 
add constraint check_balance_range 
check(balance >= 100 and balance <= 1000000);

# Ques 27
insert into accounts values(2, 50); -- error due check constraint failure

# Ques 28

create table invoices (
	invoice_id int auto_increment primary key
);

insert into invoices values(); -- invoice_id = 1
insert into invoices values(); -- invoice_id = 2
insert into invoices values(); -- invoice_id = 3

select * from invoices;

# Ques 29

delete from invoices order by invoice_id desc limit 1;

insert into invoices values();

select * from invoices; -- no it doesn't uses the last number it increments to next number

# Ques 30

# add a unique constraint on phone
alter table users add column phone int(10) unique;

show create table users;

# Drop unique constraint
alter table users
drop constraint phone;

# Ques 31

create table library (
	book_id int,
    branch_id int unique,
    isbn varchar(10) unique,
    primary key(book_id, branch_id)
);

# Ques 32
insert into library values(1,101,"A123");
insert into library values(1,101,"A123"); -- error as primary key constraint fails
# 12:43:30	insert into library values(1,101,"A123")	Error Code: 1062. Duplicate entry '1-101' for key 'library.PRIMARY'	0.047 sec

# Ques 33
insert into library value(1,102,"A123"); -- error as primary key constraint fails

# Ques 34
create table accounts1 (
    user_id int primary key,                      -- Primary key
    email varchar(100) unique,                    -- Unique constraint on email
    username varchar(50) unique,                 -- Unique constraint on username
    phone_number varchar(10),
    constraint unique_email_phone unique (email, phone_number)  -- Composite unique constraint
);

# Ques 35
create table table1(
	id int primary key,
    name varchar(50),
    unique(id)
); -- executes perfectly

# Ques 36
create table exam_results(
	student_id int,
    exam_id int, 
    marks int check(marks between 0 and 100),
    primary key (student_id, exam_id)
);


# Ques 37
create table customers (
	cust_id int primary key,
    cust_name varchar(50)
);

insert into customers 
values
	(1, "Aashi"),
	(2,"Harshit"),
    (3,"Yogesh"),
    (4,"Vedant");

create table orders(
	order_id int primary key,
    cust_id int,
    order_date date,
    foreign key(cust_id) references customers(cust_id)
    on update cascade
);

insert into orders 
values 
	(101, 2 , '2025-07-23'),
	(102, 4 , '2025-09-15'),
	(103, 3 , '2025-09-20');
    
select * from orders;
select * from customers;

update customers set cust_id = 5 where cust_id = 4; -- updated into both the tables

# Ques 38 

# Ques 39

create table categories(
	id int auto_increment primary key,
    name varchar(50),
    parent_id int,
    foreign key (parent_id) references categories(id)
);

insert into categories (name) 
values
	("Electronics"),
	("Furniture");
    
    
insert into categories (name, parent_id) 
values
	("Computers", 1),
	("Table", 2),
    ("Laoptop", 3);
    
select * from categories;

# Ques 40
delete from categories where id = 2; -- error fails foreing key constraint without on delete cascade
# 15:17:24	delete from categories where id = 2	Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`assignment2`.`categories`, CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `categories` (`id`))	0.000 sec

# Ques 41
# Disabling foreign key checks
set foreign_key_checks = 0;
insert into categories(name, parent_id) value ("Random Category", 999); # id = 999 and parent_id = 999 doesn't exists so its an invalid data
# Executed without error

# Ques 42 
# re-enabling foreign key checks
set foreign_key_checks = 1; -- executed without error

# Ques 43

# Ques 44
create table employees(
	emp_id int auto_increment primary key,
    salary int check(salary > 20000)
);

# Ques 45
insert into employees (emp_id, salary) value (1, 15000); -- error as check constraint fails
# 15:28:18	insert into employees (emp_id, salary) value (1, 15000)	Error Code: 3819. Check constraint 'employees_chk_1' is violated.	0.000 sec

# Ques 46

alter table employees 
add column gender char(1) check(gender = "M" or gender = "F");

# Ques 47
insert into employees (gender) value ("X"); -- error as check constraint is fails
# 15:30:43	insert into employees (gender) value ("X")	Error Code: 3819. Check constraint 'employees_chk_2' is violated.	0.000 sec

# Ques 48
create table department2(
	dept_id int auto_increment primary key,
    dept varchar(50)
);

insert into department2(dept) 
values 
	("IT"),
    ("HR");
    
select * from department2;

create table employee2 (
	emp_id int primary key auto_increment,
    name varchar(50),
    dept_id int,
    constraint fk_emp_dept foreign key (dept_id) references department2(dept_id)
);

insert into employee2 (name, dept_id) 
values
	("Harshit", 1),
	("Yogesh", 2),
	("Aashi", 1),
	("Rujali", 2);

insert into employee2 (name, dept_id) 
values
	("Vedant", 3); -- error as foreing key constraint is violated
Select * from employee2;

# Ques 49
alter table library 
drop primary key;

# Ques 50
show create table employee2;
# previous foreign key constraint name ->  fk_emp_dept

# changing the fk constraint name

alter table employee2 drop foreign key fk_emp_dept;

alter table employee2 
add constraint fk_employee_department
foreign key (dept_id) references department2(dept_id);

show create table employee2; -- changed

use constraints;






use constraints;

create table emp_primary(
	s_id int, 
    name varchar(50),
    email varchar(50) primary key
);

show create table emp_primary;
desc emp_primary;
alter table emp_primary modify column s_id int not null unique;

alter table emp_primary add index (s_id);

show indexes from emp_primary;

alter table emp_primary drop primary key;



create table emp_primary1(
	s_id int, 
    name varchar(50),
    email varchar(50) primary key
);
desc emp_primary1;
alter table emp_primary1 drop primary key;







