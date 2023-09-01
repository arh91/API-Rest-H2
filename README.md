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





