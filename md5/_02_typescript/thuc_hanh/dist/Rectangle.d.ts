import { shape } from "./shape";
export declare class Rectangle extends shape implements IAea {
    private _width;
    private _height;
    area(): number;
    constructor(x: number, y: number, _width: number, _height: number);
    get width(): number;
    set width(value: number);
    get height(): number;
    set height(value: number);
}
