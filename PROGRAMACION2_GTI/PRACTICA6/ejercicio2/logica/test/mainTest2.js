const Logica = require( "../Logica.js" )
var assert = require ('assert')

describe( "Test 2: insertar una asignatura", function() {
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
it( "puedo insertar una asignatura",
     async function() {
             await laLogica.insertarAsignatura(
                     {codigo: "19768", nombre: "Fisica"} )
             var res = await laLogica.buscarAsignaturaconCodigo( "19768" )
             assert.equal( res.length, 1, "¿no hay un resulado?" )
             assert.equal( res[0].codigo, "19768", "¿no es 19768?" )
             assert.equal( res[0].nombre, "Fisica", "¿no es Fisica?" )
}) // it
// ....................................................
// ....................................................
 

it( "no puedo insertar una asignatura con codigo que ya está",
     async function() {
             var error = null
                try {
                await laLogica.insertarAsignatura(
                     {codigo: "19768", nombre: "Fisica" } )
                             } catch( err ) {
                                     error = err
                                     
                }
                             assert( error, "¿Ha insertado el dni que ya estaba 19768? (¿No ha pasado por el catch()?" )
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