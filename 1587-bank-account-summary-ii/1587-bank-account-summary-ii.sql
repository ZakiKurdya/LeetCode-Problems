# Write your MySQL query statement below
select name,sum(amount) as balance
from users u, transactions t
where u.account = t.account 
group by(t.account)
having balance>10000