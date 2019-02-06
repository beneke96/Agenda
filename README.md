# Agenda
Agenda de contactos
 ## Programación Multimedia y de Dispositivos Móviles
 ## --- Unidad de Trabajo 04 SQLite ---

Crear un proyecto Android que nos cree una agenda donde nos permita almacenar los siguientes datos:
- Nombre de la persona (tipo String).
- Email de la persona (tipo String).
- Id del contacto (tipo Integer, deberá rellenarse de manera automática).

Los datos deberán almacenarse en una base de datos SQLite en nuestra aplicación, de manera que la aplicación debe ser capaz de realizar las siguientes tareas: 

- Insertar un nuevo contacto en la agenda.
-	Modificar un nuevo contacto en la agenda.
-	Eliminar un nuevo contacto en la agenda.

La aplicación deberá tener las siguientes actividades:

-	Activity Principal: debe listar todos los contactos de nuestra agenda, si en la agenda no hay ningún contacto, deberá mostrar un mensaje indicando que la agenda está vacía.
-	Activity Secundaria: debe permitir añadir un nuevo contacto o modificar un nuevo contacto.

Además la aplicación deberá tener los siguientes elementos:

-	Un menú contextual que, cuando pulsemos sobre un contacto de la lista lista, nos permita modificar o eliminar dicho contacto.
-	Un menú en el sidebar que nos permita insertar un nuevo contacto (para esta acción se puede utilizar también un Floating Action Button:).

Opcional:

-	Cuando se vaya a eliminar un contacto de la agenda, nos debe pedir confirmación.
-	Cuando vayamos a insertar o modificar un contacto, debemos asegurarnos que el campo email tiene efectivamente un formato de tipo email: cuenta@dominio

### EMPECEMOS

Al abrir la aplicación, la agenda estará vacía:

![1](https://user-images.githubusercontent.com/35973932/52344321-5415bf00-2a12-11e9-81cd-cdd7d114c33f.png)

Para añadir un contacto le daremos al menú sidebar de la esquina superior derecha, y nos saldrá la opción de “Nuevo”, la cual nos llevará a la actividad de Registrar usuario:

 ![2](https://user-images.githubusercontent.com/35973932/52344322-5415bf00-2a12-11e9-9681-8b7f890222fb.png)

Introducimos los datos del contacto que queramos añadir. El correo habrá que introducirlo de forma correcta, de lo contrario no nos permitirá añadirlo. Una vez todo puesto correctamente nos añadirá al contacto y se quitarán los datos puestos, y podremos añadir todos los contactos que queramos.

![3](https://user-images.githubusercontent.com/35973932/52344323-54ae5580-2a12-11e9-982d-4fb9dc2e64d8.png)

![4](https://user-images.githubusercontent.com/35973932/52344324-54ae5580-2a12-11e9-9c56-c466afbeae36.jpg)

![5](https://user-images.githubusercontent.com/35973932/52344326-54ae5580-2a12-11e9-9250-e03e7520f91d.png)

Y se nos mostrarán en la lista principal:

![6](https://user-images.githubusercontent.com/35973932/52344327-54ae5580-2a12-11e9-8a50-e9b6f1935aa3.png)
 
Si mantenemos el contacto pulsado nos saldrán dos opciones:

“Modificar” nos permitirá actualizar los datos del contacto:
Cabe destacar que si ponemos el correo de forma incorrecta no nos permitirá actualizarlo.

![7](https://user-images.githubusercontent.com/35973932/52344328-5546ec00-2a12-11e9-985e-945771fa02f7.png)

![8](https://user-images.githubusercontent.com/35973932/52344313-52e49200-2a12-11e9-86a8-39c960035f06.png)

![9](https://user-images.githubusercontent.com/35973932/52344316-52e49200-2a12-11e9-82a7-018945548608.png)

![10](https://user-images.githubusercontent.com/35973932/52344317-537d2880-2a12-11e9-8b5a-969b580d1ee1.png)

“Borrar” nos permitirá eliminar el contacto de la lista:

![11](https://user-images.githubusercontent.com/35973932/52344318-537d2880-2a12-11e9-814b-880ae7041fd3.png)

![12](https://user-images.githubusercontent.com/35973932/52344319-537d2880-2a12-11e9-9f01-72efc404f73a.png)

![13](https://user-images.githubusercontent.com/35973932/52344320-5415bf00-2a12-11e9-92f5-298ac6368e9b.png)
  



 
