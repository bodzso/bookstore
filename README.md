# bookstore

## Projekt importálása IDE-be

A projekt fordításához legalább 11-es JDK szükséges.

A projektet a Maven segítségével lehet buildelni.

- Eclipse
  - File > Import... > Existing Maven projects

## Teszt futtatása

*mvn test* parancssorból

Eclipse IDE-ben jobb klikk BookstoreApplicationTests.java > Run as > JUnit test

A BookstoreApplicationTests.java elérhetősége:

```/bookstore/src/test/java/bodnar/zsombor/bookstore/BookstoreApplicationTests.java```

## Az alkalmazás futtatása

Eclipse IDE-ben jobb klikk BookstoreApplication.java > Run as > Spring Boot App

BookstoreApplication elérhetősége:

```/bookstore/src/main/java/bodnar/zsombor/bookstore/BookstoreApplication.java```