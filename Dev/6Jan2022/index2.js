// call bind apply 

let Name = {
    firstname :"Morris",
    lastname  : "Patt"
}

let fullname = () => {
    console.log(this.firstname + " " + this.lastname);
}
console.log(Name.firstname);
fullname.call(Name);