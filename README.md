# Employee ranking

App that stores user actions and performes cumulative calculations based on that data

## Getting Started

Clone repository and import in Eclipse as Existing Maven project.
Build project and run it from EmployeeRankingApplication class.

```
public class EmployeeRankingApplication
```

For now change in RankingController change absolute path to excel file in line 32
```
Collection<EntryDTO> read = ExcelSheetParser.read("C:/Users/Milos/Desktop/Book2.xlsx");
```

Fire POST request on address http://localhost:8080/ranking and this will parse file and fill DB (Pre-requisite is that you have DB named work_data)
```
spring.datasource.url=jdbc:mysql://localhost:3306/work_data?useSSL=false
```

GET request on http://localhost:8080/ranking/{user} with Korisnik value from file will return all actions for that user

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
