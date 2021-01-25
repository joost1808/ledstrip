import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ColorBrightnessModel} from '../models/colorBrightness.model';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {LedstripControllerService} from './LedstripController.service';
import {ColorPatternsModel} from '../models/colorPatterns.model';

@Injectable({
  providedIn: 'root'
})
export class LedstripInterfaceService extends LedstripControllerService {

  constructor(private http: HttpClient) {
    super();
  }

  public handleCustomColorRequest(color: ColorBrightnessModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const httpOptions = this.getDefaultOptions();
    return this.http.post(`${apiUrl}on/color`, color, {...httpOptions});
  }

  public handleRainbowRequest(color: ColorPatternsModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const httpOptions = this.getDefaultOptions();
    return this.http.post(`${apiUrl}on/rainbow`, color, {...httpOptions});
  }

  public handleKittRequest(color: ColorPatternsModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const httpOptions = this.getDefaultOptions();
    return this.http.post(`${apiUrl}on/kitt`, color, {...httpOptions});
  }

  public handleWaveRequest(color: ColorPatternsModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const httpOptions = this.getDefaultOptions();
    return this.http.post(`${apiUrl}on/wave`, color, {...httpOptions});
  }

  public handleRunningLightsRequest(color: ColorPatternsModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const httpOptions = this.getDefaultOptions();
    return this.http.post(`${apiUrl}on/runninglights`, color, {...httpOptions});
  }
}
