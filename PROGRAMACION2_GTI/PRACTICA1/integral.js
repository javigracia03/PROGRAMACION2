function integral(a,b,polinomio){

    //polinomio [x^0,x^1,x^2,......]
    let res = [];
    let sum_a = 0;
    let sum_b = 0;
    
    res.push(0);
    res.push(polinomio[0]);
    //obtener el array del polinomio integrado
    for(i=2; i<polinomio.length + 1; i++){
        res[i]= polinomio[i-1]/i;
    }
    //calcular el valor de la integral con los límites
    for(i=1;i<res.length; i++){
        sum_a+=Math.pow(a,i)*res[i];
        sum_b+=Math.pow(b,i)*res[i];
        
    }

    resultado = sum_b-sum_a;
    return resultado;

}


function pruebaIntegral(){
    let polinomio = [1,2,3,1];
    if(integral(0,2,polinomio)===18){
        console.log("Todo OK");
    }else console.log("ALGO VA MAL");
}

pruebaIntegral();



