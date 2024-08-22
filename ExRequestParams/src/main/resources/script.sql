INSERT INTO requestparams."order" (order_number, customer_name, status, total_amount, order_date) VALUES
('ORD001', 'John Doe', 'Pending', 150.00, '2023-01-15'),
('ORD002', 'Jane Smith', 'Completed', 250.00, '2023-02-20'),
('ORD003', 'Alice Johnson', 'Shipped', 300.00, '2023-03-10'),
('ORD004', 'Bob Brown', 'Pending', 175.00, '2023-04-12'),
('ORD005', 'Charlie Davis', 'Completed', 225.00, '2023-05-18'),
('ORD006', 'Diana Evans', 'Shipped', 275.00, '2023-06-22'),
('ORD007', 'Eve Foster', 'Pending', 325.00, '2023-07-30'),
('ORD008', 'Frank Green', 'Completed', 375.00, '2023-08-05'),
('ORD009', 'Grace Harris', 'Shipped', 425.00, '2023-09-10'),
('ORD010', 'Hank Irving', 'Pending', 475.00, '2023-10-15');

INSERT INTO requestparams.employee (first_name, last_name, position, salary, hire_date, department, active) VALUES
('John', 'Doe', 'Developer', 60000.00, '2020-01-15', 'IT', true),
('Jane', 'Smith', 'Manager', 80000.00, '2019-02-20', 'HR', true),
('Alice', 'Johnson', 'Analyst', 50000.00, '2021-03-10', 'Finance', false),
('Bob', 'Brown', 'Developer', 65000.00, '2020-04-12', 'IT', true),
('Charlie', 'Davis', 'Manager', 85000.00, '2019-05-18', 'HR', true),
('Diana', 'Evans', 'Analyst', 55000.00, '2021-06-22', 'Finance', false),
('Eve', 'Foster', 'Developer', 70000.00, '2020-07-30', 'IT', true),
('Frank', 'Green', 'Manager', 90000.00, '2019-08-05', 'HR', true),
('Grace', 'Harris', 'Analyst', 60000.00, '2021-09-10', 'Finance', false),
('Hank', 'Irving', 'Developer', 75000.00, '2020-10-15', 'IT', true);