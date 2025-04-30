const dog = {
  name: "Maxx",
  showMyName() {
    console.log(`My name is ${this.name}.`);
  },
  whatsYourName() {
    //setTimeout(this.showMyName.bind(dog), 1000);
    setTimeout(() => {
      this.showMyName();
    }, 1000);
  },
};

dog.whatsYourName();

//f를 받아서 어떤 함수를 return
const once = (f) => {
  let done = false; //실행 여부 확인
  return (...args) => {
    if (done) return;
    done = true;
    return f(...args);
  };
};

const fn = once((x, y) => `금일 운행금지 차량은 끝번호 ${x}, ${y}입니다!`);
console.log(fn(1, 6)); // 금일 운행금지 차량은 끝번호 1, 6입니다!
console.log(fn(2, 7)); // undefined
console.log(fn(3, 8)); // undefined

function fivePart(x, y) {
  return `fivePart ${x}, ${y}, id: ${this.id}`;
}
const fnx = once(fivePart.bind({ id: 11 })); //this 처리 안 해서 bind
console.log(fn(1, 2));
const fn2 = once(fivePart);
console.log(fn2.bind({ id: 22 })(3, 4));

const onceAgain = (f, rebirthDelay) => {
  let done = false;
  return (...args) => {
    if (done) return;
    done = true;
    setTimeout(() => (done = false), rebirthDelay);

    return f(...args);
  };
};

const fn1sec = onceAgain(fivePart, 1000);
let cnt = 0;
//const cb = () => console.log(`${++cnt * 0.1}초`, fn1sec(++cnt, 0.1));
//setInterval(cb, 100);

//------------------------------------------------------------------
const before = () => console.log("before....");
const after = (result) => console.log("after...", result);

const someFn = (name, greeting) => `${greeting}, ${name}`;
const someFn2 = (id, nickname, email, level) =>
  `${id}/${nickname}/${email}/${level}`;

const template = (f) => {
  return (...args) => {
    before();
    const result = f(...args);
    setImmediate(() => after(result)); //setTimeout은 부탁함, setImmediate
    //setImmediate(after, result);
    return result;
  };
};

//const temp = template(someFn); // before → someFn → after 실행
//const temp2 = template(someFn2); // before → someFn2 → after 실행

//===================================================

//console.log("temp1>>", temp("sico", "hello"));
//console.log("temp2>>", temp2(1, "sico", "sico@gmail.com", 5));

//
//const weeks = ["일", "월", "화", "수", "목", "금", "토"];
//let widx = -1;
const getNextWeekBad = () => {
  widx += 1; // side-effect!
  if (widx >= weeks.length) widx = 0;
  return `${weeks[widx]}요일`;
};

const getNextWeek = (() => {
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];
  let widx = -1;
  return () => `${weeks[++widx]}요일`;
})();

let cntx = 0;
const intl = setInterval(() => {
  // widx += 2; // side-effect!
  console.log("call", cntx, getNextWeek());
  if ((cntx += 1) === 7) clearInterval(intl);
}, 100); //TODO: 1000으로 변경할 것,..
//FIXME:
