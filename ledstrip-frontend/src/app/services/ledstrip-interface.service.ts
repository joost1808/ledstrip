import {Injectable} from '@angular/core';
import {environment as env} from '../../environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {ColorModel} from '../models/color.model';

@Injectable({
  providedIn: 'root'
})
export class LedstripInterfaceService {
  private serverUrl = env.apiUrl;

  constructor(private http: HttpClient) {
  }

  public handleLedstripRequest(route: string, color: ColorModel) {
    const params = new HttpParams()
    .set('r', String(color.red))
    .set('g', String(color.green))
    .set('b', String(color.blue))
    .set('brightness', String(color.alpha));
    const endpointUrl = this.serverUrl + route;
    return this.http.get(endpointUrl, {params});
  }
}
