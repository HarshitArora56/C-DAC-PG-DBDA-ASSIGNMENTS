use hr;
-- 1.	Write a query to display the FIRST_NAME and LAST_NAME concatenated as Full Name for all employees.
select concat(first_name, " ", last_name) as full_name from employees;

-- 2.	Write a query to display the FIRST_NAME in lowercase and the LAST_NAME in uppercase for all employees.
select lower(first_name), upper(Last_name) from employees;

-- 3.	Write a query to display the COUNTRY_NAME of all countries in uppercase.


-- 4.	Write a query to display the FIRST_NAME and the length of the first name for all employees.
select first_name, length(first_name) from employees;

-- 5.	Write a query to display the EMAIL and the length of the email address for employees whose email length is greater than 10
select email, length(email) from employees;

-- 6.	Write a query to extract the first three characters from the FIRST_NAME of all employees.
select substring(first_name, 1,3) from employees;

-- 7.	Write a query to extract the last four characters of the PHONE_NUMBER for all employees.
select right(phone_number, 4) from employees;

-- 8.	Write a query to find the position of the letter 'a' in the LAST_NAME of all employees.
select last_name, instr(last_name, 'a') from employees;

-- 9.	Write a query to find the position of the substring 'IT' in the job title of all employees.
select job_id, instr(job_id, 'IT') from employees;

-- 10.	Write a query to replace all occurrences of 'a' with 'X' in the FIRST_NAME of all employees.
select first_name,replace(first_name, 'a','X') from employees;
-- 11.	Write a query to replace the region name 'Europe' with 'EU' in the REGION_NAME column.
show columns from regions;
select region_name, replace(region_name, "Europe", 'EU') from regions;

-- 12.	Write a query to remove any leading and trailing spaces from the FIRST_NAME of all employees and display the cleaned-up names.
select first_name, trim(first_name) from employees;

-- 13.	Write a query to remove any trailing spaces from the CITY names of all locations.
desc locations;
select trim(city) from locations;

-- 14.	Write a query to extract the first five characters from the EMAIL of all employees using the LEFT function.
select left(email, 5) from employees;

-- 15.	Write a query to extract the last three characters from the COUNTRY_NAME of all countries using the RIGHT function.
select right(country_name, 3) from countries; 

-- 16.	Write a query to extract the domain (everything after '@') from the EMAIL column of all employees.
select substring_index(email, '@', -1) from employees;

-- 17.	Write a query to extract the country code (first part before space) from the PHONE_NUMBER of all employees.
select phone_number from employees;
select substring_index(phone_number, '.', 1) from employees;

-- 18.	Write a query to compare the FIRST_NAME and LAST_NAME of employees and display 0 if they are the same and a non-zero value if they are different.
select strcmp(first_name, last_name) from employees;

-- 19.	Write a query to compare the REGION_NAME of regions and display 0 if it is 'Asia' and 1 otherwise.
desc regions;
SELECT 
    REGION_NAME,
    IF(instr(region_name, 'Asia') > 0, 0, 1) AS Region_Comparison
FROM 
    regions;

-- 20.	Write a query to display the FIRST_NAME, LAST_NAME, and JOB_TITLE concatenated as a single string, with each value separated by a hyphen (-), for all employees.
select concat(first_name, ' - ',last_name, ' - ',job_id) from employees;

-- 21.	Write a query to extract the username (portion before @) from the EMAIL column and display it along with the FIRST_NAME for all employees.
select first_name , substring_index(email, "@", 1) from employees;

-- 22.	Write a query to replace all occurrences of 'e' with 'E' in the LAST_NAME of employees whose LAST_NAME contains 'e'.
select last_name, replace(last_name, 'e', 'E') from employees;

-- 23.	Write a query to find the position of the first occurrence of the letter 'o' in the FIRST_NAME of employees and display the name along with the position.
select first_name, instr(first_name, 'o') from employees;

-- 24.	Write a query to display the CITY name for all locations, removing any leading and trailing spaces, and also display the first three characters of the cleaned-up city name.
select trim(city), substring(trim(city), 1,3) from locations;

-- 25.	Write a query to find employees whose LAST_NAME contains the letter 'n' and display their LAST_NAME along with the position of the first occurrence of 'n'.
select last_name, instr(last_name, 'n') from employees;

-- 26.	Write a query to find the position of the letter 'a' in the FIRST_NAME for all employees. Display the employee's first name and the position of the letter 'a'.
select first_name, instr(first_name, 'n') from employees;

-- 27.	Write a query to display the position of the first occurrence of 'e' in the JOB_TITLE for all jobs, and display only those where the letter 'e' occurs after the 5th character.
select job_title, instr(job_title, 'e') from jobs where instr(job_title, 'e') > 5;

-- 28.	Write a query to compare the FIRST_NAME and LAST_NAME of employees and display only those employees where the first name comes alphabetically before the last name.
select first_name, last_name, strcmp(first_name, last_name) from employees where strcmp(first_name, last_name) < 0;

-- 29.	Write a query to find all departments where the DEPARTMENT_NAME is either 'IT' or 'HR' using the FIND_IN_SET function.
select department_name, find_in_set(department_name, "IT,HR") from departments where find_in_set(department_name, "IT,HR") > 0;

-- 30.	Write a query to display the FIRST_NAME and the length of the name for employees whose FIRST_NAME length is greater than 6.
select first_name, length(first_name) from employees where length(first_name) > 6;

-- 31.	Write a query to find all countries where the COUNTRY_NAME contains either 'China', 'India', or 'Japan'
select country_name from countries where country_name like '%china%' or country_name like '%india%' or country_name like '%japan%';

-- 32.	Write a query to find all employees who have DEPARTMENT_ID present in the list (50, 60, 70)
select * from employees where department_id in(50,60,70);

-- 33.	Write a query to extract the first two characters from the COUNTRY_NAME function and the last two characters displaying them along with the full COUNTRY_NAME.
select country_name, right(country_name,2), left(country_name, 2) from countries;

-- 34.	Write a query to display employees whose LAST_NAME contains the letter 'o' at a position greater than half the length of their last name.
select last_name, instr(last_name, 'o'), length(last_name)/2 from employees where (length(last_name)/2) < instr(last_name, 'o');

-- 35.	Write a query to find employees whose FIRST_NAME contains the letter 'a' and the letter 'e' and display the positions of both.
select first_name, instr(first_name, 'a'), instr(first_name,'e') from employees where instr(first_name,'a') > 0 and instr(first_name, 'e') > 0;

-- 36.	Write a query to extract the domain from the EMAIL column for employees and only display employees whose domain is 'example.com'.
select substring_index(email, '@',-1) from employees;

-- 37.	Write a query to count the number of employees who belong to department IDs 50, 60, or 70
select count(employee_id) from employees where department_id in(50,60,70);

-- 38.	Write a query to display all COUNTRY_NAMEs from the countries table where REGION_ID is either 1 or 3 
select country_name, region_id from countries where region_id = 1 or region_id = 3;

-- 39.	Write a query to find employees who either work in departments 50, 60, or 70 or have a salary greater than 10,000.
select employee_id, department_id from employees where department_id in(50,60,70);

-- 40.	Write a query to find employees whose DEPARTMENT_ID is either 50 or 60 and their MANAGER_ID is either 103 or 108.


-- After Join/case Statement


-- 41.	Write a query to display FIRST_NAME, LAST_NAME, and COUNTRY_NAME concatenated as a single string with a comma separating each.


-- 42.	Write a query to display the FIRST_NAME in uppercase for employees whose SALARY is greater than 8000 and the LAST_NAME in lowercase for employees whose SALARY is less than 8000.

