--DROP TABLE event;
--DROP TABLE customer;
--DROP TABLE participant;

CREATE TABLE event (
    event_id varchar(32) NOT NULL PRIMARY KEY,
    event_name varchar(50) NOT NULL,
    event_location varchar(50) NOT NULL,
    event_start_datetime bigint NOT NULL,
    event_end_datetime bigint NOT NULL,
    event_creator bigint NOT NULL
);

CREATE TABLE customer (
    customer_id bigint NOT NULL PRIMARY KEY,
    customer_email varchar(254) NOT NULL UNIQUE,
    customer_password varchar(100),
    customer_firstname varchar(50) NOT NULL,
    customer_lastname varchar(50),
    customer_company varchar(50), 
);

CREATE TABLE participant (
    event_id varchar(32) NOT NULL,
    customer_id bigint NOT NULL,
    CONSTRAINT fk_participant_event FOREIGN KEY (event_id) REFERENCES event(event_id),
    CONSTRAINT fk_participant_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT participant_id PRIMARY KEY (event_id, customer_id)
);
