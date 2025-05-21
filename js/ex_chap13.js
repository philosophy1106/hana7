class Animal {
  static ID = 1;
  constructor(name) {
    this.name = name;
  }
  feed() {}
}

class Dog extends Animal {
  #age = 0;
  constructor(name, age) {
    super(name);
    this.#age = age;
  }

  getAge() {
    return this.#age;
  }

  f() {
    return this.ID;
  }

  static sf() {
    return this.ID;
  }
}

//dog 상속받으면 한 뭉치로 바뀜

function wrapFullname(user) {
  return new Proxy(user, {
    get(target, prop) {
      if (prop === "fullname") {
        return `${user.first} ${user.lastName}`;
      } else return target[prop];
    },

    set(target, prop, value) {
      if (prop === "fullname") {
        [target.firstName, target.lastName] = value.split(" ");
      }
    },
  });
}
