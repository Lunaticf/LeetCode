-- select p.FirstName, p.LastName, a.City, a.State from Person p
-- left join Address a
-- on p.PersonId = a.PersonId;

select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;

-- since those selected columns are unique among two tables, the table prefix can be omitted from your solution: