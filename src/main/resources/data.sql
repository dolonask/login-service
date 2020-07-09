insert into roles(name, active) values('Супер Администратор', true);
insert into roles(name, active) values('Администратор', true);
insert into roles(name, active) values('Оператор', true);
insert into roles(name, active) values('Курьер', true);

insert into accounts(login, password, active) values ('sa','5f4dcc3b5aa765d61d8327deb882cf99', true);

insert into users(name,account_id, role_id, active) values('Супер Админ', 1, 1, true);
