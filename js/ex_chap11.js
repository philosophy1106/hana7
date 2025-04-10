// cf. Object Method

globalThis.name = "GlobalName";
this.name = "ModuleName";

function f() {
  console.log("f.this = ", this.name);
}

f();


const self = this;
const af = () => {
  console.log("af.this=", this.name);
};
af();

const obj = {
  name: "ObjName",
  bark() {
    // good!(호출한 객체)
    console.log("bark=", this.name);
  },
  bark2: () =>
    // bad!! (this=전역/module)
    console.log("bark2=", this.name),
}; //~여기까지 heap에 들어가고 heap주소를 stack이 가지고 있다

obj.bark();
obj.bark2();
    const expressFn = function(name) {
        // if, 'use strict' ?
        this.name = name;
        console.log(this, new.target, this.name, name);
      }
      
      
      const arrowFn = (name) => {
       // this.name = name;
        console.log('-->', this, new.target, this.name, name);
      }
      
      expressFn('expfn');
      arrowFn('afn');
      
      //const dfn = new expressFn('D');
      //const afn = new arrowFn('A'); // error! 화살표 함수는 new로 부를 수 X

      const Dog = function(name) {
        console.log(this, new.target, 
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
      //Dog.bark(); //전역객체의 bark
      lucy.bark();
      lucy.bark2(); //화살표 함수 new target은 doggy? 

      console.log('dog type= ', typeof dog);
      console.log('licy type= ', typeof lucy);