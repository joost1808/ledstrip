import {Component, OnInit} from '@angular/core';
import {ColorModel} from '../models/color.model';
import {FormBuilder} from '@angular/forms';
import {LedstripInterfaceService} from '../services/ledstrip-interface.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-ledstrip-interface',
  templateUrl: './ledstrip-interface.component.html',
  styleUrls: ['./ledstrip-interface.component.scss']
})
export class LedstripInterfaceComponent implements OnInit {
  colorPicker = this.formBuilder.group({
    color: ''
  });

  color: ColorModel;

  constructor(private formBuilder: FormBuilder, private service: LedstripInterfaceService) {
  }

  ngOnInit() {
  }

  handleColorRequest() {
    console.log(this.hexToColorModel(this.colorPicker.controls.color.value));
    this.service.handleCustomColorRequest(this.hexToColorModel(this.colorPicker.controls.color.value))
    .subscribe(
      _ => {
        console.log('Het is gelukt');
      },
      (data: HttpErrorResponse) => {
        console.log(data.error);
      }
    );
  }

  hexToColorModel(hex: string) {
    const r = parseInt(hex.slice(1, 3), 16);
    const g = parseInt(hex.slice(3, 5), 16);
    const b = parseInt(hex.slice(5, 7), 16);
    const a = parseInt(hex.slice(7, 9), 16);

    return new ColorModel(r, g, b, a);
  }
}
