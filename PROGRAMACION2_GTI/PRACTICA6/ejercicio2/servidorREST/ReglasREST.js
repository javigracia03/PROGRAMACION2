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
     // GET /buscarAsignatura?cod=<num>
     // .......................................................
     servidorExpress.get(
        '/buscarAsignatura',
       async function( peticion, respuesta ){
               console.log( " * GET /buscarAsignatura " )
               
               var codigo = peticion.query.cod
               
               // llamo a la función adecuada de la lógica
               
               var res = await laLogica.buscarAsignaturaconCodigo(codigo)
                   
               if(res.length != 1){
                respuesta.status(404).send("no hay ninguna asignatura con ese codigo")
                return
               }
               respuesta.send(res[0])   
       })
     // .......................................................
     // GET /buscarDNI?cod=<num>
     // .......................................................
     servidorExpress.get(
        '/buscarDNI',
       async function( peticion, respuesta ){
               console.log( " * GET /buscarDNI " )
               
               var codigo = peticion.query.cod
               
               // llamo a la función adecuada de la lógica
               
               var res = await laLogica.buscarDNIconCodigo(codigo)
                   
               if(res.length == 0){
                respuesta.status(404).send("no hay ninguna persona matriculada con ese codigo")
                return
               }
               respuesta.send(res)   
       })
                
     // .......................................................
     // POST /insertarAsignatura?cod=<num>&nombre=<texto>
     // .......................................................
     servidorExpress.post(
        '/insertarAsignatura',
       async function( peticion, respuesta ){
               console.log( " * POST /insertarAsignatura " )
               
               var datos = JSON.parse(peticion.body)
               
               // llamo a la función adecuada de la lógica
               
               await laLogica.insertarAsignatura(datos)
               respuesta.status(200)  
               respuesta.send("TODO OK") 
               
       })
     // .......................................................
     // POST /matricular?cod=<num>&dni=<texto>
     // .......................................................
     servidorExpress.post(
        '/matricular',
       async function( peticion, respuesta ){
               console.log( " * POST /matricular " )
               
               var datos = JSON.parse(peticion.body)
               
               // llamo a la función adecuada de la lógica
               
               await laLogica.matricular(datos)
               
               respuesta.send("TODO OK") 
               
       })

     // .......................................................
     // GET /buscarcodigos?appellidos<texto>
     // .......................................................
     servidorExpress.get(
        '/buscarcodigos',
       async function( peticion, respuesta ){
               console.log( " * GET /buscarcodigos " )
               
               var apellidos = peticion.query.apellidos
              
               // llamo a la función adecuada de la lógica
               
               var res = await laLogica.buscarcodigosConApellidos(apellidos)
               
               if(res.length==0){
                respuesta.status(404).send("Persona no encontrada")
                return
                }
               respuesta.send(res) 
               
       })
            
            // POST /insertarpersona

            servidorExpress.post(
                '/insertarpersona',
               async function( peticion, respuesta ){
                try{
                        console.log( " * POST /insertarpersona " )
                       // averiguo los datps
                       var datos = JSON.parse(peticion.body)
                       console.log(datos)
                       // llamo a la función adecuada de la lógica
                       
                        await laLogica.insertarPersona(datos)
                       
                       respuesta.status(200).send("TODO OK")
                         
                        return
                }catch(err){
                        respuesta.send(err.message)
                
                }       
                                
                       
                       
                        
                       
                        
                       
}
// todo ok
                       
               ) // get /persona


} // cargar()
// .....................................................................
// .....................................................................