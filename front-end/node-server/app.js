const express = require('express')
const app = express()
const port = 8080

app.use(express.json())

const employees = [
    {
      "name": "Sohini",
      "salary": 34333.33,
      "id": 1
    },
    {
      "name": "Nida",
      "salary": 34333.33,
      "id": 3
    },
    {
      "name": "Ravi ",
      "salary": "33433",
      "id": 4
    },
    {
      "name": "Priya",
      "salary": "34343",
      "id": 5
    },
    {
      "name": "Arun",
      "salary": "33433",
      "id": 6
    }
  ]

app.get('/employees', (req, res) => {
  res.json(employees)
})

app.post('/employees', (req, res) => {
    console.log(req.body);
    employees.push(req.body);
    res.json(employees)
  })

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})