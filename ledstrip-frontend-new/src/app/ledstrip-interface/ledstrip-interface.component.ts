import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {LedstripInterfaceService} from '../services/ledstrip-interface.service';
import {ColorPatternsModel} from '../models/colorPatterns.model';
import {ColorBrightnessModel} from '../models/colorBrightness.model';

@Component({
  selector: 'app-ledstrip-interface',
  templateUrl: './ledstrip-interface.component.html',
  styleUrls: ['./ledstrip-interface.component.scss']
})
export class LedstripInterfaceComponent implements OnInit {
  customColorPicker = this.formBuilder.group({
    customColor: ''
  });

  customColorPattern = this.formBuilder.group({
    patternColor: '',
    delay: ''
  });

  buttonType: string = "";

  constructor(private formBuilder: FormBuilder, private service: LedstripInterfaceService) {
  }

  ngOnInit() {
  }

  handleColorRequest() {
    this.service.handleCustomColorRequest(
      this.hexToColorBrightnessModel(
        this.customColorPicker.controls['customColor'].value
      )
    ).subscribe();
  }

  handlePatternRequest(buttonType: string) {
    if (buttonType === 'rainbow') {
      console.log(buttonType);
      this.service.handleRainbowRequest(
        this.hexToColorPatternModel(
          this.customColorPattern.controls['patternColor'].value
        )
      ).subscribe();
    }
    if (buttonType === 'kitt') {
      console.log(buttonType);
      this.service.handleKittRequest(
        this.hexToColorPatternModel(
          this.customColorPattern.controls['patternColor'].value
        )
      ).subscribe();
    }
    if (buttonType === 'wave') {
      console.log(buttonType);
      this.service.handleWaveRequest(
        this.hexToColorPatternModel(
          this.customColorPattern.controls['patternColor'].value
        )
      ).subscribe();
    }
    if (buttonType === 'runninglights') {
      console.log(buttonType);
      this.service.handleRunningLightsRequest(
        this.hexToColorPatternModel(
          this.customColorPattern.controls['patternColor'].value
        )
      ).subscribe();
    }
  }

  hexToColorBrightnessModel(hex: string) {
    if (hex == null) {
      console.log(hex);
      return new ColorBrightnessModel(0, 0, 0);
    } else {
      const r = parseInt(hex.slice(1, 3), 16);
      const g = parseInt(hex.slice(3, 5), 16);
      const b = parseInt(hex.slice(5, 7), 16);
      const a = parseInt(hex.slice(7, 9), 16);

      return new ColorBrightnessModel(r, g, b, a);
    }
  }

  hexToColorPatternModel(hex: string) {
    if (hex) {
      const r = parseInt(hex.slice(1, 3), 16);
      const g = parseInt(hex.slice(3, 5), 16);
      const b = parseInt(hex.slice(5, 7), 16);
      const a = parseInt(hex.slice(7, 9), 16);
      return new ColorPatternsModel(r, g, b, a, +this.customColorPattern.controls['delay'].value);
    } else {
      return new ColorPatternsModel(0, 0, 0, 10, 20);
    }
  }
}
