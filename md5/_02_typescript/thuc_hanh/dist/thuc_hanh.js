"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let width;
let height;
width = 10.5;
height = 20;
let area = width * height;
console.log("area: " + area);
let sum = 0;
let count = 0;
for (let i = 2; count < 30; i++) {
    let isPrime = true;
    if (i == 2) {
        sum += i;
        count++;
        continue;
    }
    for (let j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
            isPrime = false;
            break;
        }
    }
    if (!isPrime) {
        continue;
    }
    sum += i;
    count++;
}
console.log(sum);
const rectangle_1 = require("./rectangle");
const rectangle = new rectangle_1.Rectangle(5, 5, 10, 20);
console.log(rectangle.toString());
console.log(rectangle.area());
//# sourceMappingURL=thuc_hanh.js.map