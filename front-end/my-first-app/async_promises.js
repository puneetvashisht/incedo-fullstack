console.log('starting...');

// callback
function test_async(){
   return new Promise((resolve, reject)=> {
        setTimeout(()=>{
            console.log('test function called...');
            resolve("success")
            // reject('failure')
        }, 200)
    })
}

// var result = test_async();
// console.log(result);

test_async()
.then(result => result[0])
.then(data => console.log(data))
.catch(err=> console.log(err))

console.log('finishing...');