# Documentation

### End points

| Method | Path         |    Body       |  Action                        | Response code | Response body                  |
| ------ | ------------ |-------------- | ------------------------------ | ------------- | ------------------------------ | 
| GET    | /people      |               | Get all people                 | 200           | [JSON](#get-all-response)      |
| GET    | /people/{id} |               | Get person by id               | 200           | [JSON](#get-by-id-response)    |
| POST   | /people      | [JSON](#post) | Create person                  | 201           | [JSON](#post-response)         |
| PUT    | /people/{id} | [JSON](#put)  | Update all fields of a person  | 200           | [JSON](#post-response)         |
| PATCH  | /people/{id} | [JSON](#patch)| Update some fields of a person | 200           | [JSON](#patch-response)        |
| DELETE | /people/{id} |               | Delete person by id            | 200           | [JSON](#delete-by-id-response) |
| DELETE | /people      |               | Delete all people              | 200           | [JSON](#delete-all-response)   |

## Valid JSON Request Bodies examples

##### <a id="post">Create person -> POST /people</a>
```json
{
    "firstName":"John",
    "lastName":"Anderson",
    "age":28
}
```

##### <a id="put">Edit all fields of a person -> PUT /people/{id}</a>
```json
{
  "firstName": "John",
  "lastName": "Robertson",
  "age" : 30
}
```

##### <a id="patch">Edit some fields of a person -> PATCH /people/{id}</a>  
```json
{
  "firstName": "Peter"
}
```  

## Valid JSON Response Bodies examples
##### <a id="get-all-response">Get all people -> GET /people</a>
```json
{
    "message": "Successful get all people.",
    "result": [
        {
            "id": 1,
            "firstName": "John",
            "lastName": "Anderson",
            "age": 28
        },
        {
            "id": 2,
            "firstName": "Frank",
            "lastName": "Morisson",
            "age": 40
        }
    ]
}
```
##### <a id="get-by-id-response">Get person by id -> GET /people/1</a>
```json

{
    "message": "Successful get person by id.",
    "result": {
        "id": 1,
        "firstName": "John",
        "lastName": "Anderson",
        "age": 28
    }
}

```
##### <a id="post-response">Crete person -> POST /people</a>
```json
{
    "message": "Successful create person.",
    "result": {
        "id": 1,
        "firstName": "John",
        "lastName": "Anderson",
        "age": 28
    }
}
```
##### <a id="put-response">Edit all fields of a person -> PUT /people/1</a>
```json
{
    "message": "Successfully edit person.",
    "result": {
        "id": 2,
        "firstName": "Michael",
        "lastName": "Thomson",
        "age": 50
    }
}
```
##### <a id="patch-response">Edit some fields of a person -> PATCH /people/1</a>
```json
{
    "message": "Successfully edit person.",
    "result": {
        "id": 2,
        "firstName": "Michael",
        "lastName": "Thomson",
        "age": 50
    }
}
```
##### <a id="delete-by-id-response">Delete person by id -> DELETE /people/1</a>
```json
{
    "message": "Successfully delete person.",
    "result": {
        "id": 1,
        "firstName": "John",
        "lastName": "Anderson",
        "age": 28
    }
}
```
##### <a id="delete-all-response">Delete person by id -> DELETE /people</a>
```json
{
    "message": "Successfully delete all people.",
    "result": [
        {
            "id": 2,
            "firstName": "MIchael",
            "lastName": "Tomson",
            "age": 50
        },
        {
            "id": 3,
            "firstName": "John",
            "lastName": "Cena",
            "age": 50
        }
    ]
}
```

