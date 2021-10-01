import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  result:any
  constructor() { }

  ngOnInit(): void {
  }

  calculation(numberA: string, numberB: string, operator: string){
      let a:number = parseInt(numberA);
      let b:number = parseInt(numberB);
      switch (operator) {
        case "plus":
         return this.result = a + b
          break;
        case "minus":
          // @ts-ignore
          return this.result = a - b
          break;
        case "multi":
          // @ts-ignore
          return this.result = a * b
          break;
        case "divide":
          // @ts-ignore
          if (numberB != 0) {
            // @ts-ignore
            return this.result = a / b
          } else {
            return this.result = "number B not is 0"
          }
         break;
      }
  }
}
