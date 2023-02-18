const Punto = require('../Punto.js');
var assert = require('assert')

describe("Test diferencia", function(){

    var p1 = new Punto(0,0)
    var p2 = new Punto(1,1)
    var p3 = new Punto (2,2)

    it("componente x de p2-p1 es 1", function(seguir){
        assert.equal(p2.diferencia(p1).getX(), 1)
        seguir()
    })
    it("componente y de p2-p1 es 1", function(seguir){
        assert.equal(p2.diferencia(p1).getY(), 1)
        seguir()
    })
    it("componente x de p3-p1 es 2", function(seguir){
        assert.equal(p2.diferencia(p1).getX(), 1)
        seguir()
    })
    it("componente y de p3-p1 es 2", function(seguir){
        assert.equal(p2.diferencia(p1).getY(), 1)
        seguir()
    })
})