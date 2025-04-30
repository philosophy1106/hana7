console.log("3번 문제---------");
function shallowCopy(obj) {
  // return {...obj}; // 정답!!
  const ret = {};
  for (const [k, v] of Object.entries(obj)) {
    ret[k] = v;
  }
  return ret;
}

const kim = { nid: 3, nm: "Kim", addr: "Pusan" };
// const newKim1 = shallowCopy(kim);
// const newKim1 = Object.assign({}, kim); kim을 할당해줘.
const newKim1 = { ...kim }; //kim을 다 풀어줘... 메모리 주소만 다르고 내용 같음음
newKim1.addr = "Daegu";
console.log(kim.addr !== newKim1.addr); // true면 통과!

// 2) 이하 deep copy
const kim2 = {
  nid: 3,
  nm: "Kim",
  nil: null,
  addr: { city: "Pusan", road: "Haeundaero", zip: null, detail: { dong: 123 } },
};

function deepCopy(obj) {
  const ret = {};
  for (const [k, v] of Object.entries(obj)) {
    // ret[k] = v !== null && typeof v === 'object' ? { ...v } : v;
    if (v !== null && typeof v === "object") {
      ret[k] = deepCopy(v); //addr가 obj이니까... 재귀함수로 처리함
    } else {
      ret[k] = v;
    }
  }
  return ret;
}
const newKim2 = deepCopy(kim2);
newKim2.addr.city = "Daegu";
newKim2.addr.detail.dong = 999;
console.log(kim2.addr.city !== newKim2.addr.city); // true면 통과!
console.log(kim2, "vs", newKim2);

return;

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

//return;

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
Object.freeze(obj); //freexe 더이상 변경 불가
