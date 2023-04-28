const fs = require('fs')

console.log('start');

// async
fs.readFile('./demofile.txt', 'utf8',(err, data)=>{
    console.log(data)
})

console.log('end');