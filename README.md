# Spring-restful-api

### Resource main url : /api/v1

<table>
  <thead>
      <tr>
        <th>Method</th>
        <th>Path</th>
        <th>Request body JSON</th>
        <th>Response status</th>
        <th>Response body JSON</th>
      </tr>
  </thead>
  <tbody>
    <tr>
        <td>GET</td>
        <td>/people</td>
        <td></td>
        <td>200</td>
        <td>
          <pre>
[
 {
  "id": :id,
  "firstName": ":firstName",
  "lastName": ":lastName",
  "age": :age,
   }
]
        </pre>
      </td>
    </tr>
        <tr>
        <td>GET</td>
        <td>/people/:id</td>
        <td></td>
        <td>200</td>
        <td>
          <pre>
{
 "id": :id,
 "firstName": ":firstName",
 "lastName": ":lastName",
 "age": :age,
}
        </pre>
      </td>
    </tr>
        </tr>
        <tr>
        <td>PUT</td>
        <td>/people/:id</td>
        <td>
          <pre>
{
 "firstName": ":firstName",
 "lastName": ":lastName",
 "age": :age,
}
        </pre>
      </td>
        <td>200</td>
        <td>
          <pre>
{
 "id": :id,
 "firstName": ":firstName",
 "lastName": ":lastName",
 "age": :age,
}
        </pre>
      </td>
    </tr>
            <tr>
        <td>PATCH</td>
        <td>/people/:id</td>
        <td>
          <pre>
{
 "firstName": ":firstName",
}
        </pre>
      </td>
        <td>200</td>
        <td>
          <pre>
{
 "id": :id,
 "firstName": ":firstName",
 "lastName": ":lastName",
 "age": :age,
}
        </pre>
      </td>
    </tr>
        </tr>
            <tr>
        <td>DELETE</td>
        <td>/people/:id</td>
        <td></td>
        <td>200</td>
        <td>
          <pre>
{
 "id": :id,
 "firstName": ":firstName",
 "lastName": ":lastName",
 "age": :age,
}
        </pre>
      </td>
    </tr>
  </tbody>
</table>

[here](#Spring-restful-api)
