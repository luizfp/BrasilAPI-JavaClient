<h1 align="center"><img src="https://raw.githubusercontent.com/BrasilAPI/BrasilAPI/master/public/brasilapi-logo-small.png"> Brasil API</h1>

<div align="center">
  <p>
    <strong>Vamos transformar o Brasil em uma API?</strong>
  </p>
</div>

## Atenção
Este é o cliente Java **não oficial** da <a href="https://github.com/BrasilAPI/BrasilAPI" target="_blank">BrasilAPI</a>!

## Como utilizar

Existem duas formas de utilizar a API.

#### Caso você precise do retorno direto:
``` java
final BrasilApi brasilApi = new BrasilApi.Builder()
        .withNetworkTimeout(Duration.ofSeconds(30))
        .build();

final Optional<Address> address = brasilApi
        .findByCep("05010000")
        .execute();
```

#### Caso você prefira callbacks de retorno:
``` java
final BrasilApi brasilApi = new BrasilApi.Builder()
        .withNetworkTimeout(Duration.ofSeconds(30))
        .build();

brasilApi.findByCep("05010000")
        .doOnSuccess(address -> {

        })
        .doOnError(error -> {

        })
        .execute();
```