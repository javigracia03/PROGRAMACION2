// –––––––––––––––––––––––––
// medirTemperatura() -> JSON{ hora: N, temperatura: R }
//
// Realiza una medida de temperatura y
// devuelve el valor junto con la hora
// –––––––––––––––––––––––––
function medirTemperatura() {
    //
    // completar: devolver un objeto con dos campos:
    // hora, con la hora actual; y
    // temperatura, un valor aleatorio entre 15 y 20
    //
    var today = new Date();
    var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    
    var tmp= Math.floor(Math.random() * (6) + 15);

    var obj = {
        hora: time,
        temperatura: tmp
    }
    
    return obj;
 } // ()

// ––––––––––––––––––––––––––––-
// cuantas:N -> tomarMediciones() -> Lista<JSON{hora:N, temperatura:R}>
//
// Toma la cantidad de mediciones indicadas llamando
// cada segundo a medirTemperatura()
// ––––––––––––––––––––––––––––-
function tomarMediciones( cuantas, mediciones, callback ) {
    if( cuantas == 0 ) { 
        callback( mediciones ) 
        return
    }
     mediciones.push( medirTemperatura() )
     setTimeout( function() {
      tomarMediciones( cuantas-1, mediciones, callback )
     }, 1000 )
    } // ()
    // –––––––––––––––––––––––––
    // main()
    // –––––––––––––––––––––––––
    var medidas = []
    //
    // completar: llamar a tomarMediciones() para que nos devuelva
    // 7 medidas de temperatura y guardar lo que nos devuelve
    // en el ficheor "datos.txt" (habiendo convertido los datos
    // a JSON previamente)
    //

    tomarMediciones(7, medidas, function(res){
        const fs = require("fs");
        const json = JSON.stringify(medidas);
        console.log(json);

        fs.writeFile("datos.txt", json, function(err){
            if(err){
                console.log("Ha habido un error")
            }
        })
    })