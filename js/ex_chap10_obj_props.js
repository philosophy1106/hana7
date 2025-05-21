const { json } = require("stream/consumers");

const user = {
  "": 1,
  " ": 1, // 'id': 1, '0y': 2 모두 OK!
  123: 1, // user[123], user['123'] OK, but user.123 is SyntaxError!!
  12345n: 2, // user[12345], user[12345n], user['12345'] OK, but user['12345n'] is undefined!
  true: 1, // OK  user[true]  user.true
  id: 2,
  [`name`]: "Hong", // But, `name`: 'Hong'은 SyntaxError: Unexpected template string!
  [Symbol()]: "Hong", // OK But, Symbol(): 'Hong'은 SyntaxError: Unexpected token ':'
  [`${new Date()}`]: 365, // OK! 'Sun Jul …': 365
  "my-friends": ["Han", "Kim"],
  getInfo: () => `${this.id}-${this.name}`, // OK! But, this is not user!
  getInfo() {
    return `${this.id}-${this.name}`;
  }, // OK! getInfo의 최종 <f.o>
};

console.log("🚀 ~ user:", user, user.true);
const keys = Object.keys(user);
user.xxx = 123;
console.log("🚀 ~ keys:", keys, Reflect.ownKeys(user));

const k = "id";
const { [k]: kk } = user;
console.log("🚀 ~ kk:", kk);

const oth = user[123];
console.log("🚀 ~ oth:", oth, user["my-friends"], user[k]);

const a = {};
const b = { k: 1 }; //대괄호가 있기 때때문에 리터럴
const c = { k: 2 };

//a.b = 77;
a[b] = 77; //a['object Object'] = 77
a[c] = 99; //a['object Object'] = 99
console.log(a[b], a[c], a);

//a++ b ok a +++ b nO

//property 검사에는 연산자가 유리하다...?~

//const hasID = 'id' in user;
const hasID = user.hasOwnProperty("id");
console.log("🚀 ~ hasID:", hasID);

const entries1 = Object.entries(user);
console.log("🚀 ~ entries1:", entries1);

const entries2 = [];
for (let k of Object.keys(user)) {
  entries2.push([k, user[k]]);
}

//delete user.id;
//delete user[sym];

class Dog {
  id = 1;
  static x = 2;
}

const dogId = Dog.id;
console.log("🚀 ~ dogId:", dogId);
const dogX = Dog.x;
console.log("🚀 ~ dogX:", dogX);

const mass = new Dog(); //new 있어야 id 출력댐댐
console.log("🚀 ~ mass:", mass);

console.log("------------------------------");
const des = Object.getOwnPropertyDescriptors(user);
console.log("🚀 ~ des:", des);

user["123"] = 999; //바꿀 수 잇는지 -> oK
user.age = 33;
console.log("🚀 ~ age:", age);

const userJsonString = JSON.stringify(user, null, "  ");
console.log("🚀 ~ userJsonString:", userJsonString);

const userObj = JSON.parse(userJsonString);
console.log("🚀 ~ userObj:", userObj);

const str = '{"id": 1, "name": "Hong"}';
const p1 = JSON.parse(str, function (k, v) {
  console.log("kkkkkkkkk --> ", k, v);
  return typeof v === "number" ? v * 2 : v;
});
console.log("🚀 ~ p1 ~ p1:", p1);
let value = JSON.rawJSON("1234");
value = JSON.rawJSON('"str"');

if (JSON.isRawJson(value)) {
  const rj = value.rawJSON;
  console.log;
}

const svalue = JSON.stringify({ value });
console.log("🚀 ~ svalue:", svalue);
