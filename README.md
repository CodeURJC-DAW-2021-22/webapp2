# **FlyVenta**

<div>
<img src="Resources\Logos\LogoReadme.jpeg" width="300px">
</p>
</div>

***
* **Descripción:**
FlyVenta es una aplicación web que nos permitirá vender y comprar artículos de segunda mano. Os preguntareis porque otra página de segunda mano si ya hay muchas, FlyVenta omitirá los mensajes con el comprador y a si evitar conversaciones odiosas.

* ¿Entonces como podremos pedir a un vendedor que nos lo venda más barato el articulo? 

    - En FlyVenta tendremos una opción para hacer una contraoferta, donde el vendedor puede aceptarla o no.


**¡Empieza a vender desde hoy mismo!**
***

## Equipo de desarrollo
| **Apellidos, Nombre**   | **Correo de la universidad**     | **Cuenta Github** |
|-------------------------|----------------------------------|-------------------|
| Ruiz Morán, Miguel      | m.ruizm.2019@alumnos.urjc.es     | migueelruiiz      |
| Rusu, Samuel            | s.rusu.2019@alumnos.urjc.es      | samuelrusu3       |
| Molinero Mellado, Jaime | j.molinero.2019@alumnos.urjc.es  | Jaiime00          |
| Cardi Pérez, Francis    | f.cardi.2019@alumnos.urjc.es     | Fcardiperez       |

## Trello para la coordinación del equipo

https://trello.com/b/Asdin3o1/proyecto

## Aspectos principales de la aplicación:


***
* **Entidades:**
    - Usuario: tendrá la posibilidad de subir anuncios, venderlos aceptando ofertas o directamente tras la compra de otro usuario, y comprar uno mismo otros productos anunciados con la posibilidad de realizar contraofertas (siempre que se haya registrado), adicionalmente se podrá buscar y visualizar todos los anuncios disponibles en la web.

    - Anuncio: estará relacionado con un usuario el cual será su vendedor.

    - Compraventa: tendrá relación junto a dos usuarios, un comprador y un vendedor y junto a un anuncio.

    - Contraoferta: estará asociada junto a un usuario que sea el que la realice y un anuncio en base al cual se desee discutir el precio.

***
* **Permisos de los usuarios:**

    - Usuario anónimo: podrá únicamente visualizar los anuncios de los usuarios registrados.

    - Usuario registrado: será dueño de los anuncios, compraventas (tanto como vendedor como comprador) y de las contraofertas de otros usuarios hacia sus anuncios, y tendrá la posibilidad de visualizar el resto de anuncios de otros usuarios, modificar los suyos (así como eliminarlos) o rechazar y aceptar contraofertas.

    - Usuario administrador: será dueño de las tres entidades pero con la posibilidad de modificar cada uno de ellas.

***
* **Imágenes:**

    - Usuario: los usuarios registrados tendrán la posibilidad de subir una foto para establecerla como foto de perfil.

    - Anuncio: los anuncios deberán contener al menos una imagen, subida por el usuario vendedor, de manera que se visualice el estado del producto.

***
* **Graficos:**

    - La página web incluirá un gráfico de barras que muestre la cantidad de productos por categoría en la página principal.

***
* **Tecnología complementaria:**

    - Cuando un usuario realice una contraoferta o compre directamente un producto (anuncio), se mandará un correo al vendedor de dicho producto para, que rechace o acepte la contraoferta o sea notificado correctamente de la venta en cada caso.

***
* **Algoritmo o consulta avanzada:**

    - A la hora de registrarse como usuario, se deberá elegir entre una y tres categorías de interés en base a la cual se le mostrarán diferentes anuncios en la pagina de inicio a dicho usuario. Cada anuncio deberá pertenecer a una categoría para facilitar el uso de esta funcionalidad. 
    