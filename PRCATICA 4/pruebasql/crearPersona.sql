/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  javie
 * Created: 19-jun-2022
 */

-- crearPersona.sql
create table Persona (
dni char(9) not null,
nombre varchar(20) not null,
apellidos varchar(80) not null,
primary key (dni)
);