-- Groupby, Having, Conditional - intermediate

use northwind;
show tables;
-- categories
-- customer_customer_demo
-- customer_demographics
-- customers
-- employee_territories
-- employees
-- order_details
-- orders
-- products
-- region
-- shippers
-- suppliers
-- territories
-- us_states

-- Section 1
-- QUESTION 1: Employee Order Count by Year
-- Business Scenario: Count how many orders each employee handled per year.
-- Requirements: Show employee order counts for each year (1997-1998). Include only employees who processed more than 10 orders per year. 
-- Categorize employees as 'High Volume' (>30 orders), 'Medium Volume' (15-30 orders), or 'Low Volume' (<15 orders).
-- Expected Output: employee_id, order_year, total_orders, avg_freight, employee_category

select * from employees;
select * from orders;

select employee_id, 
year(order_date) as order_year, 
count(order_id) as total_orders, 
avg(freight) as avg_freight,
case
	when count(order_id) > 30 then 'High Volume' 
	when count(order_id) between 15 and 30 then 'Medium Volume' 
	else'Low Volume' 
end as employee_category 
from orders 
where year(order_date) between 1997 and 1998 
group by employee_id, order_year 
having count(order_id) > 10;











