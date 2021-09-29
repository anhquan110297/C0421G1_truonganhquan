function fibonacci(number) {
    var a = 0;
    var b = 1;
    var c;
    var sum = 0;
    console.log('Fibonacci List:');
    for (var i = 1; i <= number; i++) {
        console.log(a);
        sum += a;
        c = a + b;
        a = b;
        b = c;
    }
}
fibonacci(30);
