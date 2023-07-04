# bankAccount
Другая логика работы с использованием Kafka

bankAccountGenerator генерирует аккаунты со случайными данными, ФИО берутся из соответствующих файлов по пути bankAccountGenerator/src/main/resources/NamesForBankAccounts. Затем отправляет их в topic bank-account-topic.

bankAccountLoader делает запрос к первому сервису, подписывается на bank-account-topic и читает последнее поступившее сообщение, десериализирует его, затем сохраняет полученный акккаунт в БД (используется PostgeSQL, конфигурация в bankAccountLoader/src/main/resources/application.properties), если UUID и номер уникальны.

GET http://localhost:8080/bankAccountGenerator/ - Запрос для генерации аккаунта со случайными данными

GET http://localhost:8081/bankAccountLoader/ - Запрос на сохранение аккаунта (получается запросом к первому сервису) в БД

Настройки Kafka и Zookeeper в docker-compose.yml, параметры producer и consumer в соответствующих классах и файлах application.properties
