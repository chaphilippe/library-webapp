insert into student (student_id, firstname, lastname, age, sex, origin, department) values (1, 'John', 'Smith', '18', 'f', 'eth', 'dep');

insert into library_user (user_id, email, password, fullname, role) values (1, 'nmo@zuhlke.com', 'pwd', 'Neil M', 'ADMINISTRATOR');
insert into library_user (user_id, email, password, fullname, role) values (2, 'zab@zuhlke.com', 'pwd', 'Zaphod B', 'USER');
insert into library_user (user_id, email, password, fullname, role) values (3, 'fpr@zuhlke.com', 'pwd', 'Ford P', 'USER');

insert into hibernate_sequences (sequence_name, next_val) values ('book', 101);
insert into hibernate_sequences (sequence_name, next_val) values ('user', 101);

