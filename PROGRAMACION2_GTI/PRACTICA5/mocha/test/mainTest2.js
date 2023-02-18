const Punto = require('../Punto.js') 
var assert = require ('assert')
// ––––––––––––––
// main ()
// ––––––––––––––
// descripción los test que hacemos aquí
describe( "Prueba de distancia()",
    function () {
       var p1 = new Punto( 0, 0 ) 
       var p2 = new Punto( 3, 4 )
        // ––––––––––––––––––––-
        // it(): test concreto
        it( "la distancia de p1 a p2 es 5", function(hecho){
            assert.equal( p1.distancia(p2), 5 ) 
            hecho()
        }) // it
         // ––––––––––––––––––––-
         // it(): test concreto
        it( "la distancia de p2 a p1 es 5", function(hecho){
            assert.equal( p1.distancia(p2), 5 ) 
            hecho()
        }) // it

// ––––––––––––––––––––-
     // it(): test concreto
    it( "la distancia de p1 a p1 es 0", function(hecho){
        assert.equal( p1.distancia(p1), 0 ) 
        hecho()
    }) // it
} ) // describe