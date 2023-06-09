# Tienda-JavaFX

Proyecto de Punto de Venta Abarrotes usando javaFX con el modelo MVC para la clase de Diseño de software

Para utilizar asegurarse de crear la carpeta lib en la raiz del proyecto y agregar las siguientes librerias

```
itextpdf-5.5.13.3.jar
sqlite-jdbc-3.41.2.1.jar
```

Para iniciar el proyecto lo debe hacer desde la clase App.java en la carpeta src/main

# Proyecto Punto de Venta Abarrotes

## Diseño de Software

- Carrera: Licenciatura en Ingeniería en Software
- Asesor: José Luis López Martínez

### Integrantes:

1. Ricardo Reyes Balam Cupul
2. Roger Jesus Aguilar Uicab
3. Miguel Angel Gómez Herguera
4. Diego Alexander Rosado Valle

Fecha de entrega: 23/05/23

# Índice

1. [Introducción](#introducción)
2. [Objetivo](#objetivo)
3. [Requerimientos Funcionales](#requerimientos-funcionales)
4. [Vistas del proyecto](#vistas-del-proyecto)
5. [Vistas Interfaz](#vistas-interfaz)
6. [Vistas Diagramas](#vistas-diagramas)
7. [Glosario](#glosario)
8. [Conclusiones](#conclusiones)

## Introducción
Durante el transcurso de este semestre se nos dio el objetivo de realizar este proyecto de la
cual está basado con todo lo visto previamente referente al Diseño de Software, por
consiguiente se tomaron como base los diagramas aprendidos en clase, como los son los
conocidos UML, Diagramas de Secuencia, Diagramas de Estado, Diagramas de Colaboración
entre algunos más. El objetivo de este proyecto era realizar un programa de Punto de Venta de
una Tienda de Abarrotes que a continuación se presentará.

## Objetivo
Realizar un programa de Punto de Venta de una Tienda de Abarrotes basada con el diseño de
software, con ciertos diagramas vistos en clases.

## Requerimientos Funcionales
Registro de cliente:
El sistema debe permitir la creación de un registro de un nuevo cliente.
El registro del cliente debe contener un Identificador del cliente, Nombre, Apellido
Paterno, Dirección (Composición: Calle, Número, Colonia, CP, Ciudad, Estado,
Teléfono).
Registro de artículo:
El sistema debe permitir la creación de un registro de un nuevo artículo.
El registro del artículo debe contener un Identificador, Nombre del artículo, precio al
público, precio del proveedor, cantidad total de existencia.
Realizar una compra:
El sistema debe permitir la compra de varios articulos en un carrito de compras.
El sistema debe permitir que el usuario seleccione el artículo y la cantidad deseada por
el cliente.
El sistema debe verificar la existencia del artículo en inventario antes de completar la
venta.
El sistema debe calcular el importe total de la compra y mostrarlo en ticket.
Generar un ticket:
Al finalizar la compra, el sistema debe generar un ticket que contenga lo siguiente:
Fecha de la compra.
Nombre del cliente.
Nombre del artículo comprado.
Cantidad de artículos comprados.
Precio unitario de cada artículo.
Precio total de la compra.

## Vistas del proyecto
Se presentan las diferentes vistas del proyecto, incluyendo la arquitectura general y los módulos principales.

## Vistas Interfaz
En esta sección se muestran las vistas de interfaz de usuario del sistema de Punto de Venta.

## Vistas Diagramas
Se incluyen los diagramas de flujo, diagramas de clases y otros diagramas relevantes al proyecto.

## Glosario
Patrón de Diseño: Singleton
Descripción: Garantiza que una clase tenga solo una instancia y proporciona un punto global
de acceso a ella.
DAO, que significa "Data Access Object" (Objeto de Acceso a Datos), es un patrón de diseño de
software que se utiliza para separar la lógica de acceso a datos de la lógica de negocio en una
aplicación.
MVC, que significa "Model-View-Controller" (Modelo-Vista-Controlador), es un patrón de
diseño arquitectónico ampliamente utilizado en el desarrollo de aplicaciones de software. El
patrón MVC separa los componentes de una aplicación en tres partes principales: el Modelo, la
Vista y el Controlador, cada uno con responsabilidades específicas.

## Conclusiones
En conclusión, esté proyecto tiene la finalidad de que usemos ciertos diagramas para poder así
llegar al punto de realizar algunos programas con mayor facilidad gracias a la visualización de
las clases como ya conocemos y también la utilización de algunos diagramas como son los de
estado y colaboración para cada uno de nuestros proyectos

