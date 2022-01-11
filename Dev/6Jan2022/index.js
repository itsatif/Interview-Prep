//Call, Bind & Apply

let Name = {
    firstName :"Atif",
    lastName : "Khan",
};

let printFullName = function(hometown,state){
    console.log(this.firstName + " " + this.lastName + " from " + hometown + " " + state);
};

printFullName.call(Name,"Ghazipur","UttarPradesh");

let name1 = {
    firstName: "Khan",
    lastName : "Atif"
}

printFullName.call(name1,"New Delhi","Delhi");
// Call method is used for function borrowing
//We can borrow functions from other objects and use it with data of the other object


// apply method
printFullName.apply(name1,["New Delhi","Delhi"]);

//bind method
let printname = printFullName.bind(name1,"Lucknow","Up");
console.log(printname);
printname();


//Flatten an object
function flattenObject(obj) { 
    return flatten(Object.keys(obj).map(k => [toNumber(k), obj[k]]));
}

// Substitute your own favorite flattening algorithm.
const flatten = a => Array.isArray(a) ? [].concat(...a.map(flatten)) : a;

// Convert to number, if you can.
const toNumber = n => isNaN(+n) ? n : +n;

console.log(flattenObject({a: [1, 2], b: 3, 0: [1, 2, 3, 4, 5]}));