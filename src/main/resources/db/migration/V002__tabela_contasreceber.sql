create table contasreceber(
id bigint not null primary key auto_increment,
dataconta date,
idcliente int not null,
valorconta decimal(12,2)
);

insert into contasreceber(dataconta, idcliente, valorconta) values ('2018/02/10', 1, '200.00');
insert into contasreceber(dataconta, idcliente, valorconta) values ('2019/03/11', 2, '300.00');
insert into contasreceber(dataconta, idcliente, valorconta) values ('2020/04/12', 3, '100.00');

