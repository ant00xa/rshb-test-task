# Тестовое задание для РСХБ-Интех

### Get started
- Запускаем контейнер с PostgreSQL (необходим установленный Docker и Docker-compose)
```shell
docker-compose up
```  
- Запускаем приложение


### Задание
Необходимо написать java-приложение, которое обладает функционалом ниже:

1. По команде пользователя создает описанные выше таблицы в заданной базе данных и наполняет их тестовыми данными (генерация случайным образом, обязательные коды этапов должны присутствовать);
```
// Реализовал через Configuration LoadDatabase
```

2. Определяет, сколько заявок определенного субпродукта не дошло до шага верификации в текущий момент (субпродукт определяется пользователем);
```http request
[GET] http://localhost:8080/v1/credit-apps/not-vrf?subproduct=SP_P2_0001
```   

3.	Определяет пять самых популярных продуктов по заявкам, поступившим в определенный временной интервал (интервал определяется пользователем);
```http request
[GET] http://localhost:8080/v1/products/top?app-date-start=01.10.2021&app-date-end=25.10.2021

// В целом логика реализована, но не хватило времени на отладку и решение проблемы с конвертацией из нативного запроса в CreditAppRepository.findProductsTopByAppTimestampBetween
```   

4.	Определяет номера заявок на этапе принятия решения, которые находятся на нем более указанного количества суток (количество суток определяется пользователем);
```http request
[GET] http://localhost:8080/v1/credit-apps/expired-dsc?days=0
```

5. Определяет, в каком состоянии в данный момент находится определенная заявка (номер заявки определяет пользователь). В результате данной операции, система должна ответить на вопросы ниже (формат вывода по своему усмотрению):
      5.1.	Заявка входила в систему? Если «да», то, когда именно?
      5.2.	Какие этапы прошла заявка? Когда начинались и завершались этапы и с каким результатом?
      5.3.	На каком этапе в данный момент находится заявка?
```http request     
[GET] http://localhost:8080/v1/credit-app/1/steps

// Реализован только базовый карткас, не хватило времени на полную реализацию и отладку

Логика формата вывода предусматривалась следующая:
- возвращаем список этапов для конкретной заявки, если он не пустой - значит заявка заходила в систему и timestamp первого этапа будет отвечать на вопрос когда
- в этапе есть поля начала, завершения и результата
- по последнему элементу данного контейнера также можно понять на каком этапе сейчас заявка
```

Дополнительно:
Произошел сбой и номера заявок в стартовой таблице перестали быть уникальными (произошло дублирование заявок). Необходимо написать SQL-запрос, который бы удалял из таблицы T_START дубли, оставляя при этом сами заявки в единственном экземпляре.
```
Реализовал sql запрос в delete-duplicates-t-start.sql
```