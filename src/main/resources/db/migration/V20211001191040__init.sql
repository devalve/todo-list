create table todo.user
(
    id          integer primary key,
    nickname    varchar(20) not null,
    last_online_at timestamptz default now()
);
create table todo.task
(
    id         integer primary key,
    title      varchar not null,
    text       varchar,
    created_at timestamptz default now(),
    author_id integer references "todo".user(id)
)
