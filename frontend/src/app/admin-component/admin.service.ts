import {Injectable} from "@angular/core";
import {Http, RequestOptions,Headers, URLSearchParams} from "@angular/http";
import 'rxjs/add/operator/catch';
import {Observable} from "rxjs";
@Injectable()
export class AdminService{
    constructor(private http:Http){}

    getNotUpStatusPort(){
      let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
      let options = new RequestOptions({headers:headers});
      return this.http.get('./portstatus',options).map(res=>res.json())
    }
    setNoShut(devIp,ifName){
      let headers = new Headers();
      headers.append('Authorization',localStorage.getItem('Authorization'));
      headers.append('Content-Type', 'application/x-www-form-urlencoded');
      let options = new RequestOptions({headers:headers});
      var params = new URLSearchParams();
      params.set('devIp',devIp.toString());
      params.set('ifName',ifName.toString());
      console.log('Call from shut method!');
      return this.http.post('./shut',params.toString(),{ headers: headers })
        .map(res=>res.toString())
        .catch((error:any) =>{return Observable.throw(error);});;
    }
    portStatus(devIp,ifName){
      let headers = new Headers({'Authorization':'' + localStorage.getItem('Authorization')});
      let options = new RequestOptions({headers:headers});
      return this.http.get('./sshtest?devIp='+devIp+'&ifName='+ifName,options).map(res=>res)
    }
}
