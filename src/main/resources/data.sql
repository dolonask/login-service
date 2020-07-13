insert into roles(name, active) values('Супер Администратор', true);
insert into roles(name, active) values('Администратор', true);
insert into roles(name, active) values('Оператор', true);
insert into roles(name, active) values('Курьер', true);

insert into accounts(login, password) values ('sa','f7178b591adc48af2fedc9ab364ff2b5');

insert into users(name,account_id, role_id, active) values('Супер Админ', 1, 1, true);
