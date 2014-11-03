--DROP TABLE app.event;
--DROP TABLE app.customer;
--DROP TABLE app.participant;

CREATE TABLE app.customer (
    customer_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    customer_email varchar(254) NOT NULL UNIQUE,
    customer_password varchar(100),
    customer_firstname varchar(50) NOT NULL,
    customer_lastname varchar(50),
    customer_company varchar(50)
);

CREATE TABLE app.event (
    event_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    event_name varchar(50) NOT NULL,
    event_location varchar(50) NOT NULL,
    event_start_datetime timestamp NOT NULL,
    event_end_datetime timestamp NOT NULL,
    event_creator_id int NOT NULL
);

CREATE TABLE app.participant (
    participant_event_id INT NOT NULL,
    participant_customer_id INT NOT NULL,
    CONSTRAINT fk_participant_event FOREIGN KEY (participant_event_id) REFERENCES app.event(event_id),
    CONSTRAINT fk_participant_customer FOREIGN KEY (participant_customer_id) REFERENCES app.customer(customer_id),
    CONSTRAINT participant_id PRIMARY KEY (participant_event_id, participant_customer_id)
);

--ALTER TABLE app.event
--ADD CONSTRAINT fk_event_creator FOREIGN KEY (event_creator_id) REFERENCES app.customer(customer_id);
