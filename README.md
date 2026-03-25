# ⚔️ RPG Java POO - Simulador de Combate por Turnos

Proyecto desarrollado en **Java** para demostrar el dominio de la Programación Orientada a Objetos (POO). Este simulador enfrenta a dos personajes con mecánicas únicas de clase en un entorno de consola.

## 🚀 Características del Proyecto
El sistema permite elegir entre tres arquetipos clásicos, cada uno con una gestión de recursos diferenciada:
* **Mago:** Utiliza una reserva de **Maná** para lanzar hechizos de daño y curación.
* **Bárbaro:** Posee una mecánica de **Robo de Vida** (curación basada en el daño infligido) y estado de Furia.
* **Paladín:** Especialista en supervivencia con **Buffs de daño** acumulativos y autocuración.

## 🛠️ Conceptos Técnicos Aplicados
Para este proyecto se han implementado los siguientes fundamentos de ingeniería de software:
* **Clases Abstractas:** Uso de una clase base `Personaje` para centralizar atributos (vida, daño, nombre) y métodos comunes.
* **Herencia:** Especialización de comportamiento en clases hijas (`Mago`, `Barbaro`, `Paladin`).
* **Polimorfismo:** La clase `Batalla` procesa objetos de tipo `Personaje` de forma genérica, ejecutando las implementaciones específicas de cada subclase.
* **Encapsulamiento:** Protección del estado interno de los objetos mediante modificadores de acceso y métodos de lectura (Getters).
* **Arquitectura Limpia:** Separación entre la configuración del juego (`Main`), el árbitro de la pelea (`Batalla`) y las entidades del modelo.

## 📂 Estructura del Repositorio
* `src/main/java/com/mycompany/videojuego/`: Contiene todo el código fuente organizado por clases.

## 🎮 Cómo Ejecutarlo
1. Clona este repositorio o descarga el código fuente.
2. Abre el proyecto en **NetBeans**, **IntelliJ IDEA** o **Eclipse**.
3. Ejecuta la clase principal `VideoJuego.java`.
4. Sigue las instrucciones por consola para elegir combatientes y realizar ataques.
