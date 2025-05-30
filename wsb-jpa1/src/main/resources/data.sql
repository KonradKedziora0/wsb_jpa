--Address
            INSERT INTO address (id, address_line1, address_line2, city, postal_code)
            VALUES (901, 'Słoneczna', 'yy', 'Poznań', '60-400');

            INSERT INTO address (id, address_line1, address_line2, city, postal_code)
            VALUES (921, 'Słoneczna', '12', 'Poznań', '60-400');

            INSERT INTO address (id, address_line1, address_line2, city, postal_code)
            VALUES (1002, 'Kolorowa', '5/10', 'Warszawa', '00-001');

            INSERT INTO address (id, address_line1, address_line2, city, postal_code)
            VALUES (1103, 'Leśna', NULL, 'Kraków', '30-050');

            INSERT INTO address (id, address_line1, address_line2, city, postal_code)
            VALUES (1143, 'Morska', '15A', 'Gdańsk', '80-001');

            INSERT INTO address (id, address_line1, address_line2, city, postal_code)
            VALUES (1186, 'Szkolna', '17', 'Białystok', '15-640');

--Doctor
            INSERT INTO doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            VALUES (1, 901, 'DOC001', 'jan.kowalski@clinic.pl', 'Jan', 'Kowalski', '123456789', 'SURGEON');

            INSERT INTO doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            VALUES (2, 921, 'DOC002', 'anna.nowak@clinic.pl', 'Anna', 'Nowak', '987654321', 'DERMATOLOGIST');

            INSERT INTO doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            VALUES (3, 1143, 'DOC003', 'piotr.wisniewski@clinic.pl', 'Piotr', 'Wiśniewski', '555666777', 'GP');

            INSERT INTO doctor (id, address_id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            VALUES (4, 1103, 'DOC004', 'katarzyna.wojcik@clinic.pl', 'Katarzyna', 'Wójcik', '111222333', 'OCULIST');

--Patient
            INSERT INTO patient (id, version, pesel, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            VALUES (1, 0, 123123123, 'Marek', 'Nowak', '111222333', 'marek.nowak@email.com', 'PAT001', '1985-05-15', 1186);

            INSERT INTO patient (id, version, pesel, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            VALUES (6, 0, 7524352346, 'Adam', 'Hovacic', '111234353', 'adam.hovacic@email.com', 'PAT006', '1999-02-15', 1103);

            INSERT INTO patient (id, version, pesel, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            VALUES (2, 0, 0012345890, 'Agnieszka', 'Kowalska', '444555666', 'agnieszka.kowalska@email.com', 'PAT002', '1990-08-22', 1186);

            INSERT INTO patient (id, version, pesel, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            VALUES (3, 0, 84234892409, 'Tomasz', 'Wiśniewski', '777888999', 'tomasz.wisniewski@email.com', 'PAT003', '1978-11-03', 1002);

            INSERT INTO patient (id, version, pesel, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            VALUES (4, 0, 99853426234, 'Karolina', 'Wójcik', '222333444', 'karolina.wojcik@email.com', 'PAT004', '1995-02-28', 1143);

--Visit
            INSERT INTO visit (doctor_id, patient_id, id, time, description)
            VALUES (1, 3, 1, '2025-02-28 12:35:00', 'test');

            INSERT INTO visit (doctor_id, patient_id, id, time, description)
            VALUES (1, 4, 3, '2025-03-01 09:00:00', 'Lorem ipsum');

            INSERT INTO visit (doctor_id, patient_id, id, time, description)
            VALUES (2, 2, 6, '2025-03-05 11:30:00', 'Badanie okresowe');

            INSERT INTO visit (doctor_id, patient_id, id, time, description)
            VALUES (4, 1, 9, '2025-03-10 14:15:00', 'Szczepienie');

            INSERT INTO visit (doctor_id, patient_id, id, time, description)
            VALUES (4, 1, 15, '2025-03-15 16:45:00', 'Wizyta diagnostyczna');

            INSERT INTO visit (doctor_id, patient_id, id, time, description)
            VALUES (3, 3, 16, '2025-03-20 10:00:00', 'Konsultacja wyników badań');

--Medical treatment
            INSERT INTO medical_treatment (id, visit_id, description, type)
            VALUES (2, 1, 'Test descritpiona', 'EKG');

            INSERT INTO medical_treatment (id, visit_id, description, type)
            VALUES (5, 3, 'Test descritpiona', 'USG');

            INSERT INTO medical_treatment (id, visit_id, description, type)
            VALUES (6, 3, 'Test descritpiona', 'RTG');
