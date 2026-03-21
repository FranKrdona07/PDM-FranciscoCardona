package com.example.laboratorio_1

class Calculadora(
    val marca: String,
    val añosDeVida: Int,
    var precio: Double
) {

    fun sumar(a: Double, b: Double) {
        val resultado = a + b
        println("Suma: $resultado")
    }

    fun restar(a: Double, b: Double) {
        val resultado = a - b
        println("Resta: $resultado")
    }

    fun multiplicar(a: Double, b: Double) {
        val resultado = a * b
        println("Multiplicacion: $resultado")
    }

    fun dividir(a: Double, b: Double) {
        if (b == 0.0) {
            println("Error: No se puede dividir entre cero")
        } else {
            val resultado = a / b
            println("Division: $resultado")
        }
    }
}

fun main() {
    val miCalculadora = Calculadora("Casio", 10, 25.0)

    println("Marca: ${miCalculadora.marca}")
    println("Años: ${miCalculadora.añosDeVida}")
    println("Precio: ${miCalculadora.precio}")

    miCalculadora.sumar(10.0, 5.0)
    miCalculadora.restar(10.0, 5.0)
    miCalculadora.multiplicar(10.0, 5.0)
    miCalculadora.dividir(10.0, 2.0)
    miCalculadora.dividir(10.0, 0.0)
}