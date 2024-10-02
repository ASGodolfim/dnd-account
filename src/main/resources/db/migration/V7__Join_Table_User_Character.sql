SELECT CONCAT(employee.firstName, ' ', employee.lastName) AS fullName
       , employeeID
       , sales
FROM employee i
INNER JOIN Sales s
   ON s.customerID = i.CustomerID