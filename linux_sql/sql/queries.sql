-- Helper function
CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
$$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;

-- Group hosts by hardware info
-- (Group by cpu number and order by total memory)
SELECT cpu_number,
       id AS host_id,
       total_mem
FROM host_info
ORDER BY cpu_number,
         total_mem DESC;

-- Average memory usage
-- (Average memory used for each host over a five minute interval)
SELECT id AS host_id,
       hostname AS host_name,
       round5(hu.timestamp) AS timestamp,
       -- Have to cast otherwise you will get a zero. Total_mem is in KB so divide by 1000 as well
       AVG((((total_mem::float)/1000 - memory_free::float) / (total_mem::float/1000)) * 100):: int AS avg_used_mem_percentage
FROM
    host_info AS hi
    INNER JOIN host_usage AS hu ON hi.id = hu.host_id
GROUP BY
    round5(hu.timestamp),
    id,
    hostname
ORDER BY
    round5(hu.timestamp);

-- Detect host failure
-- (Server failed when it inserts less than three data points within a five minute interval)
SELECT
    host_id,
    round5(timestamp) AS tstamp,
    COUNT(*) AS num_data_points
FROM
    host_usage
GROUP BY
    tstamp,
    host_id
HAVING
    COUNT(*) < 3
ORDER BY
    host_id,
    tstamp;
