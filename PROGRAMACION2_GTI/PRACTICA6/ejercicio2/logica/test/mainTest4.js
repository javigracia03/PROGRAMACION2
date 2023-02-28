const Logica = require( "../Logica.js" )
var assert = require ('assert')

describe( "Test 4: obtener código de matrícula a partir de apellidos", function() {
    // ....................................................
    // ....................................................
    var laLogica = null
    // ....................................................
    // ....................................................
    it( "conectar a la base de datos", function( hecho ) {
            laLogica = new Logica(
                    "../bd/datos.db",
                    function( err ) {
                            if ( err ) {
                                    throw new Error ("No he podido conectar con datos.db")
                            }                                   
        hecho()
 

}) // it
})

// ....................................................
// ....................................................
it( "borrar todas las filas", async function() {
     await laLogica.borrarFilasDeTodasLasTablas()
}) // it
// ....................................................
// ....................................................
it( "puedo insertar una persona, una asignatura y matricularla",
     async function() {
              await laLogica.insertarPersona({dni: "73137014G", nombre: "Javier", apellidos: "Gracia Fernández" } )
              await laLogica.insertarAsignatura({codigo: "19768", nombre: "Fisica"} )
              await laLogica.matricular({codigo: "19768", dni: "73137014G"} )
             var res = await laLogica.buscarDNIconCodigo( "19768" )
             assert.equal( res.length, 1, "¿no hay un resulado?" )
             assert.equal( res[0].codigo, "19768", "¿no es 19768?" )
             assert.equal( res[0].dni, "73137014G", "¿no es 73137014G?" )
}) // it
// ....................................................
// ....................................................
 
it( "puedo obtener el codigo de las asignaturas matriculadas de una persona",
     async function() {
              
       
             var res = await laLogica.buscarcodigosConApellidos("Gracia Fernández")
             
             assert.equal( res.length, 1, "¿no hay un resulado?" )
             assert.equal( res[0].codigo, "19768", "¿no es 19768?" )
             
}) // it

// ....................................................
// ....................................................
it( "cerrar conexión a la base de datos",

async function() {
     try {
             await laLogica.cerrar()
     } catch( err ) {

// assert.equal( 0, 1, "cerrar conexión a BD fallada: " + err)
        throw new Error( "cerrar conexión a BD fallado: " + err)
} }) // it
}) // describe