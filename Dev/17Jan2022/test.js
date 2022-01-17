// const lion = 1
// let tiger = 2
// var bear = 3

// ++lion   
// bear += lion + tiger
// tiger++;

// console.log(bear);
//error marega 

//vakil => 4   
//nitin => 3  4             
//nihal => error  correct 
//akshat => 4

//let cipherText = [..."YZOGUT QGMORTZ MTRHTILS"]    //isse value nikalni
//let plainText = ""



// for(let [index,value] of cipherText.entries()){
//     plainText += (index % 2 === 0) ? value:"";       
// }
// console.log(plainText)


//You Got This


// setTimeout(() =>{
//     console.log("Hey!")
// },1000)
// console.log("Hi");

//Hi hey - vakil,nitin,


// const obj ={
//     a:1,
//     b:2,
//     c:3,
// }

// const obj2 = {
//     ...obj,
//     a:0,
//     b:3,
// }

// console.log(obj2.a,obj2.b);


// var a =1                                       // beacuse of hoisting 
// a= b()                                                                       
// console.log(a);
// function b(){
//     a=10
//     console.log(a);
//     return function a(){
//         console.log(a);
//     }
// }
// a = b()
// console.log(a);

//rajnish,nitin => error    vakil => 10  


// function foo() {
//     function bar() {
//         return 3

//         function bar() {
//             return 8;
//         }
//     }
//     return bar()
// }

// let x = foo()

// console.log(x);

//vakil => 8  undefined   nitin =>error  8     rajnish => 8 3     nihal=> error  8


// function main(){
//     let a = 20
//     update()
//     console.log(a);
//      function update(){
//         let a = 300
//         a = a
//         console.log(a);
//     }
//     update()
//     console.log(a);
// }

// main()

//vakil =>300 20 300 20 rajnish=>  300 20 300 20   nihal => 20 300 20     300 20 300 300      


// var x = 10
// y = 200
// console.log(y);
// console.log(x);
// // call()
// //console.log(x);
// if(true){
//     call()
//     console.log(x);
//     console.log(y);  
//     (()=>{
//         x= 25
//         console.log(y);  
//        console.log(x);
//     })()
//     var y = 50 
//     console.log(y);                                             
//     function call(){                                            
//         x = 20
//        console.log(x);
//     }
// }

// var y = 100
// console.log(y);
// call()
// console.log(x);

//vakil => 200 10 20 20 200 25 50 200 100 20     nihal => 200 10 20 20 200 200 25 50 100 20 20


// const y
// console.log(y);   //syntax error

// const x = 20
// function numbers(){
//     var num1 = 2
//     var num2 = 3
//     console.log(x);  //child pe pass parent ke lexical scope ka access hota hai
//     return num1+num2
// }

// //let x =numbers()
// numbers()
// console.log(x);

// //console.log(num1);  

 //oyo interview Front-End Developer
let x = 20
let y = 1000
function fun(){
    console.log(x);
    y = 30
    return function mun(){
        console.log(x)        //in case of let ,const temporal dead zone Reference error 
        var x = 1000
        console.log(x);                           //scope chaining & closures & hoisting
        y = 100
        return function tun(){
            console.log(x)
            var x = 500
            console.log(x);
            //console.log(z);
            y=900
            return function sun(){                   //20 ud 1000 ud 500 500 900                      //20 ud 1000 ud 500 500 ud 900 1000 1000 => vakil
                console.log(x);                                                                       //20 ud 1000 ud 500 500 ud 1000 7800  => nihal
                                                                                                      //1000  20  undefined  1000  undefined  500  500  900  7800 why 
             console.log(y);
                let z = 80
                y= 7800              
            }
        }
    }
}

console.log(y);  // 1000
fun()()()()     //mein toh yehi  chalunga
//console.log(z)                    //ud 1000 500      //20 ud ud 500
console.log(y);   //7800

// let i = fun()
// let c = i()
// let d = c()
// let f = d()
// console.log(f);
