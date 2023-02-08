/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  javie
 * Created: 28-jun-2022
 */

--create table Matricula

create table Matricula (
    dni char(9) not null,
    codigo char(8) not null,
    foreign key (dni) references Persona(dni),
    foreign key (codigo) references Asignatura(codigo),
    primary key (dni,codigo)
);