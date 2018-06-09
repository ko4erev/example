/POST /page
---
HOST: localhost
---
Небольшой REST сервис с функционалом:

Входные данные:
```
Строка
```

Выходные данные:
```
Массив из строк
```

При обращении на url http://localhost:8081/page POST запросом,с указанием в теле запроса любую строку,строка разворачивается в обратную последовательность,
сохраняется в базе данных(в данном примере postgres) и возвращяется массив развернутых строк.
---
DDL для создания таблицы в postgres:
---
```
CREATE TABLE ad.example (
    id serial NOT NULL,
	value varchar(20) NOT NULL,
	CONSTRAINT example_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;
```
---
Проверить сервис возможно с помощью утилиты curl,пример запроса и ответ:
---
Запрос:
```
curl -H "content-type:application/json" -X POST -d 'Message' http://localhost:8081/page
```
Ответ:
```
["gnirtS","egasseM","tseT","tseT","tseT","tseT","egasseM","egasseM","tseT","tseT","egasseM","egasseM","egasseM","egasseM","egasseM"]%
```

Настройки для базы данных из конфигурационного файла удалены.
