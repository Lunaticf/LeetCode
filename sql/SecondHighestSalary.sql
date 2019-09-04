# Write your MySQL query statement below

# 这样是有问题的 如果表中只有一条记录将返回空而不是NULL
select Salary as SecondHighestSalary from Employee
order by Salary desc
limit 1, 1;

select IFNULL((select distinct Salary from Employee order by Salary desc limit 1, 1),
    null) as SecondHighestSalary

# 另一种解法 也挺有意思的
SELECT max(Salary)
FROM Employee
WHERE Salary < (SELECT max(Salary) FROM Employee)

