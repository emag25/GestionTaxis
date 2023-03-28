-- ELIMINA FK

alter table PASAJERO
  drop constraint numerotarjeta_fk;

alter table COOPERATIVA
  drop constraint numerotarjetaa_fk;

alter table CONDUCTOR
  drop constraint ruc_fk;

alter table VEHICULO
  drop constraint rucv_fk;

alter table RESERVA
  drop constraint cedulapasajero_fk;

alter table RESERVA
  drop constraint rucr_fk;

alter table RESERVA
  drop constraint cedulaconductor_fk;

alter table RESERVA
  drop constraint placa_fk;

alter table FACTURA    
  drop constraint idreserva_fk;

alter table FACTURA
  drop constraint cedulapasajeroo_fk;  




-- ELIMINA PK

alter table CUENTABANCARIA
  drop constraint numerotarjeta_pk;

alter table PASAJERO
  drop constraint cedulapasajero_pk;

alter table COOPERATIVA
  drop constraint ruc_pk;

alter table CONDUCTOR
  drop constraint cedulaconductor_pk;

alter table VEHICULO
  drop constraint placa_pk;

alter table RESERVA
  drop constraint idreserva_pk;

alter table FACTURA    
  drop constraint idfactura_pk;



-- ELIMINA TABLAS

drop table CUENTABANCARIA;

drop table PASAJERO;

drop table COOPERATIVA;

drop table CONDUCTOR;

drop table VEHICULO;

drop table RESERVA;

drop table FACTURA;
