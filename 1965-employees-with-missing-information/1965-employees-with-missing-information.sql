# Write your MySQL query statement below
SELECT employee_id
FROM Employees NATURAL RIGHT JOIN Salaries
WHERE name IS NULL
UNION
SELECT employee_id
FROM Employees NATURAL LEFT JOIN Salaries
WHERE salary IS NULL
ORDER BY employee_id;
