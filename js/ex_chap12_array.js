const hong = { id: 1, name: "Hong" };
const kim = { id: 2, name: "Kim" };
const lee = { id: 3, name: "Lee" };
const park = { id: 4, name: "Park" };
const users = [hong, kim, lee, park];

const find3 = (a) => a.id === 3;
const idxId2 = users.findIndex(find3);

// Try this: id를 부여해서 실행하는 findId 함수를 작성하시오.
const findId = (pid) => (a) => a.id === pid; //return문 생략(한 줄이니까)
const idxId11 = users.findLastIndex(findId(2)); //findId(1)자리에는 함수가 들어가야 하니까 함수가 함수를 리턴하는 클로저가 들어가야 함함
console.log("🚀  idxId11:", idxId11);

const ids = users.map((a) => a.id); //원소 하나 받아서 원소의 id를 return
console.log("🚀 ~ ids:", ids);

Array.prototype.forEach = function (f) {
  for (let i = 0; i < this.length; i++) {
    f(this[i], i, this);
  }
};
Array.prototype.filter = function (f) {
  const results = [];
  for (let i = 0; i < this.length; i++) {}
};
Array.prototype.push = function (x) {
  return (this[this.length] = x);
};

Array.prototype.map = function (f) {
  const results = [];
  for (let i = 0; i < this.length; i++) {
    results[i] = f(this[i], i, this);
  }
};

Array.prototype.mapBy = function (k) {
  const results = [];
  for (let i = 0; i < this.length; i++) {
    results.push(this[i][k]);
  }
};

const ids2 = users.mapBy("id");
console.log("🚀 ~ ids2:", ids2);

const names = users.mapBy("name");
console.log("🚀 ~ names:", names);

const arr2 = [1, 2, 3, 4, 5];

const r1 = arr2.slice(1, 3);
console.log("🚀 ~ r1:", r1);

const r2 = arr2.slice(2);
console.log("🚀 ~ r2:", r2);

const r3 = arr2.splice(1, 3);
console.log("🚀 ~ arr2:", arr2);

const r4 = arr2.splice(1, 0, ...r3);
console.log("🚀 ~ r4 result arr2:", arr2);

const r5 = arr2.splice(2);
console.log("🚀 ~ r5 result arr2 :", arr2);

const r6 = arr2.splice(2, 0, ...r5);
console.log("🚀 ~ r6 result arr2:", arr2);

arr2.splice(2, Infinity, "x", "Y", "Z", 4, 5);
console.log("Q7: ", arr2);

arr2.splice(2, 3, 3);
arr2.splice(2, 1, "X", "Y", "Z");

const a8 = [...arr2.slice(0, 2), "X", "Y", "Z", ...arr2.slice(-2)];
