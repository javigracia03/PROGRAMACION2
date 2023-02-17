const fs = require("fs")

fs.writeFile("nombre.txt", "Javier Gracia", function(err){
    if(err){
        console.log("Ha habido un error")
    }
})

fs.readFile("nombre.txt", "utf8", function(err, contenido){
    if( err ) {
        console.log( "hubo un problema al leer de nombre.txt" ) 
        return
        }
        console.log( contenido )
})