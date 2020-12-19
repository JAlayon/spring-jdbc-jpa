/*create table person(
    id integer not null,
    name varchar(255) not null,
    location varchar(255), 
    birth_date timestamp, 
    primary key(id)
);
*/

INSERT INTO person(id, name, location, birth_date)
    VALUES(1001, 'Jair', 'Guadalajara', sysdate());
 
INSERT INTO person(id, name, location, birth_date)
    VALUES(1002, 'Alejandro', 'CDMX', sysdate());

INSERT INTO person(id, name, location, birth_date)
    VALUES(1003, 'Mariana', 'Veracruz', sysdate());
         