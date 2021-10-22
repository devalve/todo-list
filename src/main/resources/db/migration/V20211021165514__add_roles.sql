create table todo.role
(
    id   int primary key,
    code varchar not null
);

insert into todo.role
values (1, 'admin'),
       (2, 'user');

create table todo.user_role
(
    id      serial primary key,
    user_id int not null
        references todo.user (id),
    role_id int not null
        references todo.role (id)
);
