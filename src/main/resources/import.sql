INSERT INTO roles (id, name) VALUES (1, "ROLE_ADMIN")
INSERT INTO roles (id, name) VALUES (2, "ROLE_PROFESOR")
INSERT INTO roles (id, name) VALUES (3, "ROLE_ESTUDIANTE")

INSERT INTO users (email,enabled,name,password) VALUES ("example@example.com", true, "Example", "$2a$10$bv91.Vzn/oQCv1LgH2Rtx.Cyb.YiwWC6c1ZXTU/00RqKKeznb.uya")
INSERT INTO users_roles (user_id,role_id) VALUES (1,1)
INSERT INTO professors (specialty,user_id) VALUES ("Logica",1)

INSERT INTO courses (academic_year,name) VALUES ('2025', 'Big Data');

INSERT INTO users (email,enabled,name,password) values ("example2@example.com",true,"Example 2","$2a$10$cCA0qjVyv.6UVGhdoPxpa.lrdv4NgIWAeHUm1iFjO61.rALf98yuq")
INSERT INTO users_roles (user_id,role_id) values (3, 1)
INSERT INTO students (course_actual_id,user_id) values (1,2)