package com.example.laboratorio_1

class Estudiante(
    val nombre: String,
    val carnet: String,
    val asignatura: String
)

fun main() {
    val Ciclo01 = mutableListOf<Estudiante>()

    Ciclo01.add(Estudiante("Francisco Cardona", "00119123", "Programación de Dispositivos Moviles"))
    Ciclo01.add(Estudiante("Marta Rivas", "00345623", "Programación de Dispositivos Moviles"))
    Ciclo01.add(Estudiante("Jose Perez", "00478923", "Programación de Dispositivos Moviles"))

    Ciclo01.add(Estudiante("Ana Garcia", "00111123", "Análisis numerico"))
    Ciclo01.add(Estudiante("Luis Rodriguez", "00322223", "Análisis numerico"))
    Ciclo01.add(Estudiante("Karla Meza", "00233323", "Análisis numerico"))
    Ciclo01.add(Estudiante("Pedro Alfaro", "00244423", "Análisis numerico"))

    println("--- Estudiantes de Programación de Dispositivos Moviles ---")

    for (estudiante in Ciclo01) {
        if (estudiante.asignatura == "Programación de Dispositivos Moviles") {
            println("Nombre: ${estudiante.nombre} - Carnet: ${estudiante.carnet}")
        }
    }
}