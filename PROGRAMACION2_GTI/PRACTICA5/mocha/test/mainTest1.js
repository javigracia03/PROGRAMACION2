const Punto = require('../Punto.js') 
var assert = require('assert')
// ––––––––––––––
// main ()
// ––––––––––––––
// descripción los test que hacemos aquí
describe( "Prueba constructor y getters ",
    function () {
     // ––––––––––––––––––––-
     before( function( hecho ) {
      console.log("esto ocurre antes de los it()")
      hecho() // llamo a esta funcion para seguir
     })
     // ––––––––––––––––––––-
     // it(): test concreto
     it( "pruebo getY()", function( hecho ){
        var p1 = new Punto( 3, 4 )
        // Esta es la comprobación: 
        // compruebo que getY() da 4 
        assert.equal( p1.getY(), 4 ) 
        hecho()
}) // it

// ––––––––––––––––––––-
 // it(): test concreto
 it( "pruebo getX()", function( hecho ){
    var p1 = new Punto( 3, 4 )
      // Vamos a simular que esto es un test
      // asíncrono poniendo un timeout.
      setTimeout( function() {
    // Esta es la comprobación:
    // compruebo que getX() da 3 
    assert.equal( p1.getX(), 3 )
    hecho() /* llamo a hecho para inidicar
          * que este test ha terminado,
          * y así vamos al siguiente it()  */
      }, 500)
    }) // it
     // ––––––––––––––––––––-
     after( function() {
      console.log("esto ocurre después de los it()")
     })
    } ) // describe