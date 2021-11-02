create table todo.user
(
    id             serial primary key,
    nickname       varchar(20) unique not null,
    last_online_at timestamptz default now()
);
create table todo.task
(
    id         serial primary key,
    title      varchar not null,
    text       varchar,
    created_at timestamptz default now(),
    author_id integer references todo.user(id)
)
