# API-Rest-SpringBoot
Ejemplo de aplicación que utiliza una API con protocolo REST, Spring Boot para Java y base de datos local H2


Primero de todo, debemos asegurarnos de que tenemos instalado en nuestro equipo Maven y Postman, ya que serán dos herramientas necesarias para hacer funcionar nuestra API-Rest.

Una vez hecho esto, iremos a la página de Spring Initializr, cuya dirección es ---> https://start.spring.io/
Spring Initializr es la página oficial de Spring Framework que nos permite crear un proyecto de Spring Boot para desarrollar aplicaciones con Spring Framework y Java.
Ahora tendremos que elegir qué características y herramientas vamos a seleccionar para crear nuestro proyecto, así como añadir las dependencias para el mismo.

Éstas son las características y dependencias que seleccionaré para mi proyecto:

![Captura de pantalla (172)](https://github.com/arh91/API-Rest-H2/assets/32130215/9f7cfad4-2dc2-462d-a181-3c9d28858a3b)

Una vez que esté todo configurado, hago click en "Generate".
Se me generará un archivo zip. Elijo una ubicación y lo descomprimo.
Luego voy a IntelliJ y desde allí abriré la carpeta de mi proyecto. Como puedo comprobar, ya se han instalado automáticamente todas las librerías necesarias, gracias a Maven. 
Así me ahorro el tiempo y el esfuerzo de tener que instalarlas manualmente una por una.

Lo siguiente será añadir unas configuraciones adicionales a nuestro proyecto en IntelliJ.
Click en File --> Settings 
Marcamos las siguientes configuraciones:

![Captura de pantalla (173)](https://github.com/arh91/API-Rest-H2/assets/32130215/324ea21f-75c3-424a-8dd9-c520f2816c3d)

![Captura de pantalla (174)](https://github.com/arh91/API-Rest-H2/assets/32130215/069d15f7-5457-431f-8efb-e0ab7b79d429)



Busco la ruta del Maven  que previamente he instalado en mi equipo y la selecciono para mi proyecto:

![Captura de pantalla (175)](https://github.com/arh91/API-Rest-H2/assets/32130215/c7fb48ec-1324-4e78-ade8-c72ff570658a)



A continuación, en el archivo application.properties configuro el acceso a la base de datos, cuál será el nombre de la misma. También le pedimos que cree las tablas correspondientes en nuestra base de datos, si estas no existen. Y asignamos una url para acceder a nuestra base de datos a través del navegador.

![Captura de pantalla (176)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/81bad9f2-b705-4630-8223-a5d50126c938)



Luego, dentro de com.icode.apirest creo un nuevo paquete al que llamaré model. Dentro del paquete model crearé la clase User.
Ésta clase la vamos a mapear como una tabla de nombre Users en nuestra base de datos. Cada uno de los atributos de ésta clase se corresponderán con columnas de dicha tabla.
También generaremos los getters y setters correspondientes.

![Captura de pantalla (177)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/3b5a8827-c731-4214-8916-1467b054385d)

![Captura de pantalla (178)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/9a3e350c-a942-4f5a-b002-cebc05641b59)


Luego, dentro de com.icode.apirest crearemos un nuevo paquete, de nombre repository.
Dentro de éste paquete, creamos una nueva interfaz, a la que llamaremos UserRepository. Ésta interfaz va a extender de la interfaz JpaRepository, la cuál va a recibir dos tipos de datos.
El primer dato que recibirá será la clase a la que se van a aplicar los métodos CRUD, en nuestro caso la clase será User. 
El segundo dato que nos pide es el tipo de dato correspondiente a la variable que está asociada a la clave primaria en nuestra tabla, en nuestro caso la clave primaria sería Id, cuyo tipo de dato es Long. Así que como segundo dato le pasaremos Long.
Es decir, extendemos JpaRepository seguido de <User, Long>.

![Captura de pantalla (179)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/8373241c-061e-4f29-93a8-545b75fb4a3e)


Luego creamos la clase userService, a la cuál añadimos una sereie de métodos CRUD, que a su vez llamarán a los métodos correspondientes de nuestro repositorio UserRepository (métodos que ha heredado de la clase JpaRepository de la cuál extiende).

![Captura de pantalla (180)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/70df601a-2c49-4559-a1ba-eaa6f548ecc4)

A continuación, dentro de com.icode.apirest creamos un nuevo paquete, de nombre controller.
Dentro de éste paquete, crearemos una nueva clase, a la que llamaremos UserController.
Ésta clase expone sus métodos como endpoints para poder ser utilizados por cualquier cliente, para ello antes de la clase debemos asignarle la anotación @RestController.

![Captura de pantalla (185)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/c6aace36-31b6-4405-867f-2239abba546c)

![Captura de pantalla (186)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/1492256c-7ca7-4e01-80f0-17bcd6ef9574)

Una vez terminado de montar mi proyecto, tendré que ejecutar la clase ApiRestApplication.java para que se genere mi base de datos en la dirección que le haya especificado:

![Captura de pantalla (187)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/2c995fad-e137-4af7-96f4-7e8cd41cafff)

A continuación, en el navegador introduzco la url para acceder a mi base de datos (la url que yo configuré en el archivo application.properties de mi proyecto.
Me mostrará la interfaz de acceso a mi base de datos, donde tendré que introducir los datos de acceso (los que haya configurado en appliczation.properties).
![Captura de pantalla (188)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/e3f8c39e-5b37-438a-844c-71fd6c06be98)

Luego al hacer click en Connect, si los datos de acceso son correctos, se me abrirá la interfaz de nuestra base de datos, que tendrá un aspecto como éste:

![Captura de pantalla (189)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/edbc6194-a5aa-4f44-8c91-182de29ae84b)

Si introduzco la sentencia sql para listar los registros de la tabla Users, veremos que en la tabla no hay registros en éste momento:

![Captura de pantalla (190)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/5d6e62d0-13d2-42c3-9a79-79de6cb42b6d)

Ahora abro Postman, creo una nueva colección a la que llamaré Users,  luego click en "New Request", selecciono como tipo de petición POST, luego introduzco la url para acceder a los métodos para operar con la base de datos (>ésta url termina en /users tal y como especifiqué en el parámetro del @RequestMapping de la clase UserController en mi proyecto). después hago click en Body, y después click en Raw y selecciono como formato JSON. En el textArea, introduzco los datos del registro que voy a insertar en formato JSON, en este caso tengo que introducir como datos firstName, lastName y email (el id no tengo que introducirlo ya que lo había configurado en IntelliJ para que mi base de datos me lo genere automáticamente). Una vez haya introducido los datos del registro, hago click en Send para que Postman me lo guarde en la base de datos.

![Captura de pantalla (191)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/891eaa6e-fa4d-4da6-943e-d478ea128c34)

A continuación, voy a la base de datos y vuelvo a ejecutar la sentencia para listar los registros de Users, y veremos como ésta vez sí me aparece en la tabla el registro que acabo de introducir y enviar a través de Postman:

![Captura de pantalla (192)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/a9c92513-ef97-4669-a5f5-cd439ac5516b)

Luego en Postman añado un nuevo registro para la tabla Users y de nuevo click en Send:

![Captura de pantalla (193)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/d64dd66c-56d4-4808-9b59-1059ebddfeab)

Vuelvo a mi base de datos y ejecuto de nuevo la sentencia para listar registros de Users, y vemos que se me ha añadido el registro que acabo de introducir en Postman:

![Captura de pantalla (194)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/4f77c048-818a-4fb4-94c3-6d6e7b43c60d)

Ahora vuelvo a Postman, y desde allí voy a probar a listar todos los usuarios, introduciendo la url que previamente había configurado para ello en mi UserController de mi proyecto, y estableciendo GET como tipo de petición. Click en Send y nos mostrará todos los usuarios que hemos registrado hasta este momento (en nuestro caso 2 registros):

![Captura de pantalla (195)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/f7557e19-43c3-4feb-a248-91442b35a930)

A continuación, en Postman vamos a buscar el usuario que tiene por Id el número 1 (búsqueda de tipo GET):

![Captura de pantalla (197)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/6e201495-7c32-4afa-84c9-245de8642355)

Luego, buscamos el que tiene el numero 2 (búsqueda de tipo GET):

![Captura de pantalla (196)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/59adc4c5-2d2a-4863-a2d1-2173cacfc8d2)

A continuación, voy a borrar el registro de Id número 2 (instrucción de tipo DELETE):

![Captura de pantalla (199)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/9f84ac57-cb67-4d2d-9cb7-7101b96c5b57)

A continuación comprobamos que al pedirle a Postman que me liste de nuevo los registros de la tabla Users, el registro de Id número 2 efectivamente ha sido borrado:

![Captura de pantalla (200)](https://github.com/arh91/API-Rest-SpringBoot/assets/32130215/cd9f7180-99c6-403c-970b-a52c7fcc257a)








