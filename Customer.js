"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Customer = void 0;
class Customer {
    constructor(_firstName, _lastName) {
        this._firstName = _firstName;
        this._lastName = _lastName;
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
exports.Customer = Customer;
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
