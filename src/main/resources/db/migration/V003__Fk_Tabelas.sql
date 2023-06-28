alter table contasreceber add constraint
fk_contasreceber_cliente foreign key(idcliente)
references cliente(id);