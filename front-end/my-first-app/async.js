console.log('starting...');

// callback
function test_async(callback){
    setTimeout(()=>{
        console.log('test function called...');
        // return "success"
        callback("success")
    }, 2000)
   
}

function test(){
    console.log('test function called...');
    return "success;"
}

var result = test();
console.log(result);


var fn = (result)=> console.log(result)
test_async(fn)

console.log('finishing...');