import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  url = environment.apiUrl;
  constructor(private httpClient:HttpClient) { }

  add(data:any){
    return this.httpClient.post(this.url +"/quiz/add" , data,{
      headers: new HttpHeaders().set('Content-Type' , "application/json")
    })
  }

  update(data:any){
    return this.httpClient.post(this.url +"/quiz/update" , data,{
      headers: new HttpHeaders().set('Content-Type' , "application/json")
    })
  }

  getQuizzes(){
    return this.httpClient.get(this.url + "/quiz/get");
  }

  getAllAnnouncement(){
    return this.httpClient.get(this.url + "/announcement/get");
  }
  getFilteredCategorys(){
    return this.httpClient.get(this.url + "/quiz/get?filterValue=true");
  }
}
