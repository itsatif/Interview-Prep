//The Promise object represents the eventual completion (or failure) of an asynchronous operation and its resulting value.
//promise has three state pending,fullfilled & rejected.

const State ={

       pending :'pending',                 //PENDING, initial state when an operation is in progress

       fulfill : 'fulfill',                 //FULFILLED, define that the operation was successful                 

       rejected : 'rejected'              //REJECTED, denotes a failure in an operation
}

//settlement of promise is when is either successfull resolve or rejected.


//for creating our own promise we have to see the skeleton code of native promises
//i.e., It has a constructor function that takes callback, and methods like then,catch and finally
// A promise is executed as soon as it is created


function myPromise(callback) {
    this.state = State.pending;              //it can be either pending,fullfilled or rejected

    this.value = undefined;                // resolve or rejected value

    this.handlers = [];                   //it stores callbacks of then,catch,finally methods and it will only be executed when a promise is settled.(means either res/rej).

    //Invoke callback by passing the myresolve and my reject function
    try {
        callback(myResolve,myReject);
    } catch (err) {
        this = myReject(err);
    }

    let myResolve = msg=>{
        this = update(msg,State.fulfill);
    }

    let myReject = err => {
        this = update(err,State.rejected);
    }

    function update(msg,state){
        setTimeout(() => {


            /*
        Process the promise if it is still in pending state. 
        An already rejected or resolved promise is not processed
      */

        if(this.state !== State.pending) return;

        //is prmoise check
        if(isThenable(msg)){
            return msg.then(myResolve,myReject);
        }

        this.value = value;
        this.state = state;
        this.executeHandlers();
        }, 1000);
    }


    //A isThenable function checks if value is an instance of MyPromise or it is an object containing a then function.
    function isThenable(value){ 
        return value instanceof myPromise;
    }

    function isThenable(v){
        if(typeof v === "object" && value !== null && value.then && typeof value.then === "function"){
            return true;
        }
        return false;
    }


    //The essence of Promise chaining is that the then() method returns a new Promise object. 
    //That is how promises can be chained. 
    //This is specially useful in scenarios where we need to execute two or more asynchronous operations back to back, where each subsequent operation starts when the previous operation succeeds, with the result from the previous step.

    then(succes,fail){
        return new myPromise((res,rej)=>{
            this.addHandlers({
                succes: function(v){
                    if(!succes) return res(v);
                
                try {
                    return res(succes(v));
                } catch (err) {
                    return rej(err);
                }
                },
                fail: function(v) {
                    if(!fail){
                        return rej(v);
                    }
                    try {
                        return res(fail(v));
                    } catch (err) {
                        return rej(err);
                    }
                }
            })
        });
    }

    addHandlers(handlers){
        this.handlers.push(this.handlers);
        this.executeHandlers();
    }

    executeHandlers(){
        // Don't execute handlers if promise is not yet fulfilled or rejected
        if(this.state == State.pending) return null;
    }
   

    // We have multiple handlers because add them for .finally block too
    this.handlers.forEach(ele =>{
        if(this.state === State.fulfill){
            return this.handlers.succes(this.value);
        }
        return this.handlers.fail(this.value);
    });

    this.handlers = [];

    /*
        Since then method take the second function as onFail, 
        we can leverage it while implementing catch
    */
        function catch(onFail) {
            return this.then(null, onFail);
        }



          //The finally() method returns a Promise. When the promise is settled, i.e either fulfilled or rejected, the specified callback function is executed. This provides a way for code to be run whether the promise was fulfilled successfully or rejected once the Promise has been dealt with.
          //finally() method returns a Promise which will be settled with previous fulfilled or rejected value.

          

} 
    

