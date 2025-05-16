import Login from "./Login";
import Profile from "./Profile";
import Item from "./Item";
import { memo, useMemo, useReducer, useState, type RefObject } from "react";
import { useSession } from "../contexts/session/SessionContext";
import ColorTitle from "./ColortTitle";
import { useDebounce } from "../hooks/useTimer";

type Props = {
  logoutButtonRef: RefObject<HTMLButtonElement | null>;
};

//type Post = { id: number; title: string };

//const POSTS_URL = "https://jsonplaceholder.typicode.com/posts?userId=1";

const MemoColorTitle = memo(
  ColorTitle,
  (preProp, newProp) => preProp.color === newProp.color
);

export default function My({ logoutButtonRef }: Props) {
  const {
    session: { loginUser, cart },
  } = useSession();

  // const [isAdding, toggleAdding] = useToggle();
  const [isAdding, toggleAdding] = useReducer((pre) => !pre, false);

  const totalPrice = useMemo(() => {
    return cart.reduce((acc, item) => acc + item.price, 0);
  }, [cart]);

  const [totalExpectPrice, addExpectPrice] = useReducer(
    (prePrice, newPrice) => totalPrice + newPrice + prePrice * 0,
    totalPrice
  );

  //--search
  const [searchstr, setSearchStr] = useState("");
  const [query, setQuery] = useState("");

  useDebounce(setQuery, 1000, [searchstr], searchstr); //searchstr이 바뀔 때마다

  /* const [posts, setPosts] = useState<Post[]>([]);
  const [error, setError] = useState(null);

  useEffect(() => {김상욱
    const controller = new AbortController();
    const { signal } = controller;
    fetch(POSTS_URL, { signal })
      .then((res) => res.json())
      .then(setPosts)
      .catch((err) => {
        console.log("🚀 err:", err);
        if (!signal.aborted) setError(err);
      });
    return () => controller.abort();
  }, []); */

  //search -> 검색어 받아서 몇 초? 지났을 때 검색하도록,,,?

  return (
    <>
      {loginUser ? <Profile logoutButtonRef={logoutButtonRef} /> : <Login />}
      <MemoColorTitle color={cart.length % 2 === 1 ? "blue" : "yellow"}>
        Title:{totalPrice.toLocaleString()}
      </MemoColorTitle>
      <h4>Expect: {totalExpectPrice.toLocaleString()}</h4>

      <div>
        search:{" "}
        <input
          type="text"
          id="search-str"
          onChange={(evt) => setSearchStr(evt.target.value)}
        />
        <ul>
          {cart
            .filter((item) => item.name.includes(query))
            .map((item) => (
              <li key={item.id}>
                <Item item={item} addExpectPrice={addExpectPrice} />
              </li>
            ))}

          {isAdding ? (
            <li>
              <Item
                item={{ id: 0, name: "", price: 3000 }}
                toggleAdding={toggleAdding}
                addExpectPrice={addExpectPrice}
              />
            </li>
          ) : (
            <button onClick={() => toggleAdding()}>ADD</button>
          )}
        </ul>
        <hr />
        {/*         <h3>{JSON.stringify(error)}</h3>
        <ul>
          {posts.map(({ id, title }) => (
            <li>
              {id}. <strong>{title}</strong>
            </li>
          ))}
        </ul> */}
      </div>
    </>
  );
}
