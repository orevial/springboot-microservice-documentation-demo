# springboot-service-documentation-demo
A sample service demo to show how different documentation systems (Javadoc, manual Asciidoc, Swagger API doc, ...) can work together

## How-to

To build the application and generate docs, just run :

```bash
mvn clean install gitlog:generate asciidoctor:process-asciidoc package
```
