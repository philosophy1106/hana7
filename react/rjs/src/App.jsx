import { useState, version } from "react";
import "./App.css";

/*

function useState(initValue) {
  let _x = initValue;
  const obj = {
    get x() {
      return _x;
    },

    setX(newValueOrFn) {
      if (typeof newValueOrFn === "function") _x = newValueOrFn(_x);
      else _x = newValueOrFn;
    },
  };
  return [obj.x, obj.setX];
}
  */
//      {MyButton({onClick: () => setIsLoggedIn(!isLoggedIn)})}
const hong = { name: "Hong", hobbies: ["Bike", "Tennis"] };

const AboutMe = ({ myinfo }) => {
  const { name, hobbies } = myinfo;
  return (
    <>
      <h2>{name}</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {hobbies.map((hobby) => (
          <li key={hobby}>{hobby}</li>
        ))}
      </ul>
    </>
  );
};

function MyButton({ onClick }) {
  return <button onClick={onClick}>MyButton</button>;
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  return (
    <div className="flex felx-col justify-center items-center mt-5">
      <h1>Vite React{version}</h1>
      <MyButton
        onClick={() => setIsLoggedIn(!isLoggedIn)}
        className="bg-blue-300 text-white px-6 py-4 rounded hover: bg-blue-500 mb-56"
      />
      {isLoggedIn ? <AboutMe myinfo={hong} /> : <h3>Login Form</h3>}
    </div>
  );
}

export default App;
