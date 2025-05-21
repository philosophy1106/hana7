//예시1. 할인 금액 구하기기

const DC_RATE = 0.5;
function discount() {
  const dcRate = 0.5;
  return function (price) {
    return price * dcRate;
  };
}

const discount2 = () => (price) => price * DC_RATE;
//const button = (mode) => () =>

//curring

const MENU = { chinese: ["a", "b"], italian: ["p", "s"] };

function restaurant(kind) {
  const menu = MENU[kind];
  return function (menuIndex) {
    return menu[menuIndex]; // menu['chinese']
  };
}

const lunch = restaurant("chinese");
console.log(lunch(1));

//예시2.출입자 수를 게이트 별로 구하는 함수를 작성하세요.

function getCounter() {
  let currCount = 0;
  return {
    plus() {
      currCount += 1;
    },
    minus() {
      currCount -= 1;
    },
    get count() {
      //count: () => currCount,
      return currCount;
    },
  };
}

const gate1 = getCounter();
const gate2 = getCounter();

gate1.plus();
gate2.plus();
gate2.minus();

console.log("gate1>> ", gate1.count);
console.log("gate2>> ", gate2.count);

//예시 3. 팩토리얼
function factorial(n) {
  if (n === 1) return 1;
  return n * factorial(n - 1);
}

const f3 = factorial(3);
console.log("🚀 ~ f3:", f3);

function factorialTCO(n, acc) {
  if (n === 1) return 1;
  return factorialTCO(n - 1, acc * n);
}
const ftco3 = factorialTCO(5);
