-- Show table schema 
\d+ retail;

-- Show first 10 rows
SELECT * FROM retail LIMIT 10;

-- Check # of records
SELECT count(*) FROM retail;

-- Number of clients (e.g. unique client ID)
SELECT COUNT(DISTINCT customer_id) FROM retail;

-- Invoice data range
SELECT MAX(invoice_date), MIN(invoice_date) FROM retail;

-- Number of SKU/merchants
SELECT COUNT(DISTINCT stock_code) FROM retail;

-- Average invoice amount
SELECT AVG(sub.total) FROM (SELECT SUM(quantity * unit_price) AS total FROM retail GROUP BY invoice_no) AS sub WHERE sub.total > 0;

-- Total revenue
SELECT SUM(quantity * unit_price) AS total FROM retail;

-- Total revenue by YYYYMM
SELECT (CAST(EXTRACT(YEAR FROM invoice_date) AS Integer) *100 + CAST(EXTRACT(MONTH FROM invoice_date) AS Integer)) AS yyyymm, SUM(quantity * unit_price) FROM retail GROUP BY yyyymm ORDER BY yyyymm ASC;

