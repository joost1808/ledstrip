import {ColorModel} from './color.model';

export class ColorPatternsModel implements ColorModel {
  r: number;
  g: number;
  b: number;
  brightness: number;
  delay: number;

  constructor(r: number = 0, g: number = 0, b: number = 0, brightness: number = 10, delay: number = 20) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.brightness = brightness;
    this.delay = delay;
  }
}
