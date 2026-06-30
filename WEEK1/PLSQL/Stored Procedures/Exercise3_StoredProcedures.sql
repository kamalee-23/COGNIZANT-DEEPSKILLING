CREATE TABLE customers
(
    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(60),
    balance NUMBER(12,2),
    account_type VARCHAR2(20)
);

CREATE TABLE employees
(
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(60),
    department_id NUMBER,
    salary NUMBER(10,2)
);

CREATE TABLE accounts
(
    account_number NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER(12,2)
);

INSERT INTO customers VALUES (1,'Kevin Thomas',25000,'SAVINGS');
INSERT INTO customers VALUES (2,'Priya Sharma',12000,'SAVINGS');
INSERT INTO customers VALUES (3,'Rahul Menon',18000,'CURRENT');
INSERT INTO customers VALUES (4,'Ananya Roy',30000,'SAVINGS');
INSERT INTO customers VALUES (5,'Karthik Reddy',15000,'CURRENT');

COMMIT;

INSERT INTO employees VALUES (101,'Arun Kumar',10,50000);
INSERT INTO employees VALUES (102,'Neha Singh',10,45000);
INSERT INTO employees VALUES (103,'Vikram Das',20,62000);
INSERT INTO employees VALUES (104,'Pooja Nair',20,58000);

COMMIT;

INSERT INTO accounts VALUES (5001,1,15000);
INSERT INTO accounts VALUES (5002,2,9000);
INSERT INTO accounts VALUES (5003,3,12000);
INSERT INTO accounts VALUES (5004,4,8000);

COMMIT;

SELECT * FROM customers;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE customers
    SET balance = balance + (balance * 0.01)
    WHERE account_type='SAVINGS';

    DBMS_OUTPUT.PUT_LINE('Monthly Interest Applied');

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM customers;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_department NUMBER,
    p_bonus NUMBER
)
AS
BEGIN

    UPDATE employees
    SET salary = salary + (salary * p_bonus/100)
    WHERE department_id = p_department;

    COMMIT;

END;
/

BEGIN
    UpdateEmployeeBonus(10,15);
END;
/

SELECT * FROM employees;

CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT balance
    INTO v_balance
    FROM accounts
    WHERE account_number=p_from_account
    FOR UPDATE;

    IF v_balance<p_amount THEN
        RAISE_APPLICATION_ERROR(-20001,'Insufficient Balance');
    END IF;

    UPDATE accounts
    SET balance=balance-p_amount
    WHERE account_number=p_from_account;

    UPDATE accounts
    SET balance=balance+p_amount
    WHERE account_number=p_to_account;

    COMMIT;

END;
/

BEGIN
    TransferFunds(5001,5002,3000);
END;
/

SELECT * FROM accounts;