import {shape} from "./shape";

export class Rectangle extends shape implements IAea{
    area(): number {
        return 0;
    }

    constructor(x: number, y: number, private _width: number, private _height: number) {
        super(x, y);
    }


    get width(): number {
        return this._width;
    }

    set width(value: number) {
        this._width = value;
    }

    get height(): number {
        return this._height;
    }

    set height(value: number) {
        this._height = value;
    }
}