import {ColorModel} from './color.model';

export class ColorBrightnessModel implements ColorModel {
  r: number;
  g: number;
  b: number;
  a: number;

  constructor(r: number, g: number, b: number, a: number = 10) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }
}
