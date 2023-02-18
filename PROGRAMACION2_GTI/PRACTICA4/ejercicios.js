function leerFichero(nombre){
    const fs = require("fs");
    const prom = new Promise( function(resolver, rechazar){
        fs.readFile(nombre, "utf8", function(err, contenido){
            if(err){
                console.log("Ha habido un error");
                rechazar(err);
                return
            }
            resolver(contenido);
        });

        
    })
    
    return prom;
    
}

function escribirFichero(nombre, texto){
    const fs = require("fs")
    const prom = new Promise(function(resolve, rechazar){
       
        fs.writeFile(nombre, texto, function(err){
            if(err){
                console.log("Ha habido un error")
                rechazar(err)
                return
            }
            
            
        })
    })
    return prom;
    
}

async function concatenarFicheros(nombre1, nombre2, nombre3){
    const texto1 = await leerFichero(nombre1);
    const texto2 = await leerFichero(nombre2);
    const texto3 = await leerFichero(nombre3);

    escribirFichero("res.txt", texto1 + " " + texto2 + " " + texto3 + " ");
}

concatenarFicheros("a.txt", "b.txt", "c.txt");




