const sampleUrl = "https://jsonplaceholder.typicode.com/users/1";
const myFetch = (url) => fetch(url).then((res) => res.json());
const res = myFetch(sampleUrl);

/*
// myFetch를 이용하는 코드
myFetch(sampleUrl).then((user) => {
  console.log("user>>>", user);
});
*/
//fetch(sampleUrl)

const myFetchAsync = async (url) => {
  const res = await fetch(url);
  const data = await res.json();
  console.log("🚀 ~ myFetchAsync ~ data:", data);
  return data;
};

const res2 = await myFetchAsync(sampleUrl);
console.log("🚀 ~ res2:", res2);
