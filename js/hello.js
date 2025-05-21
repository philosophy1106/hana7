console.log("Hello, JavaScript!");

const myName = "Ahhyun";

function printName(nm) {
  console.log(1, nm);

  //const myName = "Hanaro";
  if (true) {
    var myName = "True";
    console.log(22, myName);
  }
  console.log(2, myName, typeof myName);
}

printName(myName);
console.log(3, myName);

//함수 안에 없으면 밖에서 찾음 전역 스코프, 함수 스코프
//var는 함수 스코프라서 함수가 끝날 때까지 살아 있음 const는 블록 스코프프

console.log("------------------------------------");
