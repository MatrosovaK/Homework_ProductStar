BAZEL

Java-проект демонстрирует использование внешней библиотеки 
и собственной Java-библиотеки(MyLibrary), подключённой через JAR.

Команды для сборки и запуска:
bazelisk build //MyLibrary:My_Library - сборка библиотеки
bazelisk build //src/main/java/org/example:hello - сборка приложения
bazelisk run //src/main/java/org/example:hello - запуск приложения

Программа выводит перевёрнутую строку Hello, World! 
и приветствие из собственной библиотеки.
