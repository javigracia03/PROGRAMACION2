var pila= {
    elementos : [],
    
    apilar : function(a){
        this.elementos.push(a)
    },

    desapilar: function(){
        this.elementos.pop()
    },

    cima: function(){
        return this.elementos[this.elementos.length-1]
    }

}
pila.apilar("Hola")
pila.apilar("Adios")

console.log(pila);

pila.desapilar()

console.log(pila.elementos)

pila.apilar("HOlA")
pila.apilar("QUÉ")
pila.apilar("TAL")

console.log(pila.elementos)
console.log(pila.cima())