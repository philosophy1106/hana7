class Animal {
  constructor(public name: string, public mouse: string = "x") {
    this.mouse = mouse;
  }

  feed(food: string) {
    this.mouse = food;
    console.log();
  }

  print() {
    console.log("My Name is", this.name);
  }
}

class Dog extends Animal {}
class Cat extends Animal {}

const maxx: Dog = new Dog("Maxx");
const navee: Cat = new Cat("Navee");

let animal: Animal = maxx;
animal.feed("banana");

animal = navee;
animal.feed("fish");
