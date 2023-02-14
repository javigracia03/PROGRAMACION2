

const palabras = ["cuchara", "extraordinario", "examen", "radiante", "sandalia", "velocidad", "sorpresa", "talento", "yogur", "xilófono"];

//Comparar arrays
function comparar_arrays(array1, array2){
    if(array1.length ==! array2.length){
        return false;
    }
    for (i=0; i<= array1.length; i++){
        if(array1[i] !== array2[i]){
            return false;
        }
    }
    return true;
}

//Prueba filtrar
function prueba_filtrar(palabras){
    let palabras_x2 = palabras.filter(a => a.includes("x"));
    
    if (comparar_arrays(palabras_x2, [ 'extraordinario', 'examen', 'xilófono' ])){
        console.log("FILTRAR OK");
    }else console.log("FILTRAR va mal");
}
prueba_filtrar(palabras);


// Prueba mapear
function prueba_mapear(palabras){
    let palabras_l = palabras.map(a => a.length);
    if (comparar_arrays(palabras_l, [7, 14, 6, 8, 8,
        9,  8, 7, 5, 8])){
        console.log("MAPEAR OK");
    }else console.log("MAPEAR va mal");
}
prueba_mapear(palabras);


//Prueba reducir

function prueba_reducir(){

    const numeros = [1,2,3,4,5];
    let suma = numeros.reduce(((a, b) => a + b), 0 );
    if (suma === 15){
        return "REDUCIR OK";
    }else return "REDUCIR va mal";

}
console.log(prueba_reducir());