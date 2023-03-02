const sqlite3 = require( "sqlite3" )
// .....................................................................
// .....................................................................
module.exports = class Logica {
    // .................................................................
    // nombreBD: Texto
    // -->
    //    constructor ()  -->
    // .................................................................
    constructor( nombreBD, cb  ) {
            this.laConexion = new sqlite3.Database(
                    nombreBD,
                
                    ( err ) => { if(!err) {

                        this.laConexion.run( "PRAGMA foreign_keys = ON" )
                    
                    }
                    cb( err)
                    })
} // ()
// .................................................................
// nombreTabla:Texto
//     -->
//       borrarFilasDe() -->
// .................................................................
borrarFilasDe( tabla ) {
     return new Promise( (resolver, rechazar) => {
            console.log(tabla)
             this.laConexion.run(
                     "delete from " + tabla + ";",
                     (err)=> ( err ? rechazar(err) : resolver() )
 
                )
                    })
} // ()
// .................................................................
//          borrarFilasDeTodasLasTablas() -->
// .................................................................
async borrarFilasDeTodasLasTablas() {
     await this.borrarFilasDe( "Matricula" )
     await this.borrarFilasDe( "Asignatura" )
     await this.borrarFilasDe( "Persona" )
} // ()
// .................................................................
// datos:{dni:Texto, nombre:Texto: apellidos:Texto}
//     -->
//insertarPersona() -->
// .................................................................
insertarPersona( datos ) {
    console.log("DTAOS" + datos.dni)
     var textoSQL =
             'insert into Persona values( $dni, $nombre, $apellidos );'
     var valoresParaSQL = { $dni: datos.dni, $nombre: datos.nombre,
                                                $apellidos: datos.apellidos }
     return new Promise( (resolver, rechazar) => {
             this.laConexion.run( textoSQL, valoresParaSQL, function( err ) {

        ( err ? rechazar(err) : resolver() )
    }) 
    })
} // ()

// .................................................................
// dni:Texto
//
//
//
// {dni:Texto, nombre:Texto: apellidos:Texto}
// .................................................................
buscarPersonaConDNI( dni ) {
     var textoSQL = "select * from Persona where dni=$dni";
     var valoresParaSQL = { $dni: dni }
     return new Promise( (resolver, rechazar) => {
             this.laConexion.all( textoSQL, valoresParaSQL,
                
                    ( err, res ) => {
                        ( err ? rechazar(err) : resolver(res) )
            })
}) 

} // ()

buscarAsignaturaconCodigo(codigo){
    var textoSQL = "select * from Asignatura where codigo=$codigo";
     var valoresParaSQL = { $codigo: codigo }
     return new Promise( (resolver, rechazar) => {
             this.laConexion.all( textoSQL, valoresParaSQL,
                
                    ( err, res ) => {
                        ( err ? rechazar(err) : resolver(res) )
            })
}) 

}


buscarDNIconCodigo(codigo){
    var textoSQL = "select * from Matricula where codigo=$codigo";
     var valoresParaSQL = { $codigo: codigo }
     return new Promise( (resolver, rechazar) => {
             this.laConexion.all( textoSQL, valoresParaSQL,
                
                    ( err, res ) => {
                        ( err ? rechazar(err) : resolver(res) )
            })
}) 

}

// .................................................................
//          codigo:int, nombre:Texto  
//                  insertarAsignatura() -->
// .................................................................
insertarAsignatura(datos){
    var textoSQL =
             'insert into Asignatura values( $codigo, $nombre);'
     var valoresParaSQL = { $codigo: datos.codigo, $nombre: datos.nombre }
     return new Promise( (resolver, rechazar) => {
             this.laConexion.run( textoSQL, valoresParaSQL, function( err ) {

        ( err ? rechazar(err) : resolver() )
    }) 
    })
}




matricular(datos){
    
    var textoSQL ='insert into Matricula values( $dni, $codigo);'
    var valoresParaSQL = { $codigo: datos.codigo, $dni: datos.dni }
    return new Promise( (resolver, rechazar) => {
    this.laConexion.run( textoSQL, valoresParaSQL, function( err ) {

        ( err ? rechazar(err) : resolver() )
    }) 
    })

}


buscarcodigosConApellidos(apellidos){
    var textoSQL = "select Matricula.codigo from Matricula, Persona where Persona.apellidos=$apellidos and Persona.dni = Matricula.dni"
     var valoresParaSQL = { $apellidos: apellidos }
     return new Promise( (resolver, rechazar) => {
             this.laConexion.all( textoSQL, valoresParaSQL,
                
                    ( err, res ) => {
                        ( err ? rechazar(err) : resolver(res) )
            })
}) 
}
// .................................................................
//          cerrar() -->
// .................................................................
cerrar() {
    return new Promise( (resolver, rechazar) => {
            this.laConexion.close( (err)=>{
                ( err ? rechazar(err) : resolver() )
        }) 

    })
} // ()

 

} // class
// .....................................................................
// .....................................................................
