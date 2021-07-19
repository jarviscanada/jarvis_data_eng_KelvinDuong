-- switch to host agent
\c host_agent;

-- hardwarde usage specs table
CREATE TABLE IF NOT EXISTS host_usage
    (
        "timestamp"     TIMESTAMP NOT NULL PRIMARY KEY,
        host_id         INTEGER NOT NULL,
        memory_free     INTEGER NOT NULL,
        cpu_idle        INTEGER NOT NULL,
        cpu_kernel      INTEGER NOT NULL,
        disk_io         INTEGER NOT NULL,
        disk_available  INTEGER NOT NULL
    );

-- hardware info table
CREATE TABLE IF NOT EXISTS host_info
    (
        id                  SERIAL NOT NULL PRIMARY KEY,
        hostname            VARCHAR NOT NULL,
        cpu_number          INTEGER NOT NULL,
        cpu_architecture    VARCHAR NOT NULL,
        cpu_model           VARCHAR NOT NULL,
        cpu_mhz             REAL NOT NULL,
        L2_cache            INTEGER NOT NULL,
        total_mem           INTEGER NOT NULL,
        "timestamp"         TIMESTAMP NOT NULL
    );