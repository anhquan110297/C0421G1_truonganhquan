// Bài 1: Cho dãy số nguyên bao gồm cả số âm lẫn số dương. Viết chương trình tìm dãy con liên tục có tổng lớn nhất:
//     Ví dụ. Với dãy số A = {-2, -5, 6, -2, -3, 1, 5, -6} thì tổng lớn nhất của dãy con liên tục ta nhận được là 7.
// Bài 2: Tìm chữ số khác không cuối cùng của n!(giai thừa)
// Ví dụ:
//     Với n = 5, kết quả Zero(n) = 2. 5! = 1 * 2 * 3 * 4 * 5 = 120.
// Với n = 6, kết quả Zero(n) = 2. 6!=1 * 2 * 3 * 4 * 5 * 6 = 720.
// Với n = 10, kết quả Zero(n) = 8.  10! = 3628800
let array = [-2, -5, 6, -2, -3, 1, 5, -6];
let arrTest = [];
let result = 0;
// for (let i = 0; i < array.length; i ++) {
//     let sum = 0;
//     for (let j = i; j < array.length; j ++) {
//         sum += array[i];
//         result = Math.max(result,sum)
//         console.log(result);
//
//     }
// }
console.log(maxSum(array))
function maxSum(arr){
    let a1 = 0
    let a2 = arr[0]
    arr.forEach((i,a) => {
        a1 = Math.max(i, a1 + i)
        a2 = Math.max(a2, a1)
    })
    return a2
}
// let max = arrTest[0];
// let result;
// for (let j = 0; j< arrTest.length;j++){
//     if (max < arrTest[j]){
//         arrTest[j] = max;
//     }
// }
// let max = arrTest.reduce(function(a, b) {
//     return Math.max(a, b);
// }, 0);
// console.log(max)


