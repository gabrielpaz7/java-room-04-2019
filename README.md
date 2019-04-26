# Ejercicio 1: Gestión de Pedidos - tienda de ropa
Realizar el modelado de las clases para una aplicación de gestión de pedidos.

La aplicación deberá manejar clientes (de los cuales se guarda su nombre, dirección, teléfono y e-mail), que pueden realizar pedidos de productos. De cada producto se conoce su código, descripción y precio.

El pedido tiene un máximo de 20 unidades, del mismo o distinto tipo de producto. 

Es importante que al momento de registrar el cobro se guarde la fecha real de pago, y el medio de pago elegido (tarjeta de crédito, efectivo).

![Diagrama de Clases](https://github.com/gabrielpaz7/java-room-04-2019/blob/master/diagrama_clases.jpg)


# Ejercicio 2: Biblioteca
Una biblioteca tiene copias de libros. Estos últimos se caracterizan por su nombre, tipo (novela, teatro, poesía, ensayo), editorial, año y autor.

Los autores se caracterizan por su nombre, nacionalidad y fecha de nacimiento.

Cada copia tiene un identificador, y puede estar en la biblioteca, prestada, con retraso, o en reparación.

Los lectores pueden tener un máximo de 3 libros en préstamo.

Cada libro se presta un máximo de 30 días. Por cada día de retraso, se impone una "multa" de dos días sin posibilidad de coger un nuevo libro.

A) Realiza un diagrama de clases y añade los métodos necesarios para realizar el préstamo y devolución de libros.
B) En un nuevo proyecto en Netbeans, crea las clases involucradas. Todas deben incluir, constructores (con y sin parámetros), getters y setters, y al menos tener enunciados los métodos que servirán para el préstamo de libros.

![Diagrama de Clases](https://github.com/gabrielpaz7/java-room-04-2019/blob/master/biblioteca.png)
