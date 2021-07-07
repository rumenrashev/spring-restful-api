# spring-restful-api

### Resource main url : /api/v1

| HTTP method | Request path | Body | Status | Response Body |
| ----------- | ------------ | ---- | -------| -------------- |
| GET         | /people      | none | 200 | JSON with List of all peple
| GET         | /people/:id  | none | 200 | JSON with person
| POST        | /people      | {\"firstName":"{fistName}",\"lastName":"{lastName}",\"age":{age}|201 | JSON with created person
| PUT         | /people/:id  |      | JSON with edited person
| PATCH       | /people/:id  |      | JSON with partially edited person
| DELETE      | /people/:id  | none | JSON with deleted person
