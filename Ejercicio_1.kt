package com.example.laboratorio_1
class Computadora(
    val marca: String,
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String
) {
    private var encendida: Boolean = false

    fun encender() {
        encendida = true
        println("Computadora $marca encendida.")
    }

    fun apagar() {
        encendida = false
        println("Computadora apagada.")
    }

    fun mostrarEstado() {
        println("RAM: $ram GB")
        println("Almacenamiento: $almacenamiento GB")
        println("Sistema Operativo: $sistemaOperativo")
    }

    fun mostrarProgramasActuales(programas: List<String>) {
        val programasEsteAño = programas.filter { it.contains("2026") }
        println("Programas del 2026: $programasEsteAño")
    }
}

fun main() {
    val miPC = Computadora("Lenovo", 16, 512, "Windows 11")

    miPC.encender()

    miPC.mostrarEstado()

    val listaProgramas = listOf("Notion 2026", "Facebook 2024", "Spotify 2026", "Chrome 2026", "VisualFox 98")
    miPC.mostrarProgramasActuales(listaProgramas)

    println("--- Después de actualizar ---")

    miPC.ram = 32
    miPC.almacenamiento = 512
    miPC.sistemaOperativo = "Linux"

    println("RAM: ${miPC.ram} GB")
    println("Almacenamiento: ${miPC.almacenamiento} GB")
    println(" SO: ${miPC.sistemaOperativo}")

    miPC.apagar()
}