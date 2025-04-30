type S = string; // alias

const myName = "Sico";
let age;
age = 33;
// console.blub(age);

let lastName: string | boolean = "King";
lastName = true;

age = "100";
console.log(`Hello, ${myName} ${age}!`);

// type Name = string;
type Name = "Hong" | "Kim" | "Lee";
let nm: Name = "Hong";
if (nm === "Hong") nm = "Kim";

type SomeType = {
  id: string | number;
  name: Name;
  age: 33 | 44 | 55;
  address: string;
};

const something = ({ id, name, age, address }: SomeType) => {
  // Do something...
  console.log(id, name, age, address);
};

const user: SomeType = { id: 1, name: "Hong", age: 33, address: "Seoul" };
something(user);

let x: string | undefined = Math.random() > 0.5 ? "str" : undefined;
console.log("🚀 x:", x?.length);

let y: string | number | undefined = x;
let z: string;

if (x) z = x;
if (typeof x === "string") z = x;

type Member = {
  name: string;
  addr: string;
  discountRate: number;
  kind: "M";
};
type Guest = {
  name: string;
  age: number;
  kind: "G";
};

type Customer = Member | Guest;
type MemberGuest = Member | Guest;

let cust: Member | Guest;

let m: {
  name: string;
  addr: string;
  discountRate: number;
};
let g: {
  name: string;
  age: number;
};
let mg: Member | Guest;

cust = {
  name: "홍길동",
  addr: "용산구",
  discountRate: 0.1,
  kind: "M",
};

if (cust instanceof Object) cust = { name: "", age: 0, kind: "G" };

mg = cust;

cust = {
  name: "",
  age: 33,
  kind: "G",
};

cust = {
  name: "홍길동",
  addr: "용산구",
  discountRate: 0.1,
  // age: 26,
  kind: "M",
};
mg = cust;

// cust = { name: '', age: 8 };
// console.log('🚀 cust:', cust);

if ("addr" in cust) m = cust;

// if ('age' in cust) g = cust;
// if (cust.kind === 'G') g = cust;

cust = {
  name: "홍길동",
  // addr: '용산구',
  age: 55,
  kind: "G",
};

let arr: number[];
let xarr = Math.random() > 0.5 ? "x" : [123];
// xarr = Math.random() > 0.5 ? [1, 2, 3] : 123;

// if (Array.isArray(xarr) && typeof xarr[0] === 'number') arr = xarr;
if (Array.isArray(xarr)) arr = xarr;

let gildong = Math.random() > 0.5 && "HongGilDong";
gildong = "";
if (gildong) {
  gildong.toUpperCase(); // string
} else {
  gildong; // false | string
}
