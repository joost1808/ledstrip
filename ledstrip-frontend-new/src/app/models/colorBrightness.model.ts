import {ColorModel} from './color.model';

export class ColorBrightnessModel implements ColorModel {
  r: number;
  g: number;
  b: number;
  brightness: number;

  constructor(r: number = 0, g: number = 0, b: number = 0, brightness: number = 10) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.brightness = brightness;
  }
}
