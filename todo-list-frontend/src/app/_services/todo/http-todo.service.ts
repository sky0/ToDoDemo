import { Injectable } from '@angular/core';
import { Item } from '../../_model/Item';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { AbstractItemsService } from './abstract-items.service';
import { environment } from '../../../environments/environment';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})

export class HttpItemsService extends AbstractItemsService {

	items: Item[];
	url: string; 

	constructor(protected http: HttpClient,private auth: AuthService){
		super();
		this.url = environment.backendUrl + "/api/todo";
	}

	getHeadersWith(token){

		return {
			headers: new HttpHeaders({
				'Content-Type':  'application/json',
				'Authorization': token
			})
		};
	}

	getCurrentToken(){

		return this.auth.getCurrentSession().getToken();
	}

	getItems(): Promise<Item[]> {
		return new Promise((resolve) => {

			this.http.get<Item[]>(this.url).subscribe(response => {

			  	var items = response.map((item) => new Item(item.name, item.id));
			  	resolve(items);
			});
		});
	};

	removeItem(item: Item): Promise<Object> {

		return this.http.delete(this.url + '/' + item.id).toPromise();
	};

	addItem(item: Item): Promise<Object> {

		return this.http.post(this.url, item).toPromise();
	};

	updateItem(item: Item): Promise<Object> {
		return this.http.put(this.url + '/' + item.id, item).toPromise();
	}
}