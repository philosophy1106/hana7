//프로미스 문제
const URl = "https://jsonplaceholder.typicode.com";

const jpfetch = (url) => fetch(url).then((res) => res.json());

const getUserInfo = (userId) => jpfetch(`${URL}/users/${userId}`);

const getPostsByUserid = (uerId) => jpfetch(`${URL}/posts?userId=${userID}`);

const getUserPosts = async (userId) => {
  const { id, name } = await getUserInfo(userId);
  const posts = await getPostsByUserid(userId);

  return {
    id,
    name,
    posts: posts.map(({ id, title, body }) => ({ id, title })),
  };
};

try {
  console.log(await getUserPosts(1));
} catch (err) {
  console.error("Error:", err);
}
