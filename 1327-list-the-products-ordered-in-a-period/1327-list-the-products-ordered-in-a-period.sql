# Write your MySQL query statement below
SELECT P.product_name AS product_name, SUM(O.unit) AS unit 
FROM Products P INNER JOIN Orders O
ON P.product_id = O.product_id
WHERE YEAR(O.order_date) = 2020 AND MONTH(O.order_date) = 2
GROUP BY P.product_id
HAVING SUM(O.unit) >= 100;
