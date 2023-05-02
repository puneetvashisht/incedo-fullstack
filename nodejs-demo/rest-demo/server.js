const express = require('express');
const app = express()

// reading json data
app.use(express.json())

app.get('/', function (req, res) {
//   res.send('Hello World')
    res.json({success: true})
})

const employees = [
    {id: 1, name: 'Ravi', salary: 33433.3},
   {id: 2, name: 'Priya', salary: 44444.3}
]

app.get('/employees', (req, res)=>{
    res.json(employees)
})

app.post('/employees', (req, res)=>{
    console.log(req.body)
    employees.push(req.body);
    // res.json(employees)
    res.status(201).end()
})

app.listen(3000)