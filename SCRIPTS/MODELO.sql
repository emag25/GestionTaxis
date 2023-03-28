
CREATE TABLE CUENTABANCARIA
    ( numerotarjeta      VARCHAR2(16)  
       CONSTRAINT  numerotarjeta NOT NULL 
    , fechavencimiento    date 
    , cedulatitular    VARCHAR2(10) 
    , cvv    VARCHAR2(4) 
    , CONSTRAINT numerotarjeta_pk
                 PRIMARY KEY (numerotarjeta)
    ) ;
    
    
CREATE TABLE PASAJERO
    ( cedulapasajero      VARCHAR2(10) 
       CONSTRAINT  cedulapasajero NOT NULL 
    , nombrepasajero    VARCHAR2(60) 
    , direccion    VARCHAR2(100) 
    , telefono    VARCHAR2(10) 
    , contrasena    VARCHAR2(15) 
    , correo    VARCHAR2(60) 
    , numerotarjeta   VARCHAR2(16) 
    , CONSTRAINT cedulapasajero_pk
                 PRIMARY KEY (cedulapasajero)
    , CONSTRAINT numerotarjeta_fk
                 FOREIGN KEY (numerotarjeta)
                 REFERENCES CUENTABANCARIA(numerotarjeta) 
    ) ;
    
    
    
CREATE TABLE COOPERATIVA
    ( ruc      VARCHAR2(13) 
       CONSTRAINT  ruc NOT NULL 
    , nombrecooperativa    VARCHAR2(60) 
    , politica    float 
    , numerotarjeta VARCHAR(16)
    , CONSTRAINT ruc_pk
                 PRIMARY KEY (ruc) 
    , CONSTRAINT numerotarjetaa_fk
                 FOREIGN KEY (numerotarjeta)
                 REFERENCES CUENTABANCARIA(numerotarjeta) 
    ) ;    
    
    
    
CREATE TABLE CONDUCTOR
    ( cedulaconductor      VARCHAR2(10) 
       CONSTRAINT  cedulaconductor NOT NULL 
    , nombreconductor    VARCHAR2(60) 
    , telefono    VARCHAR2(10) 
    , rucempresa   VARCHAR2(12) 
    , CONSTRAINT cedulaconductor_pk
                 PRIMARY KEY (cedulaconductor)
    , CONSTRAINT ruc_fk
                 FOREIGN KEY (rucempresa)
                 REFERENCES COOPERATIVA(ruc) 
    ) ;
    
    
CREATE TABLE VEHICULO
    ( placa      VARCHAR2(8) 
       CONSTRAINT  placa NOT NULL 
    , modelo    VARCHAR2(60) 
    , marca    VARCHAR2(60) 
    , color    VARCHAR2(60)
    , rucempresa  VARCHAR2(12) 
    , CONSTRAINT placa_pk
                 PRIMARY KEY (placa)
    , CONSTRAINT rucv_fk
                 FOREIGN KEY (rucempresa)
                 REFERENCES COOPERATIVA(ruc) 
    ) ;
    
    
    
CREATE TABLE RESERVA    
    ( idreserva      NUMBER
       CONSTRAINT  idreserva NOT NULL 
    , acompanantes    NUMBER
    , origen    VARCHAR2(60) 
    , destino    VARCHAR2(60)
    , fechahora    TIMESTAMP
    , totalpasajeros    NUMBER
    , tarifaviaje    float
    , calificacion   NUMBER
    , comentario     VARCHAR2(100)
    , cedulapasajero  VARCHAR2(10)
    , ruc      VARCHAR2(13) 
    , cedulaconductor   VARCHAR2(10) 
    , placa    VARCHAR2(8)
    , CONSTRAINT idreserva_pk
                 PRIMARY KEY (idreserva)
    , CONSTRAINT cedulapasajero_fk
                 FOREIGN KEY (cedulapasajero)
                 REFERENCES PASAJERO(cedulapasajero) 
    , CONSTRAINT rucr_fk
                 FOREIGN KEY (ruc)
                 REFERENCES COOPERATIVA(ruc) 
   , CONSTRAINT cedulaconductor_fk
                 FOREIGN KEY (cedulaconductor)
                 REFERENCES CONDUCTOR(cedulaconductor)
   , CONSTRAINT placa_fk
                 FOREIGN KEY (placa)
                 REFERENCES VEHICULO(placa) 
    ) ;
    
    
CREATE TABLE FACTURA    
    ( idfactura      NUMBER 
       CONSTRAINT  idfactura NOT NULL 
    , valorporpersona    FLOAT
    , valorapagar    FLOAT
    , idreserva    number
    , cedulapasajero  VARCHAR2(10)
    , CONSTRAINT idfactura_pk
                 PRIMARY KEY (idfactura)
    , CONSTRAINT idreserva_fk
                 FOREIGN KEY (idreserva)
                 REFERENCES RESERVA(idreserva) 
    , CONSTRAINT cedulapasajeroo_fk
                 FOREIGN KEY (cedulapasajero)
                 REFERENCES PASAJERO(cedulapasajero) 
    ) ;
