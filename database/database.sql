CREATE DATABASE IF NOT EXISTS Tasks;
USE Tasks;


/*Caso o hibernate não gere as tabelas, utilizar o script abaixo*/

create table public.profile(
id int8 not null,
fullName varchar(255),
CONSTRAINT profile_pkey PRIMARY KEY (id)
);

create table public.task(
id int8 not null,
title varchar(255),
description varchar(255),
priority varchar(255),
status boolean,
deadline date,
profile_id int8,
CONSTRAINT task_pkey PRIMARY KEY (id),
constraint profile_fkey FOREIGN KEY (profile_id)
REFERENCES public.profile(id)
);