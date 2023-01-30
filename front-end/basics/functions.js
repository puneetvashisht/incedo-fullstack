// I outer[x: 2, inner: fn] : inner [x: undef]

function outer(){
    console.log('outer fn')
    var x = 2;
    var inner = function(){
        console.log(x + 2)
        console.log('inner fn')
        var x = 0;
    }
    return inner;
}

outer()()
