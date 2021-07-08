### Guides
Run:
- ./mvnw or mvnw.cmd clean install
- docker-compose up

CURL: 
- Create receive note: </br>
`curl --location --request POST 'localhost:8081/simple-storage/received-notes' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "receive_from": "New Market",
  "address": "Singapore",
  "items": [
  {
  "name": "Mango",
  "code": "MNG",
  "unit_amount": 40000,
  "quantity": 5,
  "item_condition": "NEW"
  }
  ]
  }'`
- Get all notes: </br>
`curl --location --request GET 'localhost:8081/simple-storage/received-notes'`
- Get note by id: </br>
`curl --location --request GET 'localhost:8081/simple-storage/received-notes/1'`

