create database demo;

create user flyway identified by 'welcome';
create user demo identified by 'welcome';

grant all privileges on demo.* to flyway;
grant all privileges on demo.* to demo;
