import { useRef } from "react";
import My from "./components/My";
import Hello, { type HelloHandler } from "./components/Hello";
import "./App.css";
import { useCounter } from "./contexts/counter/useCounter";
import SessionProvider from "./contexts/session/SessionProvider";

function App() {
  //const [editMode, setEditMode] = useState(0); 수정 할지 말지 결정정
  //const[count, setCount] = useState(0);
  //const {count} = useCounter();
  //const {count} = useContext(CounterContext);
  const { count } = useCounter();
  const helloButtonRef = useRef<HTMLButtonElement>(null);
  const logoutButtonRef = useRef<HTMLButtonElement>(null);
  const helloHandlerRef = useRef<HelloHandler>(null);

  return (
    <>
      <h2>count: {count}</h2>
      <SessionProvider>
        <My logoutButtonRef={logoutButtonRef} />
      </SessionProvider>
      <Hello
        id={count + 1}
        helloButtonRef={helloButtonRef}
        refx={helloHandlerRef}
      >
        반갑습니다!
      </Hello>
      <button onClick={() => helloButtonRef.current?.click()}>
        Click Hello
      </button>
      <button onClick={() => logoutButtonRef.current?.click()}>
        Logout in App
      </button>
      <button onClick={() => console.log(helloHandlerRef.current?.xx)}>
        Say Hello
      </button>
      <button>Login</button>
    </>
  ); //Login 에 만들기
}

export default App;
