# API Rest para o app TradeMapClone destinado a Mentoria da Digital Inovation One

API para simular funcionalidades do TradeMap com integração ao Kafka para mostrar em tempo real valores das ações da B3.

Tecnologias utilizadas na API:
- Spring Boot 2
- Spring Data
- Spring for Kafka
- PostgreSQL

Aplicações envolvidas:
- API Rest: escrita em Java e Spring Boot com endpoints para simular funcionalidades do TradeMap
- API para coletar ações da B3: escrita em Python com Flask utilizando a lib do Yahoo Finances (https://finance.yahoo.com/)
- Docker:
  - Arquivo do docker compose para subir o broker Kafka
  - Arquivo do docker compose para subir o Postgres
  - Arquivo do docker compose para subir a API em Flask
  
  
### Como executar a aplicação

- Broker do Kafka (dentro da pasta arquivos-docker):
```sh
$ docker-compose -f docker-compose-kafka.yml up -d
```
- Postgres (dentro da pasta arquivos-docker):
```sh
$ docker-compose -f docker-compose-postgres.yml up -d
```
- API Flask com YahooFinances (dentro da pasta api-flask-consulta-yahoo-b3:
```sh
$ docker-compose up -d
```
Dentro da pasta api-flask-consulta-yahoo-b3 ainda possui um script em Python para consumir dados do Kafka para você testar a sua aplicação.
```sh
$ python3 consumer-teste-kafka.py
```
