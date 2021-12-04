// 자바스크립트는 매우 유연함.
// 그래서 아래와 같은 구문을 추가할 것.
'use strict';
console.log("test");

// symbol, create unique identifiers for objects
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 == symbol2); 

const symbol3 = Symbol.for('id');
const symbol4 = Symbol.for('id');
console.log(symbol3 == symbol4);

// primitive : 바로 메모리에 할당됨
// object : 메모리를 가리키는 포인터가 지정됨

// 논리 연산시 주의점
// or : 앞에 true면 뒤에 연산을 안함
// why? 어차피 true 이기 때문에
// 그럼 무거운 연산일 수록 뒤에 배치하고
// 가벼운 연순은 앞에 배치한다.
// and : 뒤가 false 면 어차피 false 연산 안함

// 응용
// nullableObject && nullableObject.something
// 앞이 false가 아니라면 실행

const a = 5;
const b = '5';
// loose equality, 타입을 변환해서 평가
console.log(a == b);
// strict equality, type까지 고려함
console.log(a === b);

const t1 = {name:'hi'};
const t2 = {name:'hi'};
const t3 = t1
console.log(t1 == t2); // f
console.log(t1 === t2); // f
console.log(t1 === t3); // t
console.log(t1 == t3); // t

// Early return, early exit
function doSomething(user){
    if (user <= 10){
        return ;
    }
    // do something...
}

// function expression
const print = function asd() {
    console.log("wow")
};
print(); // 선언한 뒤에 사용

// 하지만 함수를 정의해서 사용하면
// 아무곳에서나 사용이 가능하다.

// Arrow function
const add = (a, b) => a + b;
const mul = (a, b) => {
    return a*b;
};

//IIFE : Immediately Invoked Function Expression
// 함수 선언과 동시에 실행하기
(function hello(){
    console.log("hi");
})();

class Person {
    constructor(name, age){
        this.age = age;
        this.name = name;
    }

    publicField = 2;
    #privateField = 10;

    speak() {
        console.log(`${this.name}`);
    }

    get age() {
        return this._age;
    }

    set age(value) {
        this._age = value;
    }
}

const tester = new Person('hi', 10);
tester.speak();

// static properties and methods
class Article {
    static publisher = 'js is shit';
    constructor(articleNumber) {
        this.articleNumber = articleNumber;
    }

    static print() {
        console.log(Article.publisher);
    }
}

const one = new Article(1);
const two = new Article(2);
// console.log(one.publisher); -> undefined
console.log(Article.publisher);
Article.print();

// 상속 extends, 오버라이딩은 그냥 똑같은 이름을 재정의하면 됨

const user = {name:'name'};
const user2 = user
// user는 reference가 할당되고 reference는 지정된 값을 가르킨다.
// user2 = user는 user의 reference가 user2에도 똑같이 할당됨. 즉, reference가 2개

//clone
const user3 = {}
Object.assign(user3, user);
// or
const user4 = Object.assign({}, user);

//1. obj to json
// 함수, js에만 쓰이는 타입은 json에 포함이 안됨.
let json = JSON.stringify(true);
console.log(json);

const rabbit = {
    name : 'js shit',
    size : null,
    date : new Date(),
};
json = JSON.stringify(rabbit);
console.log(json);

//2. json to obj
let obj = JSON.parse(json, (key, value) => {
    return key === 'date' ? new Date(value) : value;
});
console.log(obj.date.getDate());

// sync, aysnc
// 모든 함수, 변수는 호이스팅이 된다.
// 1,3,2
console.log('1');
setTimeout(() => {
    console.log('2');
}, 1000);
console.log('3');

// sync
function Immediately(print) {
    print();
}
Immediately(() => console.log('is js shit?'));

//callback hell
// class UserStorage {
//     loginUser(id, password, onSuccess, onError) {
//         setTimeout(()=>{
//             if(
//                 (id === 'one' && password === '1') ||
//                 (id === 'two' && password === '2')
//             ) {
//                 onSuccess(id);
//             } else {
//                 onError(new Error('not found'));
//             }
//         }, 2000);
//     }

//     getRoles(user, onSuccess, onError) {
//         setTimeout( () => {
//             if (user == 'one') {
//                 onSuccess({name: 'one', role: 'admin'})
//             } else {
//                 onError(new Error('no access'));
//             }
//         }, 1000);
//     }
// }

// const userStroage = new UserStorage();
// const id  = prompt('Enter id');
// const password = prompt('Enter pwd');
// userStroage.loginUser(
//     id, 
//     password, 
//     user => {
//         userStroage.getRoles(
//             user, 
//             userWithRoles => {
//                 alert(`hello ${userWithRoles.name}, ${userWithRoles.role}`);
//             },
//             error => {
//                 console.log(error);
//             }
//         );
//     }, 
//     error => {
//         console.log(error);
//     }
// );

// promise : obj for async
// when new Promise is created, the executor runs automatically.
const promise = new Promise((reslove, reject) =>{
    console.log('doing something');
    setTimeout(()=>{
        reslove('lol');
        //reject(new Error('no network'));
    }, 2000);
});

promise
    .then((value) => {
        console.log(value);
    })
    .catch(error => {
        console.log(error);
    })
    .finally(() => {
        console.log('finally');
    }
);

const fetchNumber = new Promise((resolve, reject) => {
    setTimeout( ()=> resolve(1), 1000);
});

fetchNumber
    .then(num => num * 2)
    .then(num => num * 3)
    .then(num => {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(num - 1), 1000);
        });
    })
    .then(num => console.log(num))
    .catch(error => console.log(error));

class UserStorage2 {
    loginUser(id, password, onSuccess, onError) {
        return new Promise((resolve, reject) => {
            setTimeout(()=>{
                if(
                    (id === 'one' && password === '1') ||
                    (id === 'two' && password === '2')
                ) {
                    resolve(id);
                } else {
                    reject(new Error('not found'));
                }
            }, 2000); 
        });
    }

    getRoles(user) {
        return new Promise((resolve, reject) => {
            setTimeout( () => {
                if (user === 'one') {
                    resolve({name:'one', role: 'admin'});
                } else {
                    reject(new Error('no access'));
                }
            }, 1000);
        });   
    }
}

const us = new UserStorage2();
const id = prompt('enter ur name');
const password = prompt('enter ur password');
us.loginUser(id, password)
.then(us.getRoles)
.then(user => alert(`what? ${user.name} is ${user.role}`))
.catch(err => console.log(err));

// async, await

// async
function fetchUsr() {
    // do network request... so slow
    return new Promise((resolve, reject) => {

        resolve('one');
    } );
}

async function fetchU() {
    return 'two';
}

const u = fetchU();
u.then(console.log);
console.log(u);