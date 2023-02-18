// ––––––––––––––––-
// main.js
// ––––––––––––––––-
// ––––––––––––––––-
// requires
// ––––––––––––––––-
const Punto = require( "./Punto.js" )
// ––––––––––––––––-
// main ()
// ––––––––––––––––-
var p1 = new Punto( 3, 4 )
var p2 = new Punto(5,6)
console.log( p1.dif(p2) )