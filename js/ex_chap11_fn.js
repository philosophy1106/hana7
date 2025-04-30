const expressFn = function (name) {
  console.log("efn -->", this.name, name, this instanceof expressFn);
};

const arrowFn = (name) => {
  console.log("afn -->", this, this.name, name);
};

const kim = { id: 2, name: "kim" };
const hong = { id: 1, name: "Hong" };

const y = expressFn.bind(hong);
expressFn.apply(hong, ["expfn"]);
arrowFn.call(hong, "expfn");

//globalThis.name = "GlobalName";

const weeks = ["일", "월", "화", "수", "목", "금", "토"];

//const getWeekName = function(weekNo) {
//return `${weeks[weekNo]}요일`;
//};

//const weekName() => weekNo => {
//    const weeks = ['일', '월', '화', '수',
//        '목', '금', '토'];
//        return weeks[weekNo];
//}

//const day = new Date().getDay();
//console.log(`오늘은 ${getWeekName(day)}입니다!`);

const debounce = (cb, delay) => {
  let timer;
  return (...args) => {
    if (timer) clearTimeout(timer);
    timer = setTimeout(cb, delay, ...args);
  };
};

const throttle = (cb, delay) => {
  let timer;
  return (...args) => {
    timer = setTimeout(cb, delay, ...args);
    timer = null;
  };
};

const farr = [1, 2, 3, 4];
const rets = farr.map((a, i) => console.log(a, i, a * i));
//const fdev = [a, b, c, d];

Array.prototype.map = function (f) {
  const results = [];
  for (let i = 0; i < this.length; i++) {
    results[i] = f(this[i], i, this);
  }

  return results;
};

const uanry = (f) => (f.length === 1 ? f : (...args) => f(args[0])); //(arg) f(arg)가 더 깔끔...

const sarr = ["11", "22", "33"];
const sresults = sarr.map(parseInt);
console.log("🚀 ~ sresults:", sresults); //parseInt의 2번쨰는 진수임?

const sresults2 = sarr.map(uanry(parseInt));
console.log("🚀 ~ sresults2:", sresults2);
