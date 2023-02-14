const palabras = ["Es", "ahora", "tu", "oportunidad", "para", "aprovechar", "este", "día"];

//Invertir array
function invertir_array(array1){
    let res = array1.map(function(a){
        
        return a.split("").reverse().join("");

    });
    return res;
}

console.log(invertir_array(palabras));

//Total de caracteres
function total_carac(array2){
    let res = array2.reduce(function (a,b){
        return a + b.length;
    },0);
    return res;
}

console.log(total_carac(palabras));

//Número de palabras con más de 5 letras
function mas_de_5(array3){
    let res = array3.reduce(function(a,b){
        if (b.length > 5){
            return a + 1;
        }else return a;
    },0);
    return res;
}

console.log(mas_de_5(palabras));

//Concatenación de 3 letras o menos
function concat_3letras(array4){
    const letras3 = array4.filter(a => a.length<=3);
    let res = letras3.reduce(((a,b)=> a+b),"");
    
    return res;
}

console.log(concat_3letras(palabras));