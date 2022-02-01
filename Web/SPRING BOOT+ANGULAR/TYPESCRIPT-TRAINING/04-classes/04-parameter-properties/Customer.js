"use strict";
class Customer {
    constructor(theFirst, theLast) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }
    get firstName() {
        return this._firstName;
    }
    set firstName(value) {
        this._firstName = value;
    }
    get lastName() {
        return this._lastName;
    }
    set lastName(value) {
        this._lastName = value;
    }
}
//create an instance
let myCustomer = new Customer("liu", "jiali");
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
