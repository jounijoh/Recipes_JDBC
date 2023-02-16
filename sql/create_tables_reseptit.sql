CREATE TABLE resepti(
id integer,
nimi varchar (30) not null,
kuvaus varchar(100) not null,
ainekset varchar(300) not null,
valmistusaika varchar(40) not null,
ohjeet varchar(500),
PRIMARY KEY (id)
);

