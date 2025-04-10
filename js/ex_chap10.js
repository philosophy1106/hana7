console.log("3번 문제---------");

console.log("2번 문제 -----------");
data = [
  ["A", 10, 20],
  ["B", 30, 40],
  ["C", 50, 60, 70],
];

function makeObjectFromArray(arrdata) {
  const retObj = {};
  for (const [k, ...v] of arrdata) {
    retObj[k] = v;
    //retObj = {...retObj, [k]: v}; front-end
  }
  return retObj;
}

function makeArrayFromObject(objdata) {
  const retArr = [];
  for (const x of Object.entries(objdata)) {
    console.log("🚀 ~ makeArrayFromObject ~ x:", x);
    retArr.pop = retArr[(k, v)] = [...retArr, [k, ...v]];
  }
  return retArr;
}
console.log(makeObjectFromArray(data));

return;

console.log("1번 문제 -----------");
const arr = [100, 200, 300, 400, 500, 600, 700];
console.log("1-1: for-in 배열의 인덱스");
for (const k in arr) {
  console.log(k);
}
console.log("1-2: for-in 배열의 원소");
for (const k in arr) {
  console.log(arr[k]);
}

const obj = { name: "Kim", addr: "Yongsan", level: 1, role: 9, receive: false };
console.log("1-3. for-in 프로퍼티 이름");
for (const k in obj) {
  console.log(k);
}
console.log("1-4. for-in 프로퍼티 값: ");
for (const k in obj) {
  console.log(obj[k]);
}
console.log("1-5.for-of 프로퍼티 값 ");
for (const k of Object.values(obj)) {
  console.log(k);
}
console.log("1-6.level 프로퍼티가 열거(entries)되지 않도록");
Object.defineProperty(obj, "level", { enumerable: false });
console.log(Object.values(obj));

console.log("1-7.role 프로퍼티를 읽기 전용으로");
Object.defineProperty(obj, "role", { writable: false });
//Object.freeze? ummm...
obj["role"] = 8;
console.log("🚀 ~ role:", obj["role"]);
