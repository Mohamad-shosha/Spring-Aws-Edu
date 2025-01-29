-- Changeset for creating address table
CREATE DATABASE IF NOT exists instructor_directory;
USE instructor_directory;

CREATE TABLE address (
    address_id CHAR(36) PRIMARY KEY,
    street_address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100)
);

-- Changeset for creating course table
CREATE TABLE course (
    course_id CHAR(36) PRIMARY KEY,
    course_name VARCHAR(255),
    course_code VARCHAR(20),
    description TEXT
);

-- Changeset for creating instructor table
CREATE TABLE instructor (
    instructor_id CHAR(36) PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    email VARCHAR(255),
    address_id CHAR(36),
    course_id CHAR(36),
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

-- Inserting data into address table
INSERT INTO address (address_id, street_address, city, state, postal_code, country)
VALUES 
('71a92973-b317-4230-a409-bc9f61fbb658', 'Street 1', 'Cairo', 'Giza', '999123', 'Egypt'),
('a6c8d9b8-5bda-452d-8136-f3d0f47b34ae', 'Street 2', 'Alexandria', 'Alex', '110034', 'Egypt'),
('e7db4951-d139-430a-9d1c-c56b5724c3e2', 'Street 3', 'Giza', 'Dokki', '256789', 'Egypt'),
('b26a29b0-82f0-4d89-bd7b-9e34ff592365', 'Street 4', 'Mansoura', 'Daqahlia', '485736', 'Egypt'),
('573b57b9-9d2e-42e5-bfdb-b7f961cb7d29', 'Street 5', 'Cairo', 'Maadi', '172839', 'Egypt'),
('7e35b372-9bfc-4d55-aee4-f0f2a88a8dfd', 'Street 6', 'Tanta', 'Gharbia', '154673', 'Egypt'),
('998b928f-c0d3-40a0-bb7d-f684c8cb68cf', 'Street 7', 'Fayoum', 'Fayoum', '634678', 'Egypt'),
('56f9e0e0-cf18-4216-92b2-b08b93f779cc', 'Street 8', 'Port Said', 'Port Said', '153428', 'Egypt'),
('f62c1db5-d9b1-45c9-9b0a-458987ebc56e', 'Street 9', 'Aswan', 'Aswan', '564879', 'Egypt'),
('a3f26199-1f1a-4750-bb56-c13d80f651b8', 'Street 10', 'Luxor', 'Luxor', '465827', 'Egypt');

-- Inserting data into course table
INSERT INTO course (course_id, course_name, course_code, description)
VALUES 
('b42c88a5-53ff-4091-b10b-11ccf29e6d0b', 'Java Development', '123456789', 'Java course for beginners'),
('c83a58b7-9b4c-4f34-9bb6-23a73bce2e5d', 'Spring Boot Mastery', '987654321', 'Advanced Spring Boot course for professionals'),
('f7c1c6c9-e7b4-48fe-9a9f-2e8b8ff1e9ac', 'Docker and Kubernetes', '456123789', 'Learn Docker and Kubernetes'),
('d6296b6a-31c3-44a2-99c0-0f612f872d87', 'Data Structures and Algorithms', '781234567', 'In-depth study of data structures and algorithms'),
('3f63f1a5-569b-49f7-b2ab-b5ab4cbac315', 'Database Design and Management', '647258934', 'Master relational databases and SQL'),
('24ed5688-bd3e-4536-9f56-98deef8b84da', 'Cloud Computing with AWS', '342987546', 'Learn cloud computing with AWS'),
('f82763f2-8da5-45c7-a8f3-5ac6d36fcaf5', 'Full Stack Web Development', '516489302', 'Complete course on full-stack web development'),
('58f30c47-8f24-4e2e-95d2-9b8d82e9beff', 'Machine Learning with Python', '784123659', 'Introductory course on machine learning with Python'),
('b25f14ab-52ed-4f96-b35c-bb43b238773d', 'DevOps with Docker', '873659123', 'Master DevOps with Docker tools and workflows'),
('dff60d0d-ea61-471d-9027-b99cdb9e3fbc', 'Agile Project Management', '123987654', 'Learn the principles of Agile and Scrum for project management');

-- Inserting data into instructor table
INSERT INTO instructor (instructor_id, first_name, last_name, date_of_birth, email, address_id, course_id)
VALUES 
('3d85a2f5-78cd-4676-8cbb-c1f167af5f61', 'John', 'Doe', '1985-02-20', 'john.doe@example.com', '71a92973-b317-4230-a409-bc9f61fbb658', 'b42c88a5-53ff-4091-b10b-11ccf29e6d0b'),
('e5b71fbf-3e9d-423b-96d1-e72834e6b8f1', 'Jane', 'Smith', '1990-11-14', 'jane.smith@example.com', 'a6c8d9b8-5bda-452d-8136-f3d0f47b34ae', 'c83a58b7-9b4c-4f34-9bb6-23a73bce2e5d'),
('0b8dbd99-b460-4e89-9d58-22292be455ef', 'Mark', 'Johnson', '1987-04-10', 'mark.johnson@example.com', 'e7db4951-d139-430a-9d1c-c56b5724c3e2', 'f7c1c6c9-e7b4-48fe-9a9f-2e8b8ff1e9ac'),
('8f7d5c61-72c9-46ae-9e5d-10b209bfe53e', 'Emily', 'Davis', '1992-01-01', 'emily.davis@example.com', 'b26a29b0-82f0-4d89-bd7b-9e34ff592365', 'd6296b6a-31c3-44a2-99c0-0f612f872d87'),
('ec76939e-837b-4f13-8619-7316d4d90943', 'David', 'Martinez', '1989-09-05', 'david.martinez@example.com', '573b57b9-9d2e-42e5-bfdb-b7f961cb7d29', '3f63f1a5-569b-49f7-b2ab-b5ab4cbac315'),
('a9f0be3a-bbcf-4a3a-951d-859982c5a30f', 'Sophia', 'Lee', '1991-07-30', 'sophia.lee@example.com', '7e35b372-9bfc-4d55-aee4-f0f2a88a8dfd', '24ed5688-bd3e-4536-9f56-98deef8b84da'),
('612b7a36-9084-4a42-b622-e76399068d91', 'Michael', 'Brown', '1986-03-25', 'michael.brown@example.com', '998b928f-c0d3-40a0-bb7d-f684c8cb68cf', 'f82763f2-8da5-45c7-a8f3-5ac6d36fcaf5'),
('ed5a24d4-c60d-4cb3-97f7-9184b7a95db4', 'Isabella', 'Garcia', '1993-12-10', 'isabella.garcia@example.com', '56f9e0e0-cf18-4216-92b2-b08b93f779cc', '58f30c47-8f24-4e2e-95d2-9b8d82e9beff'),
('f3d16072-c605-4e7e-a0c0-8a3ebd876982', 'Joshua', 'Martinez', '1987-06-20', 'joshua.martinez@example.com', 'f62c1db5-d9b1-45c9-9b0a-458987ebc56e', 'b25f14ab-52ed-4f96-b35c-bb43b238773d'),
('2448ff32-b8ac-4097-80f9-cac78d9b53fd', 'Olivia', 'Hernandez', '1990-05-09', 'olivia.hernandez@example.com', 'a3f26199-1f1a-4750-bb56-c13d80f651b8', 'dff60d0d-ea61-471d-9027-b99cdb9e3fbc'),
('d29dbb5a-8bb7-4661-b5f7-465f08c0e118', 'Daniel', 'Miller', '1984-11-16', 'daniel.miller@example.com', 'a6c8d9b8-5bda-452d-8136-f3d0f47b34ae', 'b42c88a5-53ff-4091-b10b-11ccf29e6d0b'),
('e512cb55-5da6-4dbb-9e5a-8f72cdaabdf4', 'Charlotte', 'Wilson', '1995-05-28', 'charlotte.wilson@example.com', '998b928f-c0d3-40a0-bb7d-f684c8cb68cf', 'f7c1c6c9-e7b4-48fe-9a9f-2e8b8ff1e9ac'),
('7345e4f4-278a-47bc-88f9-d022a7c4c1c0', 'Sebastian', 'Moore', '1987-02-19', 'sebastian.moore@example.com', '56f9e0e0-cf18-4216-92b2-b08b93f779cc', 'd6296b6a-31c3-44a2-99c0-0f612f872d87'),
('f7beadf5-139d-48f1-b781-f9827b4667ba', 'Mia', 'Taylor', '1992-07-07', 'mia.taylor@example.com', 'b26a29b0-82f0-4d89-bd7b-9e34ff592365', 'b25f14ab-52ed-4f96-b35c-bb43b238773d'),
('02fa9283-d2a1-473b-b5b8-b6d0881de57c', 'William', 'Anderson', '1980-09-25', 'william.anderson@example.com', '7e35b372-9bfc-4d55-aee4-f0f2a88a8dfd', 'dff60d0d-ea61-471d-9027-b99cdb9e3fbc'),
('5d3fa3d2-90ac-490d-8282-c5f7ec34a8f6', 'Amelia', 'Thomas', '1994-03-18', 'amelia.thomas@example.com', 'f62c1db5-d9b1-45c9-9b0a-458987ebc56e', '3f63f1a5-569b-49f7-b2ab-b5ab4cbac315'),
('9273e7e4-99be-49f2-9ed8-5b3ad9466a60', 'Liam', 'Jackson', '1991-08-12', 'liam.jackson@example.com', '573b57b9-9d2e-42e5-bfdb-b7f961cb7d29', '24ed5688-bd3e-4536-9f56-98deef8b84da');
