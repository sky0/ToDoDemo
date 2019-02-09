export class Item {

	id: Number;
	text: String;
	isCompleted:Boolean

	constructor(text: String, id: Number,isCompleted:Boolean){

		this.text = text;
		this.id = id;
		this.isCompleted=isCompleted;
	}
}