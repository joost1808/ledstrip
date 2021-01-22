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

  public handleLedstripRequest(route: string, color: any) {
    const params = new HttpParams()
    .set('color', color.target.value);
    const endpointUrl = this.serverUrl + route;
    return this.http.get(endpointUrl, {params});
  }
}
