CREATE EXTENSION IF NOT EXISTS pg_trgm SCHEMA data_flow; CREATE EXTENSION btree_gin;
SET search_path TO data_flow;
CREATE INDEX employees_last_name_first_name_idx ON employee USING gin(first_name, last_name);
CREATE INDEX employee_phone_passport_idx ON employee (phone, passport);
CREATE INDEX employee_create_date_idx ON employee (create_date);
CREATE INDEX employees_first_name_idx ON employee USING gin(LOWER(first_name) gin_trgm_ops);
CREATE INDEX employees_last_name_idx ON employee USING gin(LOWER(last_name) gin_trgm_ops);