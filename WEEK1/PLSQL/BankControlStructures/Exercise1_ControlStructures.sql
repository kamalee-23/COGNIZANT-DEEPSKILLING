SET SERVEROUTPUT ON;

CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    date_of_birth DATE,
    balance NUMBER(12,2),
    is_vip CHAR(1) DEFAULT 'N',
    email VARCHAR2(100)
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    loan_amount NUMBER(12,2),
    interest_rate NUMBER(5,2),
    loan_due_date DATE,
    loan_status VARCHAR2(20),
    CONSTRAINT fk_customer
    FOREIGN KEY(customer_id)
    REFERENCES customers(customer_id)
);

INSERT INTO customers VALUES
(1,'Robert Brown',DATE '1955-04-12',15000,'N','robert@gmail.com');

INSERT INTO customers VALUES
(2,'Sophia Wilson',DATE '1988-06-20',8500,'N','sophia@gmail.com');

INSERT INTO customers VALUES
(3,'Daniel Clark',DATE '1959-11-08',22000,'N','daniel@gmail.com');

INSERT INTO customers VALUES
(4,'Mia Davis',DATE '1995-02-15',12000,'N','mia@gmail.com');

INSERT INTO customers VALUES
(5,'Henry Walker',DATE '1948-09-25',6000,'N','henry@gmail.com');

INSERT INTO loans VALUES
(101,1,50000,7.5,SYSDATE+15,'ACTIVE');

INSERT INTO loans VALUES
(102,2,30000,8.0,SYSDATE+40,'ACTIVE');

INSERT INTO loans VALUES
(103,3,45000,6.8,SYSDATE+20,'ACTIVE');

INSERT INTO loans VALUES
(104,4,25000,7.2,SYSDATE+10,'ACTIVE');

INSERT INTO loans VALUES
(105,5,15000,8.5,SYSDATE+5,'ACTIVE');

COMMIT;

DECLARE

    v_age NUMBER;

BEGIN

    FOR c IN
    (
        SELECT customer_id,
               customer_name,
               date_of_birth
        FROM customers
    )
    LOOP

        v_age :=
        FLOOR(
        MONTHS_BETWEEN(
        SYSDATE,
        c.date_of_birth)/12);

        IF v_age > 60 THEN

            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE customer_id = c.customer_id;

            DBMS_OUTPUT.PUT_LINE(
            'Discount Applied : '
            || c.customer_name);

        END IF;

    END LOOP;

    COMMIT;

END;
/

DECLARE

    vip_count NUMBER := 0;

BEGIN

    FOR c IN (
        SELECT customer_id,
               customer_name,
               balance
        FROM customers
    )
    LOOP

        IF c.balance > 10000 THEN

            UPDATE customers
            SET is_vip = 'Y'
            WHERE customer_id =
                  c.customer_id;

            vip_count := vip_count + 1;

            DBMS_OUTPUT.PUT_LINE(
            c.customer_name ||
            ' promoted to VIP');

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
    'VIP Count = '
    || vip_count);

END;
/

BEGIN

    DBMS_OUTPUT.PUT_LINE(
    'Upcoming Loan Reminders');

    FOR rec IN
    (
        SELECT c.customer_name,
               l.loan_id,
               l.loan_due_date
        FROM customers c
        JOIN loans l
        ON c.customer_id =
           l.customer_id
        WHERE l.loan_due_date
              BETWEEN SYSDATE
              AND SYSDATE + 30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
        'Customer: '
        || rec.customer_name
        || ' Loan ID: '
        || rec.loan_id
        || ' Due Date: '
        || TO_CHAR(
             rec.loan_due_date,
             'DD-MON-YYYY'));

    END LOOP;

END;
/

SELECT * FROM customers;

SELECT * FROM loans;