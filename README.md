# open-api-example

clean and build the project and deploy the ear.

Expected outcome for `/openapi` would contains both example schemas 

```yaml
components:
  schemas:
    ExampleFromWAR:
      type: object
      properties:
        name:
          type: string
    ExampleFromJAR:
      type: object
      properties:
        name:
          type: string
```

When using a provided dependency in the WAR, the class `ExampleFromJAR` will not be shown.

```xml
    <dependency>
      <groupId>org.example</groupId>
      <artifactId>example-jar</artifactId>
      <version>1.0-SNAPSHOT</version>
      <!-- This may be the issue, using a provided dependency will not create the openapi docs correctly -->
      <scope>provided</scope>
    </dependency>
```

Will produce following schema-declaration

```yaml
components:
  schemas:
    ExampleFromWAR:
      type: object
      properties:
        name:
          type: string
```

When removing line `<scope>provided</scope>` this works as expected.
