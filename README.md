# Automation Coding Exercise 


## Functionality 
- [x] Login.
- [x] Homepage.
- [x] Search.
   - [x] api.
   - [x] trial.
- [x] Product download.
- [x] Report.

# Execute 

- To run the tests `mvn test`

- To generate the report `mvn allure:report`

- To set custom properties create a file under `src/test/resources/` called `application.yml`

```yaml
application:
  automation:
    username: myUsername
    password: myPassword
```

# Nice to have

