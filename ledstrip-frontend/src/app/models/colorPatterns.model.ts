export class ColorPatternsModel {
  r: number;
  g: number;
  b: number;
  a: number;
  delay: number;

  constructor(r: number, g: number, b: number, a: number = 10, delay: number = 20) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
    this.delay = delay;
  }
}
