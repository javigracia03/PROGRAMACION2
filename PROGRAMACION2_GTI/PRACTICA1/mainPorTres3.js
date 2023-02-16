


// R -> porTres() -> R
function porTres1( a ) {
    return a * 3;
}

function porTresA( a, retornar ) {
    setTimeout( function() {
        // han pasado 4 segundos
        retornar( a * 3 ) // devolver a * 3
    }, 4000)
}



// main

var r = porTres1( 5 )
console.log( r )

porTresA( 5, function( res ) {
    console.log( res )
    
})




/*

function porTres(a){
    return new Promise ( resolve => {
        setTimeout(() => {
            resolve(a*3);
        } , 3000);
        
    });
}






async function pruebaPorTres(){
    const result = await porTres(4);
    if (result === 12){
        console.log("TODO OK");
    }else console.log("ALGO VA MAL")
}

pruebaPorTres();

*/