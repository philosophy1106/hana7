import { ahhyunX } from "ahhyun";

interface IUser {
  id: number;
  age: number;
  name: string;
}

interface IDept {
  id: number;
  age: string;
  dname: string;
  captain: string;
}
const x = ahhyunX;

type Change<T, K extends keyof T, U> = {
  [k in K]: k extends K ? U : T[k];
};
type DeptCaptain = Change<IDept, "captain", IUser>;

//type Err = Change<IDept, "xxx", IUser>; // 존재하지 않는 키는 Error!!!

const Userr: DeptCaptain = {
  id: 234,
  age: "34",
  dname: "happy",
  captain: {
    id: 89,
    age: 13,
    name: "unhappy",
  },
};
console.log("🚀 ~ Userr:", Userr.captain);

console.log("----------------------------------------------------");

type Item = { item: string; price: number };
type ItemPrice<T, U> = {
  //[k in keyof T]: k extend
}

const stock = {X: 1, Y: 2, Z: 30};

const itemPrices: ItemPrice<Item, typeof stock>[] = [
  { item: 'X', price: 1000 },
  { item: 'Y', price: 2000 },
  { item: 'Z', price: 3000 },
  { item: 'P', price: 4000 }, // stock에 존재하지 않는 키는 Error!!!
];

const total = itemPrices.reduce((curr, itemPrice) => 
                  curr + stock[itemPrice.item] * itemPrice.price, 0);

console.log("----------------------------------------------------");

function deleteArray<T>(){
  arr: TUser[] | number[]
  return [];
}

const arr = [1, 2, 3, 4];
console.log(deleteArray(arr, 2)); // [1, 2]
console.log(deleteArray(arr, 1, 3)); // [1, 4]
console.log(arr); // [1, 2, 3, 4]

const users = [{ id: 1, name: 'Hong' }, { id: 2, name: 'Kim' }, { id: 3, name: 'Lee' }];

console.log(deleteArray(users, 2)); // [Hong, Kim]
console.log(deleteArray(users, 1, 2)); // [Hong, Lee]
console.log(deleteArray(users, 'id', 2)); // [Hong, Lee]
console.log(deleteArray(users, 'name', 'Lee')); // [Hong, Kim]
