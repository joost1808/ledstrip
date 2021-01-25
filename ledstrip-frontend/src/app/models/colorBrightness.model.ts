export class ColorBrightnessModel {
  r: number;
  g: number;
  b: number;
  a: number;

  constructor(r: number, g: number, b: number, a: number = 100) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }
}
