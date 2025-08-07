# Проект по автоматизации тестирования сайта "[Читай-город](https://www.chitai-gorod.ru/)"
<p align="center">
<img title="chitai-gorod" src="//upload.wikimedia.org/wikipedia/commons/thumb/d/d4/%D0%9B%D0%BE%D0%B3%D0%BE-2_%D1%81%D0%B8%D0%BD%D0%B8%D0%B93.jpg/250px-%D0%9B%D0%BE%D0%B3%D0%BE-2_%D1%81%D0%B8%D0%BD%D0%B8%D0%B93.jpg">
</p>

<p align="left">
«Читай-город» — это самая большая в России сеть книжных магазинов и интернет-магазин. Компания входит в объединённую розничную сеть «Читай-город» — «Гоголь-Моголь» — «Буквоед».
Помимо книг в «Читай-город» можно найти канцтовары, сладости, подарочную упаковку и идеи для сюрпризов близким. Мы сами разрабатываем дизайны для многих ежедневников, закладок, товаров для творчества и других интересных вещей, поэтому кроме как в «Читай-город» их больше нигде не найти.
</p>

## :pushpin: Содержание:

- [Технологии и инструменты]()
- [Примеры автоматизированных тест-кейсов]()
- [Настройки для запуска тестов локально и удаленно]()
- [Сборка в Jenkins]()
- [Пример Allure-отчета]()
- [Уведомления в Telegram о результатах прохождения тестов]()

##  Технологии и инструменты
<p align="center">
<a href="https://www.java.com/"><img width="5%" title="Java" src="media/icon/Java.svg"></a>
<a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/icon/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="5%" title="JUnit5" src="media/icon/JUnit5.svg"></a>
<a href="https://selenide.org/"><img width="5%" title="Selenide" src="media/icon/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="5%" title="Selenoid" src="media/icon/Selenoid.svg"></a>
<a href="https://rest-assured.io/"><img width="5%" title="REST-Assured" src="media/icon/RestAssured.svg"></a>
<a href="https://github.com/"><img width="5%" title="GitHub" src="media/icon/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="5%" title="Jenkins" src="media/icon/Jenkins.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="5%" title="Allure Report" src="media/icon/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/icon/AllureTestOps.svg"></a>
<a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/icon/Intelij_IDEA.svg"></a>
<a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="media/icon/Telegram.svg"></a>
</p>

Автотесты UI/API написаны на языке `Java` с использованием `Selenide`, `JUnit5`  и применением паттерна Page Object.\
`Gradle` - сборщик проекта.  \
`JUnit5` - фреймворк для выполнения тестов.\
`REST Assured` - тестирование REST-API сервисов.\
`Jenkins` - CI/CD для удаленного запуска тестов.\
`Selenoid` - удаленный запуск браузера.\
`Allure Report` - визуализация результатов прохождения тестов.\
`Allure TestOps` - система управления тестированием.\
`Telegram Bot` - уведомлений о результатах тестирования в мессенжер.
## О проекте
- [x] Тестовый проект состоит из UI и API автотестов
- [x] Используется паттерн `Page Object` для проектирование UI-тестов
- [x] Используется `Lombok` для работы с моделями в API тестах
- [x] Используется request/response `спецификации` для API тестов
- [x] Используется Custom Allure listener для API requests/responses логирования
- [x] Реализована интеграция с `Allure TestOps`
- [x] Используется `Jenkins` для удаленного запуска тестов по тегам


##  Примеры автоматизированных тест-кейсов
-  WEB
    -  E2E Добавление книги в корзину и переход к оплате
    -  Проверка отображения верхнего меню
    -  Проверка отображения дерева каталога
    -  Проверка отображения доступных страниц
-  API
    -  Получение сессионного токена авторизации для работы с сервисом
    -  Добавление товара в корзину
    -  Удаление товара из корзины
    -  Изменения количества выбранного товара в корзине
    -  Проверка наполнения корзины

### *Локальный запуск:*
аа
### *Удалённый запуск через Jenkins:*
аа
### *Параметры сборки Jenkins:*
аа
## <img src="media/icon/Jenkins.svg" title="Jenkins" width="4%"/> <a href="LINK/">Сборка в Jenkins для UI тестов</a>
<p align="center">
<img title="Jenkins Build UI" src="media/СКРИНШОТ">
</p>

## <img src="media/icon/Allure_Report.svg" title="Allure Report" width="4%"/> <a href="LINK/">Пример Allure-отчета</a>
### *Общая информация*
<p align="center">
<img title="Allure Overview" src="media/СКРИНШОТ">
</p>

### *Тест-кейсы*
<p align="center">
<img title="TestCases" src="media/СКРИНШОТ">
</p>

## <img src="media/icon/Jenkins.svg" title="Jenkins" width="4%"/> <a href="LINK/">Сборка в Jenkins для API тестов</a>
<p align="center">
<img title="Jenkins Build API" src="media/СКРИНШОТ">
</p>

## <img src="media/icon/Allure_Report.svg" title="Allure Report" width="4%"/> <a href="LINK/">Пример Allure-отчета</a>
### *Общая информация*
<p align="center">
<img title="Allure Overview" src="media/СКРИНШОТ">
</p>

### *Тест-кейсы*
<p align="center">
<img title="TestCases" src="media/СКРИНШОТ">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icon/Telegram.svg"> Уведомления в Telegram с использованием бота
<p align="center">
<img width="70%" title="Telegram notification" src="media/СКРИНШОТ">
</p>