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

 

Para añadir un contacto le daremos al menú sidebar de la esquina superior derecha, y nos saldrá la opción de “Nuevo”, la cual nos llevará a la actividad de Registrar usuario:

 

Introducimos los datos del contacto que queramos añadir. El correo habrá que introducirlo de forma correcta, de lo contrario no nos permitirá añadirlo. Una vez todo puesto correctamente nos añadirá al contacto y se quitarán los datos puestos, y podremos añadir todos los contactos que queramos.

  


 


Y se nos mostrarán en la lista principal:

 
Si mantenemos el contacto pulsado nos saldrán dos opciones:

“Modificar” nos permitirá actualizar los datos del contacto:
Cabe destacar que si ponemos el correo de forma incorrecta no nos permitirá actualizarlo.

 

  



 








“Borrar” nos permitirá eliminar el contacto de la lista:

  



 
