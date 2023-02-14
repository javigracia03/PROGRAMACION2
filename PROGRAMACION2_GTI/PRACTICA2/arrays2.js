const palabras = ["Es", "ahora", "tu", "oportunidad", "para", "aprovechar", "este", "día"];

//Invertir array
function invertir_array(array1){
    let res = array1.map(function(a){
        
        return a.split("").reverse().join("");

    });
    return res;
}

console.log(invertir_array(palabras));