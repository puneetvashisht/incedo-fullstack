const http = require('http')

const server = http.createServer((req, res)=>{

    // if(req.url == '/hello')

    res.setHeader('Content-Type', 'text/plain');
    res.statusCode = 200;
    res.end('Hello WOrld !')
})

server.listen(4000, ()=>{
    console.log('server is listening on port 4000')
})