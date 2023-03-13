-- Cars Section
CREATE SEQUENCE if not exists CARS_SEQUENCE_ID START WITH 1 INCREMENT BY 1;
DROP TABLE if exists cars;
create table if not exists cars (
   id BIGINT not null
  ,objectId  VARCHAR(10) NOT NULL
  ,plate      VARCHAR(9)
  ,year      INTEGER  NOT NULL
  ,make      VARCHAR(9) NOT NULL
  ,model     VARCHAR(26) NOT NULL
  ,type  VARCHAR(23) NOT NULL
  ,created_on timestamp NOT NULL
  ,PRIMARY KEY (id)
);

-- Price Section
CREATE SEQUENCE if not exists PRICES_SEQUENCE_ID START WITH 1 INCREMENT BY 1;
DROP TABLE if exists prices;
CREATE TABLE prices(
   id BIGINT not null
  ,price  DECIMAL NOT NULL DEFAULT 0.0
  ,type  VARCHAR(23) NOT NULL
  ,points     INTEGER  NOT NULL
  ,created_on timestamp NOT NULL
  ,PRIMARY KEY (id)
);

-- Price Section
CREATE SEQUENCE if not exists PRICEITEMS_SEQUENCE_ID START WITH 1 INCREMENT BY 1;
DROP TABLE if exists price_items;
CREATE TABLE price_items(
   id BIGINT not null
  ,price_id  INTEGER NOT NULL
  ,init_day  INTEGER NOT NULL
  ,end_day  INTEGER NOT NULL
  ,extra_day  INTEGER NOT NULL
  ,recharge  INTEGER NOT NULL
  ,created_on timestamp NOT NULL
  ,PRIMARY KEY (id)
);

-- Clients Section
CREATE SEQUENCE if not exists CLIENTS_SEQUENCE_ID START WITH 1 INCREMENT BY 1;
DROP TABLE if exists clients;
create table if not exists clients (
	id BIGINT not null,
	dni CHAR(10) not null,
    name CHAR(30),
    surname CHAR(30),
    gender CHAR(10) not null,
    created_on TimeStamp not null,
	PRIMARY KEY (id)
);

-- RentCar Section
CREATE SEQUENCE if not exists RENTCAR_ORDER_SEQUENCE_ID START WITH 1 INCREMENT BY 1;
DROP TABLE if exists rentcar_orders;
create table if not exists rentcar_orders (
	id BIGINT not null,
	client_dni CHAR(10) not null,
	car_plate CHAR(10) not null,
    start_date date not null,
    end_date date not null,
    return_date TimeStamp,
    price DECIMAL,
  	status CHAR(10) not null,
    created_on TimeStamp NOT NULL,
	PRIMARY KEY (id)
);

-- Client Bonus Section
CREATE SEQUENCE if not exists CLIENT_BONUS_SEQUENCE_ID START WITH 1 INCREMENT BY 1;
DROP TABLE if exists client_bonus;
create table if not exists client_bonus (
	id BIGINT not null,
	dni CHAR(10) not null,
	car_plate CHAR(10) not null,
    rentcar_id INTEGER not null,
    points INTEGER not null,
    created_on TimeStamp NOT NULL,
	PRIMARY KEY (id)
);

-- Cars Section
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ZRgPP9dBMm',2020,'Audi','Q3','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'cptB1C1NSL',2020,'Chevrolet','Malibu','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ElhqsRZDnP',2020,'Cadillac','Escalade ESV','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'LUzyWMYJpW',2020,'Chevrolet','Corvette','PREMIUN',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'rDkHakOBKP',2020,'Acura','RLX','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'1JARpJ2AUB',2020,'Chevrolet','Silverado 2500 HD Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'7G1VT2pSNO',2020,'BMW','3 Series','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'4q7L9FAU2S',2020,'Chrysler','Pacifica','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'jpOC5zs3jx',2020,'Chevrolet','Colorado Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'96llWfTOAe',2020,'BMW','X3','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'5OEvsF1R9k',2020,'Acura','TLX','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'LNq3duGh9z',2020,'Chevrolet','Silverado 3500 HD Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'FThs77Cddn',2020,'BMW','7 Series','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'t9eGFMIk7E',2020,'Ford','Fusion','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'cWQjuYWwc2',2020,'Buick','Envision','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'2lYY81jKzR',2020,'Audi','SQ5','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'qGDd5H3yYd',2020,'Audi','R8','PREMIUN',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ALbinxfzM1',2020,'Chevrolet','Traverse','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'9eRGwnViia',2020,'Acura','MDX','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'kAgBF7aSaO',2020,'INFINITI','QX80','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ygsDiv3hRm',2020,'Buick','Encore','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'92pfQo6pA4',2020,'GMC','Sierra 2500 HD Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'VfXndYon3e',2020,'Honda','Insight','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'grl6dVnzM9',2020,'Cadillac','XT6','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'QrYfmqcnAR',2020,'Cadillac','XT5','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'hSaQDQkkE0',2020,'Cadillac','XT4','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'rSQyj88Pwe',2020,'Buick','Enclave','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'kkcmfophql',2020,'Audi','Q5','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'V1F5kE5svr',2020,'Hyundai','Santa Fe','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'bW6jRQ3h2S',2020,'Ford','EcoSport','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'6YcNNwgY0C',2020,'Ford','Escape','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'dxs3ayh6Yl',2020,'Ford','Mustang','PREMIUN',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'yZUeGC1bOn',2020,'Hyundai','Sonata','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'JyMpQJbCvy',2020,'Ford','Edge','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'VT4rtTsGBj',2020,'Chevrolet','Camaro','PREMIUN',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'vRQFNeVlsa',2020,'Hyundai','Kona Electric','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'OHHuEGKsUC',2020,'Chevrolet','Equinox','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'vu2lCeXKzk',2020,'GMC','Sierra 3500 HD Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'rg8LbH5ixZ',2020,'Jeep','Gladiator','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ifEdBTIVDH',2020,'BMW','X7','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'4J2BvKonKq',2020,'Cadillac','CT6-V','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'PlNwrAm6eM',2020,'Audi','A7','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'VK6hmDAvqP',2020,'Chevrolet','Blazer','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'vidGAd8cIJ',2020,'Ford','F150 SuperCrew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'NHWgNGSFB7',2020,'Chevrolet','Suburban','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'MTvnyKqtYJ',2020,'Honda','Civic','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'wTXL9Ze5eF',2020,'Jeep','Compass','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'SCG7WEYdG1',2020,'Cadillac','Escalade','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'cKnegrw5AO',2020,'Chrysler','Voyager','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'smKxD5m9KI',2020,'Honda','Accord Hybrid','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ED6o8Zffqs',2020,'GMC','Terrain','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'2ZCPYTGxDj',2020,'Chevrolet','Spark','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'fZGBnnMx4e',2020,'GMC','Sierra 1500 Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'6qsEYBv6eW',2020,'Hyundai','NEXO','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'4lZKmYPbMk',2020,'Hyundai','Veloster','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'9BdK0PtwKc',2020,'Chevrolet','Silverado 1500 Crew Cab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'H1THLG6H1Z',2020,'Genesis','G70','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'XtDg7lwyJT',2020,'Cadillac','CT5','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'KE29kkqLX6',2020,'Honda','Odyssey','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'70EmSYGau7',2020,'Hyundai','Elantra GT','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'YZj6RLht79',2020,'Acura','RDX','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'3phIrCVLh7',2020,'GMC','Yukon XL','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'i6jT5ByjBF',2020,'Ford','Ranger SuperCab','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'RHD7qDmzgU',2020,'Ford','Expedition MAX','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'pJCLIx2r8E',2020,'Hyundai','Kona','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'8kzM0APnBF',2020,'INFINITI','QX50','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'1AV4avrH6j',2020,'Dodge','Durango','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'dow9fD3WF6',2020,'GMC','Yukon','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'adJr9Qr42Q',2020,'Hyundai','Palisade','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'F7BG83iyWo',2020,'Honda','Ridgeline','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'VMpSU5DhdC',2020,'Jeep','Cherokee','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'UY03j6Fe12',2020,'Chevrolet','Bolt EV','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'7zxuFmGDLY',2020,'Ford','Expedition','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'pTGFRlqNAZ',2020,'Hyundai','Elantra','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'e5835fdPKX',2020,'Honda','Passport','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'rYV3CVGElN',2020,'Dodge','Charger','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'DemETgxfzm',2020,'Honda','Accord','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ZcDno27E49',2020,'INFINITI','QX60','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'eQ15fbmmpw',2020,'Hyundai','Venue','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'bAVM6QBgYF',2020,'Honda','Pilot','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'IeeTDLPJtc',2020,'Jeep','Grand Cherokee','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'5nK3Kjti74',2020,'Chevrolet','Tahoe','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'ZnSQK6bmSf',2020,'GMC','Acadia','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'MGgtV71Gqh',2020,'Chevrolet','Impala','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'QHVcYMkgs8',2020,'Honda','CR-V','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'0qpktkoahP',2020,'BMW','X5','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'wqjaR037XL',2020,'INFINITI','Q60','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'4pZjPmNsj5',2020,'Ford','Ranger SuperCrew','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'nAVMCHuWui',2020,'Chevrolet','Trax','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'nvlklkJGRL',2020,'Hyundai','Ioniq Plug-in Hybrid','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'Ok8T6kagAQ',2020,'Jaguar','E-PACE','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'2o8HcNPula',2020,'Hyundai','Tucson','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'IDXLjYyc46',2020,'Ford','Explorer','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'DMfFQRFW7L',2020,'Honda','HR-V','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'LQNej2UoF0',2020,'Jaguar','I-PACE','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'US1p57Oo8w',2020,'INFINITI','Q50','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'SQx4TCijoz',2020,'Genesis','G80','SMALL',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'JsaO4qw9cM',2020,'Jaguar','F-PACE','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'LnUsyZRETe',2020,'Jeep','Renegade','SUV',NOW());
INSERT INTO cars(id,objectId,year,make,model,type,created_on) VALUES(NEXT VALUE FOR CARS_SEQUENCE_ID,'lJtQk4oNv7',2020,'Hyundai','Accent','SMALL',NOW());

update cars set plate=CONCAT('5',SUBSTRING(TO_CHAR(1000+id) FROM 2),'-JYL');
CREATE UNIQUE INDEX if not exists iu_unique_cars ON cars(plate);

-- Price Section
INSERT INTO prices(id,price,type,points,created_on) VALUES(1,300.0,'PREMIUN',5,NOW());
INSERT INTO prices(id,price,type,points,created_on) VALUES(2,150.0,'SUV',3,NOW());
INSERT INTO prices(id,price,type,points,created_on) VALUES(3,50.0,'SMALL',1,NOW());

-- Price Items Section
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(1,1,0,0,0,100,NOW());
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(2,1,-1,-1,1,20,NOW());

INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(3,2,1,7,1,100,NOW());
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(4,2,8,30,1,80,NOW());
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(5,2,0,0,30,50,NOW());
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(6,2,-1,-1,1,60,NOW());

INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(7,3,1,7,1,100,NOW());
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(8,3,0,0,7,60,NOW());
INSERT INTO price_items(id,price_id,init_day,end_day,extra_day,recharge,created_on) VALUES(9,3,-1,-1,1,30,NOW());

-- Client Fake section
INSERT INTO clients(id,dni,name,surname,gender,created_on) VALUES(NEXT VALUE FOR CLIENTS_SEQUENCE_ID,'99999999V','Francisco','Ramos Prieto','VARON',NOW());
INSERT INTO clients(id,dni,name,surname,gender,created_on) VALUES(NEXT VALUE FOR CLIENTS_SEQUENCE_ID,'77777777H','Gema','Ramos Prieto','HEMBRA',NOW());
