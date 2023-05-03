const mongoose = require('mongoose');

const employeeSchema = new mongoose.Schema({
    name: String,
    salary: {
        type: Number,
        min: [10000, 'Must be at least 10000, got {VALUE}']
    }
});

  // create a model
const Employee = mongoose.model('Employee', employeeSchema);

module.exports = Employee;
