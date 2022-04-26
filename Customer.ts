 class Customer {
     firstName: string;
     lastName: string;

     constructor(theFirst: string, theLast: string) {
         this. firstName = theFirst;
         this.lastName = theLast;
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