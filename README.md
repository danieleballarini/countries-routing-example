# Countries Routing Example

## Features

The backend implementing the REST API was implemented using Spring.

The frontend was implemented as single page application (SPA) using React.

The IDE used was IntelliJ IDEA CE and Java 8.

### Base

- Implemented REST API method to get list of countries ( /api/countries )
```sh
/api/countries
```  
- Implemented SPA to show list of countries with frontend pagination

### Bonus

- Implemented basic authentication to secure REST API (sample credentials: user/password )
- Implemented backend pagination for REST API; added page query parameter and max query parameter:
```sh
/api/countries?page=5&max=10
```

## Getting Started

### Download

```sh
git clone https://github.com/danieleballarini/countries-routing-example.git
```


### Build

To build the distribution package execute the following commands

```sh

mvn clean package

```


### Run

To run locally execute the following commands

```sh

mvn spring-boot:run

```

then in the browser go to

```

http://localhost:8080/index.html

```

Invoke REST API

with basic authentication

```sh
curl --user user:password http://localhost:8080/api/countries?page=5&max=10
```

with pagination

```sh
curl --user user:password http://localhost:8080/api/countries?page=5&max=10
```