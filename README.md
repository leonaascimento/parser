# parser
Parser is a tool that loads request log files into database and find remote addresses that are making too many requests

## Installation

* Create [schema](https://github.com/leonaascimento/parser/blob/master/sql/schema/access_log.sql)
* Download [parser.jar](https://github.com/leonaascimento/parser/releases/download/1.0.0-beta/parser.jar)
* Extract files from parser.jar
* Open `application.properties` and set database url and credentials
* Compress extracted files to parser.zip
* Change file extension from .zip to .jar

## Usage

The parser accepts the following arguments:
* *accesslog*: The [access log](https://gist.githubusercontent.com/leonaascimento/098c12de4da856ac91887858c522c1f1/raw/b6a637995029c255b9cb6cf6831cbe87fb1186a1/access.log) file path (optional)
* *startDate*: The start date of the analysis (required)
* *duration*: The time span to be considered (required)
* *threshold*: The requests limit of a remote address (required)

Run from command line:

```
java -cp "parser.jar" com.ef.Parser --accesslog=/path/to/file --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100
```

## Built With

* [JCommander](http://jcommander.org/) - Parse command line arguments
* [Connector/J](https://dev.mysql.com/downloads/connector/j/) - JDBC driver for MySQL
* [Sql2o](https://www.sql2o.org/) - Micro-ORM

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/leonaascimento/parser/blob/master/LICENSE.md) file for details
