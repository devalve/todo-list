create table todo.user
(
    id          integer primary key,
    nickname    varchar(20) not null,
    last_online timestamptz default now()
);
create table todo.todo
(
    id         integer primary key,
    title      varchar not null,
    text       text,
    created_at timestamptz default now(),
    author integer references "todo".user(id)
)
