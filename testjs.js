var list = [];
for(var i = 0; i< 70_000_000; i++) {
    var x = {
        v: "Hello " + i
    };
    list.push(x);
}
console.log("len: ", list.length);