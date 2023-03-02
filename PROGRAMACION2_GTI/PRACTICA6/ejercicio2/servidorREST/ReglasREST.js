// .....................................................................
// ReglasREST.js
// .....................................................................
module.exports.cargar = function( servidorExpress, laLogica ) {
        
        servidorExpress.get(
                '/persona/:dni',
               async function( peticion, respuesta ){
                       console.log( " * GET /persona " )
                       // averiguo el dni
                       var dni = peticion.params.dni
                       // llamo a la función adecuada de la lógica
                       var res = await laLogica.buscarPersonaConDNI( dni )
                       // si el array de resultados no tiene una casilla ...
                       if( res.length != 1 ) {
                               // 404: not found
                               respuesta.status(404).send( "no encontré dni: " + dni )
                               return
}
// todo ok
                       respuesta.send( JSON.stringify( res[0] ) )
               }) // get /persona


        
     // .......................................................
     // GET /borrarFilasdeTablas
     // .......................................................
     servidorExpress.post(
             '/borrarFilasde/:tabla',
            async function( peticion, respuesta ){
                    console.log( " * GET /borrarFilasde/ " )
                    // averiguo la tabla
                    var tabla = peticion.params.tabla
                    // llamo a la función adecuada de la lógica
                    console.log(tabla)
                    var res  = await laLogica.borrarFilasDe( tabla )
                    console.log(res + "aui")
                    // si el array de resultados no tiene una casilla ...
                    if( res.length != 1 ) {
                            // 404: not found
                            respuesta.status(404).send( "no encontré dni: " + dni )
                            return
}
// todo ok
                    respuesta.send( JSON.stringify( res[0] ) )
            }) // get /persona

            servidorExpress.post(
                '/insertarpersona',
               async function( peticion, respuesta ){
                       console.log( " * POST /insertarpersona " )
                       // averiguo los datps
                       var datos = JSON.parse(peticion.body)
                       console.log(datos)
                       // llamo a la función adecuada de la lógica
                       await laLogica.insertarPersona(datos)
                       
    
                       //PREGUNTAR JORDI SI HAY ALGUNA FORMA DE NO CERRAR LA CONEXION SI EXISTE DNI Y COMO MOSTRARLO EN PANTALLA
                       
        
                               respuesta.status(200).send( "TODO OK")
                               return
}
// todo ok
                       
               ) // get /persona


} // cargar()
// .....................................................................
// .....................................................................