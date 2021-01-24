import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {ColorModel} from '../models/color.model';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {LedstripControllerService} from './LedstripController.service';

@Injectable({
  providedIn: 'root'
})
export class LedstripInterfaceService extends LedstripControllerService {

  constructor(private http: HttpClient) {
    super();
  }

  public handleCustomColorRequest(color: ColorModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const params = new HttpParams()
    .set('red', String(color.r))
    .set('green', String(color.g))
    .set('blue', String(color.b))
    .set('brightness', String(color.a));
    return this.http.get(`${apiUrl}on/color`, {params});
  }

  public handleRainbowRequest(delay: number = 20, brightness: number = 10): Observable<any> {
    const apiUrl = environment.apiUrl;
    const params = new HttpParams()
    .set('delay', String(delay))
    .set('brightness', String(brightness));
    return this.http.get(`${apiUrl}on/rainbow`, {params});
  }

  public handleKittRequest(color: ColorModel, delay: number = 20): Observable<any> {
    const apiUrl = environment.apiUrl;
    const httpOptions = this.getDefaultOptions();
    const body = JSON.stringify(color);
    const params = new HttpParams()
    .set('color', body)
    .set('delay', String(delay))
    .set('brightness', String(color.a));
    return this.http.post(`${apiUrl}on/kitt`, {...httpOptions, params});
  }

  public handleWaveRequest(color: ColorModel, delay: number = 20): Observable<any> {
    const apiUrl = environment.apiUrl;
    const params = new HttpParams()
    .set('red', String(color.r))
    .set('green', String(color.g))
    .set('blue', String(color.b))
    .set('delay', String(delay))
    .set('brightness', String(color.a));
    return this.http.get(`${apiUrl}on/wave`, {params});
  }
}
