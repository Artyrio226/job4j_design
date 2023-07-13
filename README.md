   
   2.1.0. Maven
1. Обзор блока "Структуры данных и алгоритмы"
2. Настройка окружения для Maven.
3. Создание проекта через maven.
4. Maven. Обзор.

   2.1.1. AssertJ
1. Инструменты.
2. Подключение библиотеки AssertJ.
3. Утверждения с примитивными типами.
4. Утверждения с исключениями.
5. Утверждения с коллекциями.
6. Отладчик в IDEA.

   2.1.2. Iterator
1. Что такое итератор.
2. Итератор для двухмерного массива int[][].
3. Итератор четных чисел.
4. FlatMap для Iterator<Iterator>.

   2.1.3. Generic
1. Что такое обобщенные типы (generics).
2. Реализовать Store<T extends Base>.

   2.1.4. List
0.1. Интерфейс List.
0.2. Внутри ArrayList.
0.3. Внутри LinkedList.
1. Динамический список на массиве.
2. Создать контейнер на базе связанного списка.
3. Удалить head в односвязном списке.
4. Используя контейнер на базе связанного списка создать контейнер Stack.
5. Очередь на двух стеках.
6. Перевернуть связанный список.
7. ListIterator.

   2.1.5. Set
0. Set, HashSet, TreeSet.
1. Реализовать коллекцию Set на массиве.

   2.1.6. Map
1. Побитовые операции.
2. Hash структуры.
3. Создать модель User.
4. Без переопределения equals и hashCode.
5. Переопределить только hashCode.
6. Переопределить только equals.
7. Переопределить и equals и hashCode.
8. Коллизии Map.
9. Как вычисляются hashCode у объекта.
10. Реализовать собственную структуру данных - HashMap.
11. Рассказать и продемонстрировать как переопределяют метод hashCode.

   2.1.7. Tree
0. Что такое деревья?.
1. Создать элементарную структуру дерева.
2. Добавить метод boolean isBinary().
3. О-нотация и сложность алгоритмов.

   2.1.8. Контрольные вопросы
1. Впечатления о блоке "Структуры данных и алгоритмы".
2. Экзамен. Структуры данных и алгоритмы.
3. Статистика по коллекции.

   2.2.1. Ввод-вывод
0. Обзор блока "Ввод-вывод".
1.0. Потоки ввода-вывода.
1.1. Java NIO/NIO.2 API.
2.0. FileOutputStream.
2.1. FileInputStream.
3. Классы вывода PrintStream / PrintWriter.
4. Потоки байтовых массивов (ByteArray Streams).
5.0. Буферизированные потоки.
5.1. BufferedReader.
5.2. BufferedOutputStream.
6. Читаем файл конфигурации.
7. Анализ доступности сервера.
8. Тестирование IO.
9.0. Файлы и директории. Класс File.
9.1. Файлы и директории. Классы Path, Files, Paths.
9.2. Атрибуты файла.
10. Сканирование файловой системы.
11. Поиск дубликатов.
12. Валидация параметров запуска.
13. Именованные аргументы.
14. Архивировать проект.
15.0. Регулярные выражения. Введение.
15.1. Регулярные выражения. Метасимволы, квантификаторы, классы символов.
16. Кодировка.
17. Scanner.
18. Класс Console.
19. Потоки данных (Data Streams).
20. Файл произвольного доступа. RandomAccessFile.
21. Потоки объектов. (Object streams).

   2.2.2. Socket
0. Модель TCP/IP.
1. Протокол HTTP.
2. Что такое Socket?.
3. Бот.

   2.2.3. Логгирование
1. Log4j. Логирование системы.
2. Simple Loggin Facade 4 Java.
3. Slf4j - вывод переменных.
4. Slf4j - вывод exception.
5. Log4j. FileAppender и другие appenders.

   2.2.4. Сериализация
1. Что такое Сериализация?
2. Формат JSON.
3. Формат XML.
4. JAXB. Преобразование XML в POJO.
5. Преобразование JSON в POJO. JsonObject.

   2.2.5. Контрольные вопросы
1. Впечатления о блоке "Ввод-вывод".
2. Экзамен. Ввод-вывод.
3. Поиск файлов по критерию.

   2.3.0. Настройка PostgreSQL
1. Обзор блока "SQL, JDBC".
2. Установка PostgreSQL.

   2.3.1. Create Update Insert
0. Что такое база данных.
1. Связи между таблицами.
2. Схема прав пользователи и роли.

   2.3.2. Query
0. Select.
1. Inner join.
2. Группировка и агрегатные функции.
3. Фильтры.

   2.3.3. Outer join
0. Join.
1. Хранилище машин.

   2.3.4. Объекты Базы данных
1. Представления.
2. Триггеры.
3. Хранимые процедуры и функции.
4.1. Транзакции. Общие сведения.
4.2. Транзакции. Свойства ACID.
4.3. Транзакции. Уровни изолированности транзакций.
4.4. Транзакции. Работа с транзакциями в PostgreSQL.
5. Курсор в SQL.
6. Индексы в SQL (кластерные и некластерные).
7. Нормализация БД.
8. Денормализация БД.
9. Подзапросы.
10. Операторы множества в SQL.
11. План выполнения запросов.

   2.3.5. JDBC
0. JDBC.
0.1. Statement.
0.2. PreparedStatement.
1. Sql схема для проекта Tracker.
2. Трекер SQL.
3. Отладчик при работе с Базой Данных.

   2.3.6. Liquibase
1. Liquibase. Установка.
2. Liquibase. Добавление новых скриптов.
3. Liquibase. Интеграционные тесты.

   2.3.7. Проект. Агрегатор Java вакансий
0. Техническое задание. Агрегатор Java Вакансий.
1. Quartz.
1.1. Job c параметрами.
2. Парсинг HTML страницы.
2.1. Преобразование даты.
2.1.1. Парсинг https://career.habr.com/vacancies/java_developer?page=1
2.2. Модель данных - Post.
2.3. Загрузка деталей поста.
2.4. HabrCareerParse.
3. Архитектура проекта - Аргегатор Java Вакансий.
4. Схема таблицы Post.
5. PsqlStore.
6. Grabber.
7. Web.

   2.3.8. Контрольные вопросы
1. Впечатления о блоке "SQL, JDBC".
2. Экзамен. Sql.
3. SQL Select by company.

   2.4.1. Понятие сборщик мусора
1. Обзор блока "Garbage Collection".
2. Stack, Heap, Metaspace.
3. Понятие сборки мусора.

   2.4.2. Виды сборщиков мусора
1. Виды сборщиков мусора.

   2.4.3. Профилирование приложения
0. Инструменты анализа памяти.
1. Профилирование.
2. Профилировщик Visual VM.
3. Эксперименты с различными GC.
4. Найти утечку памяти.

   2.4.4. Типы ссылок и коллекции на soft weak ссылках
0. Виды ссылок.
1. Реализация кеша на SoftReference.

   2.4.5. Java Memory Model
1. String pool, Integer pool.
2. Клонирование объектов.
3. Загрузка классов в JVM.

   2.4.6. Контрольные вопросы
1. Впечатления о блоке "Garbage collection".
2. Экзамен. GC.
3. GC. Out Of Mem. Тестовое задание.

   2.5.0. TDD
0. Обзор блока "ООД".
1. Объектно-ориентированный дизайн (ООД / OOD).
2. Принципы Kiss, Dry и Yagni.
3. Что такое TDD?
4. Шаблонизатор.
5. Виды тестов для TDD.

   2.5.1. SRP
0. Принцип единственной ответственности.
1. Отчеты.

   2.5.2. OCP
0. Принцип открытости закрытости.
1. Поддержка форматов XML, JSON в генераторе отчетов.

   2.5.3. LSP
0. Принцип подстановки Лисков.
1. Хранилище продуктов.
2. Парковка машин.

   2.5.4. ISP
0. Принцип разделения интерфейсов.
1. Создать меню.

   2.5.5. DIP
0. Принцип инверсии зависимостей.
1. Динамическое перераспределение продуктов.
2. Теперь я официально Джуниор.
 
   2.5.6. Контрольные вопросы
1. Впечатления о блоке "ООД".
2. Экзамен. ООД.
3. Крестики-нолики. Тестовое задание.