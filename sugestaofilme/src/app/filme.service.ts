import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Filme } from './model/filme.model';

const URL: string = 'http://localhost:8080/filme';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {

  constructor(private http: HttpClient) { }

  getFilme(Title: string): Observable<Filme[]> {
    if(Title){
      return this.http.get<Filme[]>(URL + "/" + Title)
    }else{
      return this.http.get<Filme[]>(URL)
    }
  }

  getMais(tituloPesquisado: string): Observable<Filme[]>{
    return this.http.get<Filme[]>(URL + "/" + tituloPesquisado + "/mais")
  }

  getDetalhe(imdbID : string): Observable<Filme>{
    return this.http.get<Filme>(URL + "/" + imdbID + "/detalhe")
  }

}




