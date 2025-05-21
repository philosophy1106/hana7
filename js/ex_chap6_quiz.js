//3.
const arr = [[{ id: 1 }], [{ id: 2 }, { id: 3 }]];
const [[{ id: id1 }], [{ id: id2 }, { id: id3 }]] = arr;

console.log(id1, id2, id3);
// 출력결과: 1 2 3

return;

//2. rest 연산자 사용'
const user1 = { id: 1, name: "Hong", passwd: "xxx", addr: "Seoul" };
const { addr, ...rest } = user1;
const userInfo = rest; //...rest가 연산자 아니고 ...이 연산자 rest -> userInfo로 변경하면 더 간단단
console.log(userInfo);

//1.

function f1({ id, name }) {
  console.log(id, name);
}

function f2(args) {
  console.log(args.id, args.name);
}

const user = { id: 1, name: "Hong", addr: { city: "Seoul" } };
const hong = { id: 1, name: "Hong" };
const lee = { id: 2, name: "Lee" };

f1(user);
f2({ id: 2, name: "Lee" });
