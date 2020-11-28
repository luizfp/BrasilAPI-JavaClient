<h1 align="center"><img src="https://raw.githubusercontent.com/BrasilAPI/BrasilAPI/master/public/brasilapi-logo-small.png"> Brasil API</h1>

<div align="center">
  <p>
    <strong>Vamos transformar o Brasil em uma API?</strong>
  </p>
</div>

## Atenção
Este é o cliente Java **não oficial** da <a href="https://github.com/BrasilAPI/BrasilAPI" target="_blank">BrasilAPI</a>!

## Progress 
- [x] Criar API de busca por CEP
- [x] Permitir parametrizar configurações da conexão
- [x] Implementar tratamento de erros
- [X] Implementar sistema de logs HTTP
- [ ] Desenvolver testes

## Como utilizar

Existem duas formas de utilizar a API.

#### Caso você precise do retorno direto:
``` java
final BrasilApi brasilApi = new BrasilApi.Builder()
        .withNetworkTimeout(Duration.ofSeconds(30))
        .build();

final Address address = brasilApi
        .findByCep("05010000")
        .doOnError(error -> {

        })
        .thenReturning();
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

#### Habilitando logs HTTP:
``` java
final BrasilApi brasilApi = new BrasilApi.Builder()
        .withNetworkTimeout(Duration.ofSeconds(30))
        .withHttpLogLevel(HttpLogLevel.BODY)
        .withHttpLogsEnabled(true)
        .build();
```

Exemplo de log de sucesso:
```
16:22:40.067 [main] DEBUG BrasilAPI - --> GET https://brasilapi.com.br/api/cep/v1/05010000
16:22:40.070 [main] DEBUG BrasilAPI - --> END GET
16:22:40.408 [main] DEBUG BrasilAPI - <-- 200 OK https://brasilapi.com.br/api/cep/v1/05010000 (337ms)
16:22:40.408 [main] DEBUG BrasilAPI - Date: Sat, 28 Nov 2020 18:22:40 GMT
16:22:40.408 [main] DEBUG BrasilAPI - Content-Type: application/json; charset=utf-8
16:22:40.408 [main] DEBUG BrasilAPI - Transfer-Encoding: chunked
16:22:40.408 [main] DEBUG BrasilAPI - Connection: keep-alive
16:22:40.408 [main] DEBUG BrasilAPI - Set-Cookie: __cfduid=d5e21545ff08730e773fde9d22caaecf11606587760; expires=Mon, 28-Dec-20 18:22:40 GMT; path=/; domain=.brasilapi.com.br; HttpOnly; SameSite=Lax
16:22:40.408 [main] DEBUG BrasilAPI - cache-control: max-age=0, public
16:22:40.408 [main] DEBUG BrasilAPI - access-control-allow-origin: *
16:22:40.408 [main] DEBUG BrasilAPI - access-control-allow-credentials: true
16:22:40.408 [main] DEBUG BrasilAPI - x-vercel-cache: HIT
16:22:40.408 [main] DEBUG BrasilAPI - age: 9342
16:22:40.408 [main] DEBUG BrasilAPI - x-vercel-id: gru1::sfo1::kl7g7-1606587760369-52cd32467278
16:22:40.408 [main] DEBUG BrasilAPI - strict-transport-security: max-age=63072000
16:22:40.408 [main] DEBUG BrasilAPI - CF-Cache-Status: DYNAMIC
16:22:40.408 [main] DEBUG BrasilAPI - cf-request-id: 06b1b0d6e80000f617daad8000000001
16:22:40.408 [main] DEBUG BrasilAPI - Expect-CT: max-age=604800, report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"
16:22:40.408 [main] DEBUG BrasilAPI - Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report?s=ezu6EUCLLGCAmeKO3dkLYteJq44SQi6jI87DFdx6ijH56mgWHit7IMDmyez2DITccnJQ2%2FA0qitP6I6bD4cwhAoQGRTP2nia3ZUzkSC%2FNyGt"}],"group":"cf-nel","max_age":604800}
16:22:40.408 [main] DEBUG BrasilAPI - NEL: {"report_to":"cf-nel","max_age":604800}
16:22:40.408 [main] DEBUG BrasilAPI - Server: cloudflare
16:22:40.408 [main] DEBUG BrasilAPI - CF-RAY: 5f961d9e4825f617-GRU
16:22:40.410 [main] DEBUG BrasilAPI - 
16:22:40.410 [main] DEBUG BrasilAPI - {"cep":"05010000","state":"SP","city":"São Paulo","neighborhood":"Perdizes","street":"Rua Caiubi"}
16:22:40.410 [main] DEBUG BrasilAPI - <-- END HTTP (99-byte body)
```

Exemplo de log de erro:
```
16:25:49.306 [main] DEBUG BrasilAPI - --> GET https://brasilapi.com.br/api/cep/v1/0501000022
16:25:49.308 [main] DEBUG BrasilAPI - --> END GET
16:25:50.005 [main] DEBUG BrasilAPI - <-- 400 Bad Request https://brasilapi.com.br/api/cep/v1/0501000022 (696ms)
16:25:50.005 [main] DEBUG BrasilAPI - Date: Sat, 28 Nov 2020 18:25:49 GMT
16:25:50.005 [main] DEBUG BrasilAPI - Content-Type: application/json; charset=utf-8
16:25:50.005 [main] DEBUG BrasilAPI - Content-Length: 204
16:25:50.005 [main] DEBUG BrasilAPI - Connection: keep-alive
16:25:50.005 [main] DEBUG BrasilAPI - Set-Cookie: __cfduid=d39c2ce04ac94c82a6e43e058d43fadc91606587949; expires=Mon, 28-Dec-20 18:25:49 GMT; path=/; domain=.brasilapi.com.br; HttpOnly; SameSite=Lax
16:25:50.005 [main] DEBUG BrasilAPI - cache-control: max-age=0, s-maxage=86400, stale-while-revalidate, public
16:25:50.005 [main] DEBUG BrasilAPI - access-control-allow-origin: *
16:25:50.005 [main] DEBUG BrasilAPI - access-control-allow-credentials: true
16:25:50.005 [main] DEBUG BrasilAPI - x-vercel-cache: MISS
16:25:50.005 [main] DEBUG BrasilAPI - age: 0
16:25:50.005 [main] DEBUG BrasilAPI - x-vercel-id: gru1::sfo1::kl7g7-1606587949600-489d99506b9f
16:25:50.005 [main] DEBUG BrasilAPI - strict-transport-security: max-age=63072000
16:25:50.005 [main] DEBUG BrasilAPI - CF-Cache-Status: DYNAMIC
16:25:50.005 [main] DEBUG BrasilAPI - cf-request-id: 06b1b3ba180000f758113ae000000001
16:25:50.005 [main] DEBUG BrasilAPI - Expect-CT: max-age=604800, report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"
16:25:50.005 [main] DEBUG BrasilAPI - Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report?s=%2F1603wIZt9g08m5vRKXGGN03XXIh3LY0G%2BuCM1D99p3cHqkYb8GYou5AzK1uAcJIpYvF2ze1jipaLkvCL7gESPCtwgqQ4354OwFw%2B1fk2nV5"}],"group":"cf-nel","max_age":604800}
16:25:50.005 [main] DEBUG BrasilAPI - NEL: {"report_to":"cf-nel","max_age":604800}
16:25:50.005 [main] DEBUG BrasilAPI - Server: cloudflare
16:25:50.005 [main] DEBUG BrasilAPI - CF-RAY: 5f96223cfdc8f758-GRU
16:25:50.007 [main] DEBUG BrasilAPI - 
16:25:50.007 [main] DEBUG BrasilAPI - {"name":"CepPromiseError","message":"CEP deve conter exatamente 8 caracteres.","type":"validation_error","errors":[{"message":"CEP informado possui mais do que 8 caracteres.","service":"cep_validation"}]}
16:25:50.007 [main] DEBUG BrasilAPI - <-- END HTTP (204-byte body)
```

Utilize `HttpLogLevel.BASIC` caso você queira logs mais enxutos:
```
16:27:55.484 [main] DEBUG BrasilAPI - --> GET https://brasilapi.com.br/api/cep/v1/05010000
16:27:55.908 [main] DEBUG BrasilAPI - <-- 200 OK https://brasilapi.com.br/api/cep/v1/05010000 (421ms, unknown-length body)
```
```
16:28:28.868 [main] DEBUG BrasilAPI - --> GET https://brasilapi.com.br/api/cep/v1/0501000022
16:28:29.422 [main] DEBUG BrasilAPI - <-- 400 Bad Request https://brasilapi.com.br/api/cep/v1/0501000022 (551ms, 204-byte body)
```

Acesse a classe <a href="https://github.com/luizfp/BrasilAPI-JavaClient/blob/dev/src/main/java/br/com/brasilapi/javaclient/log/HttpLogLevel.java" target="_blank">HttpLogLevel</a> para mais informações sobre os níveis de logs.
