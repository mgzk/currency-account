# Build and run

### `mvn clean install`

### `mvn spring-boot:run`

# REST API

## Example requests

### 1. Create account

`curl --location --request POST 'http://localhost:8080/accounts' --header 'Content-Type: application/json' --data-raw '{"firstName": "Jan","lastName": "Kowalski","initialBalance": {"amount": "100","currency": "PLN"}}'`

### 2. Get account details

`curl --location --request GET 'http://localhost:8080/accounts/9141c4bf-8c14-4ffd-8a17-1e98c4b7fc74'`

### 3. Exchange currency

`curl --location --request POST 'http://localhost:8080/accounts/9141c4bf-8c14-4ffd-8a17-1e98c4b7fc74/exchanges' --header 'Content-Type: application/json' --data-raw '{"amount": 50,"sourceCurrency": "PLN","destinationCurrency": "USD"}'`
