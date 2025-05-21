import { useRef } from "react";
import My from "./components/My";
import Hello, { type HelloHandler } from "./components/Hello";
import "./App.css";
import SessionProvider from "./contexts/session/SessionProvider";
import Nav from "./Nav";
import { Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import Posts from "./components/Posts";
import { NotFound } from "./NotFound";
import ItemLayout from "./components/ItemLayout";
import ItemDetail from "./components/ItemDetail";
import ItemDetailLayout from "./components/ItemDetailLayout";
import ItemEdit from "./components/ItemEdit";
function App() {
  const helloButtonRef = useRef<HTMLButtonElement>(null);
  const logoutButtonRef = useRef<HTMLButtonElement>(null);
  const helloHandlerRef = useRef<HelloHandler>(null);

  return (
    <>
      <SessionProvider>
        <Nav />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route
            path="/my"
            element={<My logoutButtonRef={logoutButtonRef} />}
          />
          <Route
            path="/hello"
            element={
              <Hello
                id={1}
                helloButtonRef={helloButtonRef}
                refx={helloHandlerRef}
              />
            }
          />
          <Route path="/posts" element={<Posts />} />
          <Route path="/items" element={<ItemLayout />}>
            <Route path=":id" element={<ItemDetailLayout />}>
              <Route index element={<ItemDetail />} />
              <Route path="edit" element={<ItemEdit />} />
            </Route>
          </Route>
          <Route path="*" element={<NotFound />} />
        </Routes>
      </SessionProvider>
    </>
  ); //Login 에 만들기
}

export default App;
