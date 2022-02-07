# REST API Inditex application

Price Api REST for Inditex exercise.

I use `Java 11` and `Spring Boot`.

can check all dependencies used inside pom.xml

## Install

    mvn clean install

## Compile

    mvn compile

## Run the tests

    mvn test

# REST API

The REST API to the example app is described below.

## Get specific price

### Request

`GET /prices`

    curl --location --request GET 'localhost:8080/prices?date=2020-06-15T10:00:00&brand=1&product=35455' \

###Params

date:`String` (ISO_LOCAL_DATE_TIME) 
example: `2020-04-01T20:00:00`

brand: `Integer` Brand ID

product: `Integer` Product ID

### Response
example:

    status: 200
    {
        "brandId": 1,
        "startDate": "2020-06-15T00:00:00",
        "endDate": "2020-06-15T11:00:00",
        "priceListId": 2,
        "productId": 3,
        "amount": 25.15,
        "currency": "USD"
    }

## Exercise Requirements

####Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

`Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.`

`Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).`

`Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo`



## Requested Test

You can validate requested test running the tests in PriceServiceTest file.

