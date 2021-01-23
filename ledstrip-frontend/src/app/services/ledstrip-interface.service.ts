import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {ColorModel} from '../models/color.model';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LedstripInterfaceService {

  constructor(private http: HttpClient) {
  }

  public handleCustomColorRequest(color: ColorModel): Observable<any> {
    const apiUrl = environment.apiUrl;
    const params = new HttpParams()
    .set('red', String(color.red))
    .set('green', String(color.green))
    .set('blue', String(color.blue))
    .set('brightness', String(color.alpha));
    return this.http.get(`${apiUrl}on/color`, {params});
  }
}
