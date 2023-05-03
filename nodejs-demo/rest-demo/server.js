const express = require('express');
const app = express()
const mongoose = require('mongoose');
const Employee = require('./entities/employee')

// MERN : Mongo, Express, React, Node

// connection to db code
async function main() {
    // connect to db
  await mongoose.connect('mongodb://127.0.0.1:27017/incedo_db');
  console.log('connected to db;')
}

main().catch(err => console.log(err));

// reading json data
app.use(express.json())

app.get('/', async (req, res) => {
  res.send('Hello World')

    res.json({success: true})
})




// const employees = [
//     {id: 1, name: 'Ravi', salary: 33433.3},
//    {id: 2, name: 'Priya', salary: 44444.3}
// ]

app.get('/employees', async (req, res)=>{
    const employees = await Employee.find();
    res.json(employees)
})


app.delete('/employees/:name', async (req, res)=>{
    console.log(req.params.name);
    const name = req.params.name;

    await Employee.deleteOne({name});
    res.status(200).end()   
})

app.patch('/employees/', async (req, res)=>{
    console.log(req.body);
    const {name , salary} = req.body;
    console.log(salary)

    await Employee.updateOne({name}, {salary});
    res.status(200).end()   
})

app.post('/employees', async(req, res)=>{
    console.log(req.body)

    const employee = req.body;
    const emp = new Employee(employee);

    await emp.save();

    // employees.push(req.body);
    // res.json(employees)
    res.status(201).end()
})

app.listen(3000)