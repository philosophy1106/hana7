console.log("number 3");

const randTime = (value) =>
  new Promise((resolve) => setTimeoutr(resolve, 1000 * Math.random(), value));

const promiseAll = (promises) =>
  new Promise((resolve, reject) => {
    const results = [];
    for (let i = 0; i < promises.length; i++) {
      promises[i]
        .then((res) => {
          results[i] = res;
          if (promises.length === results.length) resolve(results);
        })
        .catch(reject);
    }
  });

promiseAll([randTime(1), randTime(2), randTime(3)])
  .then((arr) => {
    console.table(arr);
    assert.deepStrictEqual(arr, [1, 2, 3]);
  })
  .catch(console.error);

promiseAll([randTime(11), Promise.reject("RRR"), randTime(33)])
  .then((array) => {
    console.log("여긴 과연 호출될까?!", array);
  })
  .catch((error) => {
    console.log("reject!!!!!!>>", error);
  });

//console.log("number 2");
// setTimeout(function () {
//   console.log("depth1", new Date());
//   setTimeout(function () {
//     console.log("depth2", new Date());
//     setTimeout(function () {
//       console.log("depth3", new Date());
//       throw new Error("Already 3-depth!!");
//     }, 3000);
//   }, 2000);
// }, 1000);

// console.log("START!", new Date());

// const depthTimer = (sec) => {
//   return new Promise((resolve) => setTimeout(resolve, sec * 1000), sec + 1);
// };

// depthTimer(1)
//   .then((res) => depthTimer(res))
//   .then(depthTimer)
//   .catch((err) => console.error("Error!!: ", err));

//console.log("number 1");

// const randTime = (val) =>
//   new Promise((resolve, reject) => {
//     setTimeout(resolve, Math.random() * 1000);
//   });

// randTime(100).then(console.log);

// [1, 2, 3, 4, 5].forEach((a) => randTime(a).then(console.log));
