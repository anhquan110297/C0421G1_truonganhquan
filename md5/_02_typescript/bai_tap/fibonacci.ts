
function fibonacci(number:number) {
    let a:number = 0;
    let b:number = 1;
    let c:number;
    let sum:number = 0;
    console.log('Fibonacci List:');
    for (let i = 1; i <= number; i++) {
        console.log(a);
        sum +=a
        c = a + b;
        a = b;
        b = c;
        console.log(sum);
    }
}
fibonacci(30);