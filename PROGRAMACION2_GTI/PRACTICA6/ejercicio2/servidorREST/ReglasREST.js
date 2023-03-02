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
     // POST /borrarFilasdeTablas
     // .......................................................
     servidorExpress.post(
             '/borrarFilasde',
            async function( peticion, respuesta ){
                    console.log( " * GET /borrarFilasde/ " )
                    // averiguo la tabla
                    var tabla = JSON.parse(peticion.body).tabla
                    // llamo a la función adecuada de la lógica
                    
                    await laLogica.borrarFilasDe( tabla )
                        respuesta.send("TODO OK")   
            })
     // .......................................................
     // POST /borrarFilasdeTodasLasTablas
     // .......................................................
     servidorExpress.post(
        '/borrarFilasdeTodasLasTablas',
       async function( peticion, respuesta ){
               console.log( " * POST /borrarFilasdeTodasLasTablas " )
               
               
               // llamo a la función adecuada de la lógica
               
               await laLogica.borrarFilasDeTodasLasTablas()
                   respuesta.send("TODO OK")   
       })
     // .......................................................
     // GET /buscarAsignatura?cod=
     // .......................................................
     servidorExpress.get(
        '/buscarAsignatura',
       async function( peticion, respuesta ){
               console.log( " * GET /buscarAsignatura " )
               
               var codigo = peticion.query.cod
               console.log(codigo)
               // llamo a la función adecuada de la lógica
               
               var res = await laLogica.buscarAsignaturaconCodigo(codigo)
                   
               if(res.length != 1){
                respuesta.status(404).send("no hay ninguna asignatura con ese codigo")
               }
               respuesta.send(res[0].nombre)   
       })

                
            
            // POST /insertarpersona

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