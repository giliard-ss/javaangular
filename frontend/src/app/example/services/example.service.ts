
import { Injectable } from '@angular/core';
import { ExampleSource } from '../model/examplesource';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExampleService {
  private readonly API = 'api/example';

  constructor(private httpClient: HttpClient) { }

  list() {
     return this.httpClient.get<ExampleSource[]>(this.API);
  }
}
