# API REPORT
Api para generacion de reportes 

## Descripcion

Reportes como:

●Usuarios Pedidos

●Items por Nombre del item 

●Ordenes por orderRef , orderStatus , storeName
## Getting Started

### Dependencias

* Es necesario el uso de Docker para poder consumir las imagenes docker de Mongo y de RabbitMQ para el correcto funcionamiento del microservicio

### Instalacion

* How/where to Get ,Git , Java 17 , Intelij Community Edition and Maven


### Ejecutar el programa

* How to run the program
```
By MVN 
or 
InteliJ Cumunitty
```


### Operaciones
*Usuarios Pedidos
  * POST http://localhost:8085/report/users
    * Body
```
   ReportePedidosUsuarios

```
* Items por Nombre del item
  * POST http://localhost:8085/report/item
      * Body
```
{
    "search": "levi"
}
```

* POST http://localhost:8085/report/order
    * Body
```
    {
    "orderRef": "",
    "orderStatus": "",
    "storeName": "L  SANTA FE"
    }
```

## Authors

Contributors names and contact info

ex. Sergio Granados 
ex. [sergio.daniel.granados@hotmail.com](sergio.daniel.granados@hotmail.com)

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Conocimientos

Recursos
* [Items](https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/items)
* [Pedidos](https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/pedidos)