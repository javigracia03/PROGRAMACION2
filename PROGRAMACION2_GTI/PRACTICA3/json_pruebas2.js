var unaPersona = {
    dni : "20123567R",
    nombre : "Juan",
    apellidos : "García Pérez",
    edad : 19,
    telefonos : [696234567, 676456123]
}

var texto = JSON.stringify(unaPersona);

console.log(texto);

var juan = JSON.parse( texto );
console.log(juan);