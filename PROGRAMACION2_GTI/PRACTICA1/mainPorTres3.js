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