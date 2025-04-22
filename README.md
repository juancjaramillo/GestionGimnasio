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
