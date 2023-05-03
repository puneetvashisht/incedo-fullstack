const mongoose = require('mongoose');

main().catch(err => console.log(err));

async function main() {
    // connect to db
  await mongoose.connect('mongodb://127.0.0.1:27017/incedo_db');
    console.log('connected to db;')

    // create a schema defining the structure
    // const employeeSchema = new mongoose.Schema({
    //     name: String,
    //     salary: Number
    //   });

    //   // create a model
    //   const Employee = mongoose.model('Employee', employeeSchema);

      // create an object of schema
    //   const emp = new Employee({ name: 'Priya', salary: 34333 });


      // operations
    //   await emp.save();

    const employees = await Employee.find();
console.log(employees);
         
  // use `await mongoose.connect('mongodb://user:password@127.0.0.1:27017/test');` if your database has auth enabled
}


