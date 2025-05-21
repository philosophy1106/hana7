//1970년 1월 1일과 1970년 1월 2일의 차이를 초로 나타내시오.
const d = new Date();
d.setTime(0);
console.log("🚀 ~ d:", d);

const time1 = d.getTime();
d.setDate(2); //날짜를 2로 바꿈
console.log("🚀 ~ d:", d, (d.getTime() - time1) / 1000);

const rand = (s, e) => s + Math.floor((e - s + 1) * Math.random());

//이 달의 날짜 5개를 무작위로 만들어 역순으로 정렬하시오.
const today = new Date();
today.setMonth(today.getMonth() + 1); //setDate(0)은 지난 날의 마지막 날짜니까 이번 달의 마지막 날짜를 구하려면 이번 달 + 1 하고, 지난 달의 마지막 날 구하면 댐
today.setDate(0);
const endOfDay = today.getDate();
console.log("🚀 ~ today:", today, endOfDay);

const days = [];
do {
  const r = rand(1, endOfDay);
  if (!days.includes(r)) days.push(r);
} while (days.length < 5);
console.log("🚀 ~ days:", days);

const yyyy = today.getFullYear();
const mm = (today.getMonth() + 1).toString().padStart(2, 0);

const rets = days
  .sort((a, b) => (a < b ? 1 : -1))
  .map((day) => `${yyyy} - ${mm} - ${day.toString().padStart(2, 0)}`);
console.log(rets);
//내년(2025년)의 오늘의 요일을 출력하시오.

const today1 = new Date();
today1.setFullYear(today1.getFullYear() + 1);
console.log("🚀 ~ today1:", today1);
console.log("Next Year >> ", "일월화수목금토"[today1.getDay()]); //유사배열임

//오늘로 부터 100일 후의 날짜는?
const today2 = new Date();
today2.setDate(today2.getDate() + 100);
console.log("🚀 ~ today2:", today2);
