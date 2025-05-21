import { deepStrictEqual, strictEqual } from "assert";

//ex1) 배열의 각 원소를 String으로 변환하시오.
const arr = [1, 2, 3, true];
arr.push(true);

const ret1 = arr.map(String); // String(n)
deepStrictEqual(ret1, ["1", "2", "3", "true"]);
// ex2) 다음과 같이 작동하는 classNames 함수를 작성하시오.
const classNames = (...args) => args.filter(Boolean).join(" ");
const ret2 = classNames("", "a b c", "d", "", "e");
strictEqual(ret2, "a b c d e");

//아래 users 배열에 대하여 추가/수정/삭제하는 순수 함수를 작성하시오.

/*
// function push(array, …args) {}
function push(array, ...args) {
  return [...array, ...args];
}

const pop = (array, count) => (count ? array.slice(-count) : array.at(-1));
const unshift = (array, ...args) => [...args, ...array];
const shift = (array, count = 1) => [array.slice(0, count), array.slice(count)];

const arr = [1, 2, 3, 4];
deepStrictEqual(push(arr, 5, 6), [1, 2, 3, 4, 5, 6]);
deepStrictEqual(pop(arr), 4);
deepStrictEqual(pop(arr, 2), [3, 4]); // 2개 팝!
deepStrictEqual(unshift(arr, 0), [0, 1, 2, 3, 4]);
deepStrictEqual(unshift(arr, 7, 8), [7, 8, 1, 2, 3, 4]);
deepStrictEqual(shift(arr), [[1], [2, 3, 4]]); // [shift되는 원소들, 남은 원소들]
deepStrictEqual(shift(arr, 2), [
  [1, 2],
  [3, 4],
]); // 2개 shift
deepStrictEqual(arr, [1, 2, 3, 4]);

const deleteArray = (array, start0rKey, endOrValue) => {
  if (typeof start0rKey === "string") {
    return array.filter((a) => a[start0rKey] !== endOrValue);
  } else {
    return array.filter((_, i) => i < start0rKey || i >= endOrValue);
  }
};

deepStrictEqual(deleteArray(arr, 2), [1, 2]); // 2부터 끝까지 지우고 나머지 리턴
deepStrictEqual(deleteArray(arr, 1, 3), [1, 4]); // 1부터 3미만까지 지우고 나머지 리턴
deepStrictEqual(arr, [1, 2, 3, 4]);

const Hong = { id: 1, name: "Hong" };
const Kim = { id: 2, name: "Kim" };
const Lee = { id: 3, name: "Lee" };
const users = [Hong, Kim, Lee];

deepStrictEqual(deleteArray(users, 2), [Hong, Kim]);
deepStrictEqual(deleteArray(users, 1, 2), [Hong, Lee]);
deepStrictEqual(deleteArray(users, "id", 2), [Hong, Lee]);
deepStrictEqual(deleteArray(users, "name", "Lee"), [Hong, Kim]);

//나머지 문제는 과제
*/
