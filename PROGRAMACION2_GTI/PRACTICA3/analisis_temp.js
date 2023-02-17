//main()

let temps

function readfile(callback){
    //Leer los datos del fichero de texto 
    const fs = require("fs");
    fs.readFile("datos.txt", "utf8", function(err, contenido){
        if( err ) {
            console.log( "hubo un problema al leer de nombre.txt" ) 
            return
            }
        const obj = JSON.parse(contenido);   
        //console.log(obj);
        callback(obj)
    })
}
//readfile()
readfile(function(res){
   console.log("TEMPERATURAS MÁXIMAS: \n", temp_max(res));
   console.log("TEMPERATURAS MÍNIMAS: \n",temp_min(res));
   console.log("LA MEDIA ES: " + temp_media(res));
   
})

function temp_max(obj){
    var temps = (obj.map(a => (a.temperatura)));
    var temp_max= Math.max(...temps);
    var res = obj.filter(a => a.temperatura == temp_max);
    //console.log(res)
    return res;
}

function temp_min(obj){
    var temps = (obj.map(a => (a.temperatura)));
    var temp_min= Math.min(...temps);
    var res = obj.filter(a => a.temperatura == temp_min);
    //console.log(res)
    return res;
}

function temp_media(obj){
    var suma = obj.reduce(function(a,b){
       
        return a+=b.temperatura;
    },0);
    return(suma/(obj.length));
}



