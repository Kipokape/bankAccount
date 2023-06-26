# bankAccount
Два REST-сервиса для генерации случайных банковских аккаунтов и сохранения их в БД

bankAccountGenerator генерирует аккаунты со случайными данными, ФИО берутся из соответствующих файлов по пути bankAccountGenerator/src/main/resources/NamesForBankAccounts.

bankAccountLoader делает запрос к первому сервису и сохраняет полученный акккаунт в БД (используется PostgeSQL, конфигурация в bankAccountLoader/src/main/resources/application.properties), если UUID и номер уникальны.

GET http://localhost:8080/bankAccountGenerator/ - Запрос для генерации аккаунта со случайными данными

GET http://localhost:8081/bankAccountLoader/ - Запрос на сохранение аккаунта (получается запросом к первому сервису) в БД
