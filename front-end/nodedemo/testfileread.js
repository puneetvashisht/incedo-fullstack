const fs = require('fs')

var contents = fs.readFileSync('../basics/clock.html')
console.log('Contents of file: ' + contents)