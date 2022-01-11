//let var const
var a;
console.log(a);
var a = 5; //a 5set ho gyi 
console.log(a);  //print toh yeh ho rha 
a = 10;  // a update ho kar 10 ho gya
console.log(a)  // a 10 print karega
a+=a;     // a = a + a    a = 20 ho gya 
console.log(a);  // 20 print ho gya 

let b = 1
console.log(b);

function add(){
    console.log(a+1);
}

add();

// c;    // reference error not defined
// console.log(c);

c = 20
var c;
console.log(c);

//d = 30; 
//let d;
const d =2;
console.log(d);


// call bind apply

let Name = {
    firstname:"Nitin",
    lastname : "Suri",
    printfullname: function(){
        console.log(this.firstname + " " +this.lastname + " from ");
    }
}

Name.printfullname();

let name1 = {
    firstname:"kartik",
    lastname:"Rai"
}


Name.printfullname.call(name1)

let name2 = {
    firstname:"Yogesh",
    lastname:"Yadav"
}

Name.printfullname.call(name2);
Name.printfullname.apply(name2);
let kyunprintnhihua = Name.printfullname.bind(name2);
console.log(kyunprintnhihua);
kyunprintnhihua()
// call => function borrowing ek object ke function ko dusre objcet pe apply krdeta h


//polyfil of bind method



// Name.printfullname.myBind(name2);

//map,filter,reduce

let arr = [1,2,3,4,5,6,7,8,9]
// console.log(arr);
// let newArr = arr.map(e => e*2);
// console.log(newArr);
// console.log(arr);

// map filter reduce hamesha new array tbhi kam krenge jab tujhe ek new array mein

let newArr = arr.filter(e=> e%2)
console.log(newArr);

// let arr1 = [2,4,6]
// let narr = arr1.reduce(acc,(e)=>{
//     console.log(e);    
// },acc++);
// console.log(narr);


// let myMap = ((arr)=>{
//     for(let i=0;i<arr.length;i++){
//         arr[i]*=3;
//     }
//     return arr;
// })
ar = [1,1,1];
// let newArray = Array.map(e=> e* 3);
// myMap(Array);
// console.log(Array);

Array.prototype.myMap = function(callback){
    let newArr = []
    for(let i=0;i<this.length;i++){
        newArr.push(callback(this[i],i,this));
    }
    return newArr;
}

let newar = ar.myMap(e=>e+3);
console.log(newar);


Array.prototype.myFilter = function(callback,jokrna){
    let newar = [];
    for(let i=0;i<this.length;i++){
        if(callback.call(jokrna,this[i],i,this)){
        newar.push(this[i]);
        }
    }
    return newar;
}

let h = [10,20,30,40];

let ans = h.myFilter(e=>e%20==0);
console.log(ans);


