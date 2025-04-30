globalThis.name = 'GlobalName';
this.name = 'ModuleName';

function f() {
  console.log('f.this=', this.name);
}
f();

const self = this;
const af = () => {
  console.log('af.this=', self.name, this.name, globalThis.name);
};
af();

const obj = {
  name: 'ObjName',
  bark() {
    // good!(호출한 객체)
    console.log('bark=', this.name);
  },
  bark2: () =>
    // bad!! ==> this=전역(browser)/module(node)
    console.log('bark2=', this.name),
};

obj.bark();
obj.bark2();

const expressFn = function(name) {
  'use strict';
  // if(this?.name)
  // this.name = name;
  console.log(new.target, this.name, name, this instanceof expressFn);
}

const arrowFn = (name) => {
  this.name = name;
  console.log('-->', this, new.target, this.name, name);
}

// expressFn('expfn');
expressFn.bind({})('expfn');
arrowFn('afn');

// class Dog {
//   constructor(nm) {
//     console.log('🚀 nm:', nm)
//   }
// }

// const maxx = new Dog('Maxx');

const dfn = new expressFn('D');
console.log('🚀 dfn:', Object.getPrototypeOf(dfn));
// const afn = new arrowFn('A'); // error!

console.log('-------------------------------')
const Dog = function(name) {
  console.log(name, '==>', this.name, new.target, 
              this instanceof Dog);
  this.name = name;
  this.bark = function () {
    console.log('bark=', new.target, this.name, name);
  };
  this.bark2 = () =>
    console.log('bark2=', new.target, this.name, name);
}

const dog = Dog('Doggy');
const lucy = new Dog('Lucy');
// Dog.bark(); // ?
lucy.bark(); // ?
lucy.bark2(); // ?
console.log('dog type=', typeof dog); // ?
console.log('lucy type=', typeof lucy); // ?