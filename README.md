# Automation Coding Exercise 


## Functionality 
- [x] Login.
- [x] Homepage.
    [ ] Header.
    [x] Footer.
    [ ] Information in the body page that may be relevant.
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

This features were not implemented due to the lack of time:

- Handle timeouts through configuration.
- Handle URLs/URIs through configuration.
- Support multiple environments and have an environment variable to select the profile.
- Run the driver on incognito mode.
- Test the header and body of the home page.

