

//La segunda función no se ejecuta hasta que pasan dos segundos después de ejecutar la primera
setTimeout ( function () {
    console.log (" hola 1 ");
    setTimeout ( function () {
        console.log (" hola 2 ");
    }, 2000 )
}, 2000 )

