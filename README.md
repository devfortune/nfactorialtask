## Требования
- Docker
- Docker Compose
- Docker Desktop (for Windows)

## Установка и запуск
1. Клонируйте репозиторий:
   git clone <repository-url>
   cd project
2. docker-compose up --build
3. Приложение будет доступно по следующим адресам:
Backend: http://localhost:8080
Frontend: http://localhost:3000


## Процесс
Процесс написания проекта начался с построения backend части, что было заняло у
меня много времени. Если поэтапно описать:
1. Сначала я занялся созданием domain entities: User, Event, Registration, Booking. Эти
entities - основные компоненты, которые нужны для манипулирования данными. Я
также создал UserLogin и User Signup классы для передачи данных в механизм
регистрации и входа - они играют роль DTO (Data Transfer Objects). Стоит отметить,
что в самом начале domain entities было меньше, но чем дальше углублялся в проект,
тем больше по нужде добавлял новые классы.
2. Следом сразу же создал repository и service пакеты. Добавил туда соответствующие
классы для имплементации взаимодействия с базой данных и бизнес логики.
3. Затем, я написал endpoints для обработки HTTP запросов, иначе говоря, создал
контроллеры для моего REST API: EventController, RegistrationController,
BookingController.
4. Создал захардкоденный DataLoader класс, который заполняет базу данных
придуманными данными в виде мероприятий. Класс запускается сразу же после
запуска бекенда.
5. После тщательной проверки работоспособности серверной части проекта, начал
заниматься security для аутентификации и авторизации. Честно говоря, эта часть для
меня была самой сложной и муторной, так как создавала еще куча проблем при
общении с фронтендом. Соответственно, дальше я сконфигурировал security для
эндпоинтов, создал логику передачи JWT и JWTFilter.
6. Тестер в виде Postman подтвердил работоспособность эндпоинтов, а значит осталось
доделать frontend.
7. Для написания frontend я использовал фреймворк React, создав соответствующие
компоненты для эндпоинтов. В каждом компоненте я настроил связь с бекенд
эндпоинтами.

## Функционал и логика
1. Пользователь может просматривать все предстоящие мероприятия;
2. Пользователь может просматривать детали мероприятий посредством нажатия
кнопки “Подробнее”;
3. Пользователь может забронировать определенное количество билетов без
регистрации;
4. Количество билетов уменьшается при бронировании;
5. Регистрация пользователя:
1) с проверкой уже существования на базе;
2) с проверкой пароля (подтверждение пароля);
3) валидация данных (имя, фамилия, никнейм, пароль не могут быть пустыми,
пароль должен быть в диапазоне 6-20 символов);
6. Пользователь может управлять своими бронированиями:
1) посмотреть детали в своем профиле;
2) сделать возврат билетов;
Использованные технологии:
 Backend: Java, Spring Boot, Maven, Spring Data JPA, Spring Security, Hibernate
 Frontend: React, Node.js, npm
 База данных: H2 (In-Memory)
 Контейнеризация: Docker, Docker Compose

## Сложности
Было трудно настроить взаимодействие между backend и frontend. Выходила ошибка
CORS из-за подключенного Spring Security, что в итоге не позволило доделать
функционал “Забронировать” на фронтенде, при нажатии кнопки с фронта выходит
ошибка, хотя все работает через postman.
