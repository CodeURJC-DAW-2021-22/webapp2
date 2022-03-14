# **FlyVenta**

<div>
<img src="ResourcesLogosLogoReadme.jpeg" width="300px">
<p>
<div>

***
* **Descripción:**
FlyVenta es una aplicación web que nos permitirá vender y comprar artículos de segunda mano. Os preguntaréis por qué otra página de segunda mano si ya hay muchas, FlyVenta omitirá los mensajes con el comprador para así evitar conversaciones odiosas.
Todos los articulos se mandaran por correos, al vendedor no le llegará el dinero hasta que el comprador no confirme el producto y de esta forma evitaremos tener que salir de casa para quedar con una persona desconocida 

* ¿Entonces como podremos pedir a un vendedor que nos lo venda más barato el articulo? 

    - En FlyVenta tendremos una opción para hacer una contraoferta, donde el vendedor puede aceptarla o no.

* ¿Cómo sabra el vendedor la dirección del cliente? 

    - No lo sabrá, pero gracias a trabajar con correos ellos sabran la dirección con el codigo de barras que se tendrá que mostrar en la sucursal.


**¡Empieza a vender desde hoy mismo!**
***

## Equipo de desarrollo
| **Apellidos, Nombre**   | **Correo de la universidad**     | **Cuenta Github** |
|-------------------------|----------------------------------|-------------------|
| Ruiz Morán, Miguel      | m.ruizm.2019@alumnos.urjc.es     | migueelruiiz      |
| Rusu, Samuel            | s.rusu.2019@alumnos.urjc.es      | samuelrusu3       |
| Molinero Mellado, Jaime | j.molinero.2019@alumnos.urjc.es  | Jaiime00          |
| Cardi Pérez, Francis    | f.cardi.2019@alumnos.urjc.es     | Fcardiperez       |

* **Diagrama de navegación fase 2:**

    - Esta es la página principal de la web, desde donde podrá dirigirse al resto de páginas

 ***
* **Capturas de pantalla fase 2:**
    
    - Esta es la página principal de la web, desde donde podrá dirigirse al resto de páginas

    <div>
    <img src="backend\readme\index.PNG" width="300px">
    <div>
     
    - Desde donde nos encargaremos de buscar el producto que nos interesa.
    <div>
    <img src="backend\readme\search.PNG">
    <div>
    

    - Podremos seleccionar el método de pago que no sinteresa, también nos mostrará una breve información del producto seleccionado y el precio final, por último tenemos 2 botones que nos permiten proceder con la pasarela de pago o bien cancelar la compra.
    <div>
    <img src="backend\readme\comprar.PNG">
    <div>


    - Una pantalla de inicio de sesión que permite pasar a la de registro
    <div>
    <img src="backend\readme\login.PNG">
    <div>

    - Página de tu propio perfil donde tendrás los datos introducidos en la página.
    <div>
    <img src="backend\readme\perfil 1.PNG">
    <div>
    <div>
    <img src="backend\readme\perfil 2.PNG">
    <div>
    <div>
    <img src="backend\readme\perfil 3.PNG">
    <div>

    - Página que muestra fotos, descripción y vendedor del producto, por último la opción de comprar o hacer la contraoferta al vendedor. 
    <div>
    <img src="backend\readme\product.PNG">
    <div>

    - Modo dios, solo para ADMIN, donde podra eliminar usuarios y productos. 
    <div>
    <img src="backend\readme\menu admin.PNG">
    <div>

    - contraoferta. 
    <div>
    <img src="backend\readme\Contraoferta.PNG">
    <div>


    - El resumen de la compra
    <div>
    <img src="backend\readme\resumen.PNG">
    <div>

***
* **Diagrama de navegación fase 2:**

    <div>
    <img src="backend\readme\navigationDiagramnew.png">
    <div>

***
* **Diagrama con las entidades de la base de datos::**

    <div>
    <img src="backend\readme\bbdd.png">
    <div>


***
* **Pasos a seguir:**
    - Para poder descargar el código del repositorio, ejecutar y construir la aplicación es necesario tener un IDE que nos permita ejecutar una aplicación web con Spring Boot Maven. En nuestro caso particular, hemos utilizado la versión 2.6.3 de Spring Boot, junto con la última versión 3.8.4 de Maven. También usamos Java 11 para interpretar el código. Asimismo, disponemos de la última versión 12.3 de PostgreSQL para que gestione la base de datos.
    Una vez tenemos todos estos requisitos, desde el IDE crearemos un nuevo proyecto a partir del Control de Versiones, donde nos pedirá la url del repositorio y se clonará. Una vez clonado, solamente hace falta ubicar el archivo .java Application y ejecutarlo para tener acceso al servidor en la url https:localhost:8443


***
* **Participación de los estudiantes** *

    - Francis Cardi: controladores para que las transacciones se lleven a cabo, generación del pdf y envío de email, solución de bugs varios, todo de los perfiles de usuario y admin, y algún retoque a los templates para ajustarse a las funcionalidades. Documentación.

    - Miguel Ruiz: creación de entidades y relaciones entre tablas. Retoques importantes a transacciones y creación de la funcionalidad de contraoferta. Subida y visualización de imágenes, solución de bugs.

    - Jaime Molinero: visualización de varios productos, Pageable, modificación de templates para nuevas funcionalidades, solución de bugs.

    - Samuel Rusu: instalación de base de datos H2, Postgre. Querys para buscar por categoría, título. Seguridad en spring. Documentación.

    Commits más importantes:

    - Incorporación de base de datos con entidades básicas Samuel
    https:github.comCodeURJC-DAW-2021-22webapp2commit9167ec634cfc15124e3ff4849bf86c9fda48db48
    (Fue gradual, no hubo un gran commit porque queríamos tener cuanto antes una versión de la BBDD para progresar)

    - Seguridad en Spring Samuel
    https:github.comCodeURJC-DAW-2021-22webapp2tree7168358bc6c2a1a1ac07c082831d3deb3b540ac7


    - Funcionalidad compra, contraoferta Francis y Miguel

    - https:github.comCodeURJC-DAW-2021-22webapp2commit62100a718c10b5f43de60f7efdcd31b4ce2b58e6
    (he puesto uno por poner, pero aquí fueron muchos commits)

    - Perfiles, modo admin Francis
    https:github.comCodeURJC-DAW-2021-22webapp2treeb4893f81e9cdf75a98dc5b33a86f1be2337a221a

    - Visualización de imágenes. https:github.comCodeURJC-DAW-2021-22webapp2treecae7946cec8b046957d6b8ab4dfc1e4985a1bda3
