# MercadoLibre

# Ejecucion del proyeto
Se necesita JDK 11

Clonar el repositorio 
-git clone https://github.com/AleGareca/MercadoLibre.git

Metodo por consola::
Ingresar por consola a la carpeta del proyecto y ejecutar el siguiente codigo
-mvn spring-boot:run

Metodo por IDE::
Ejecutar la clase DemoApplication
# Detalle de la solución
Para consultar la Api de mercado libre se utilizo una clase RestTemplate de la libreria sprintboot web client, ademas, para crear las urls se utilizo una clase UriComponent (sprintboot web utils).
Se crearon varios dtos para traer los datos que solo serían de utilidad para el ejercicio
Los serviciós son los que crean en gran parte la solución y los que implementan alguna algoritmia para la manipulación de datos
El promedio de todas las marcas de motos se realiza mediante paralelismo al tener que buscar en la api toda la información relacionada a una marca de moto en específico 

![Diagram](https://user-images.githubusercontent.com/37850570/125517030-1e009b5e-414e-4a85-9ff1-921495db6205.png)

# Requerimientos
Se solicita crear un programa que liste marcas de motos, junto al precio promedio de todas las motos publicadas en mercadolibre para cada marca. Para ello se utilizará la api publica de mercadolibre.
Los pasos a realizar son los siguientes:

Obtener el id de la categoría de motos (no es necesario que el programa haga este paso, pero si hay que hacerlo manualmente):
https://developers.mercadolibre.com.ar/es_ar/categorias-y-publicaciones

Una vez obtenido ese id (podemos hardcodear este id en el programa), lo utilizaremos para listar todas las motos publicadas:

https://developers.mercadolibre.com.ar/es_ar/items-y-busquedas

Para cada marca de moto (ej: Kawasaki, Yamaha, Honda) obtener el promedio de precio de todas las motos de esa marca.
Para el cálculo de este promedio solo deben utilizarse las motos que sean nuevas (no usadas).
Mercadolibre devuelve la información paginada (paginar hasta el registro 900), llamar a cada página de forma secuencial se considera una solución correcta pero se valora el uso de paralelismo.
Imprimir por consola una lista de marcas de motos junto con el promedio de precio para cada marca.
Una vez realizado este ejercicio subirlo a un repositorio público de github (o similar) y enviarnos la URL. También sirve que nos mandes el archivo comprimido con el proyecto, sin embargo también en este caso manda un mail sin adjunto avisando, por las dudas al mail con adjunto lo filtre el antivirus.


