Gradle

Java-приложение на Gradle, которое переворачивает строки с помощью 
Apache Commons Lang 3 и собственной библиотеки MyLibrary.

Подключение собственной библиотеки в build.gradle - implementation files('libs/MyLibrary-1.0-SNAPSHOT.jar')
Сборка проекта - .\gradlew.bat build
Запуск через IntelliJ IDEA

Зависимости:
инвертирование строки через StringUtils.reverse() - Apache Commons Lang 3
вторая строка получена используя класс TextReverser

Для работы приложения файл MyLibrary-1.0-SNAPSHOT.jar должен находиться в папке libs, 
а зависимость должна быть указана в build.gradle.

Вывод:
!dlroW ,olleH

