import { useState, type RefObject } from "react";
import type { Cart, Loginfn, Session } from "../App";
import Login, { type LoginHandler } from "./Login";
import Profile from "./Profile";
import Item from "./Item";

type Props = {
  session: Session;
  login: Loginfn;
  logout: () => void;
  removeItem: (id: number) => void;
  addItem: (name: string, price: number) => void;
  editItem: (item: Cart) => void;
  logoutButtonRef: RefObject<HTMLButtonElement | null>;
  loginHandlerRef: RefObject<LoginHandler | null>;
};

export default function My({
  //const addCartIem = () => {};
  session: { loginUser, cart },
  login,
  logout,
  removeItem,
  addItem,
  editItem,
  logoutButtonRef,
  loginHandlerRef,
}: Props) {
  const [isAdding, setAdding] = useState(false);
  const toggleAdding = () => setAdding(!isAdding);

  return (
    <>
      {loginUser ? (
        <Profile
          loginUser={loginUser}
          logout={logout}
          logoutButtonRef={logoutButtonRef}
        />
      ) : (
        <Login login={login} loginHandlerRef={loginHandlerRef} />
      )}
      <div>
        <ul>
          {cart.map((item) => (
            <li key={item.id}>
              <Item
                item={item}
                removeItem={removeItem}
                addItem={addItem}
                editItem={editItem}
              />
            </li>
          ))}

          {isAdding ? (
            <li>
              <Item
                item={{ id: 0, name: "", price: 3000 }}
                removeItem={removeItem}
                addItem={addItem}
                editItem={editItem}
                toggleAdding={toggleAdding}
              />
            </li>
          ) : (
            <button onClick={() => setAdding(true)}>ADD</button>
          )}
        </ul>
      </div>
    </>
  );
}
