 export class Customer {
     

     constructor( private _firstName: string, private _lastName: string) {
     }

     public get firstName(): string {
         return this._firstName;
     }

     public set firstName(value: string) {
         this._firstName = value;
     }
     
     public get lastName(): string {
        return this._lastName;
    }
    public set lastName(value: string) {
        this._lastName = value;
    }
 }

 //create an instance


/*
class Customer {
    firstName: string;
    lastName: string;
}

let myCustomer = new Customer();

myCustomer.firstName = "Jiali";
myCustomer.lastName = "Liu";

console.log(myCustomer.firstName);
console.log(myCustomer.lastName0;)
*/