//porTres = ((a) => a*3);

porTres = ( function(a) {
    return a*3;
});

function main(){

    if (porTres(2) === 6){

        console.log("porTres OK")
    }else console.log("porTres NOT OK")

}

main()