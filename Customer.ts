 class Customer {
     private _firstName: string;
     private _lastName: string;
     

     constructor(theFirst: string, theLast: string) {
         this. _firstName = theFirst;
         this._lastName = theLast;
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

let myCustomer = new Customer("liu","jiali");


console.log(myCustomer.firstName);
console.log(myCustomer.lastName);

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