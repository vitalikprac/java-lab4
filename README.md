# Лабораторна робота - 4
Прачов Віталій ТМ-82. Варіант - 16.

# Start
Using Maven you can provide execution arguments for running specific task
Available tasks: `task5`,`task13`,`task17`,`task25`

To running `task5`:
 - `print` - print all books
 - `delete {number}` - delete book with number
 - `sort {field}` - sort books by field (`name`,`authorFullName`,`publication`,`publicationYear`,`price`)
```bash
$ mvn package exec:java --quiet -DskipTests "-Dexec.args=task5 print delete 3 print"
```

To running `task13`:
- `print` - print all abonents
- `find {name}` - find abonent by name
- `change {name} {surname} {lastName} {address} stop` - change last founded abonent 
```bash
$ mvn package exec:java --quiet -DskipTests "-Dexec.args=task13 print find Vitaliy change Vitaliy Prachov Serhiyovich Academic Yanhelya 5 stop print"
```

To running `task17`:
- `print` - print all books
- `sort {field}` - sort by field 
- `unique ${book name} stop` - check if book is unique by TreeSet
```bash
$ mvn package exec:java --quiet -DskipTests "-Dexec.args=task17 print unique Book 6 stop""
```

To running `task25`:
- `print` - print all articles
- `delete {number}` - delete article with number
```bash
$ mvn package exec:java --quiet -DskipTests "-Dexec.args=task25 print delete 152 delete 131 print"
```





# Tests
```bash
$ mvn test
```