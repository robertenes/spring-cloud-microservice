CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use springcloud;



CREATE TABLE customers(
                          id text PRIMARY KEY,
                          first_name text,
                          last_name text,
                          customer_number text,
                          phone_number text,
                          created_at date,
                          is_active boolean
);
