# 🏋️‍♂️ GestionGimnasio

Proyecto universitario desarrollado en Java usando NetBeans que permite gestionar un gimnasio mediante programación orientada a objetos (POO). Incluye funciones de registro, consulta y persistencia de datos en archivos `.txt`.

## 📚 Funcionalidades

- Registrar clientes con nombre, edad, peso y membresía.
- Registrar entrenadores con nombre y especialidad.
- Crear clases de entrenamiento asociadas a entrenadores.
- Mostrar listados de clientes, entrenadores y clases.
- Guardar automáticamente los datos en archivos `.txt`.
- Leer automáticamente los datos al iniciar el programa.

## 💡 Estructura del proyecto

```text
GestionGimnasio/
├── src/
│   └── com/mycompany/gestiongimnasio/
│       ├── Cliente.java
│       ├── Membresia.java
│       ├── Entrenador.java
│       ├── ClaseEntrenamiento.java
│       └── GestionGimnasio.java
├── clientes.txt
├── entrenadores.txt
├── clases.txt
└── README.md

🛠 Tecnologías utilizadas
Java 17+

NetBeans 15+

Programación orientada a objetos

Entrada/salida de archivos (.txt)

🚀 Cómo ejecutar el proyecto
Abre el proyecto en NetBeans: File > Open Project.

Ejecuta la clase GestionGimnasio.java.

Usa el menú por consola para interactuar.

Al salir, los datos se guardan automáticamente en archivos .txt.

Al volver a abrir el programa, los datos se recuperan.

📁 Archivos de datos
clientes.txt

entrenadores.txt

clases.txt

Estos archivos se crean automáticamente en la raíz del proyecto y almacenan los datos registrados.

👨‍💻 Autor
Juan Jaramillo
