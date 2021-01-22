export class ColorModel {
  red: number;
  green: number;
  blue: number;
  alpha: number;

  constructor(red: number, green: number, blue: number, alpha: number = 100) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.alpha = alpha;
  }
}
