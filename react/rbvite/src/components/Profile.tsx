import type { RefObject } from "react";
import type { LoginUser } from "../App";

type Props = {
  loginUser: LoginUser;
  logout: () => void;
  logoutButtonRef: RefObject<HTMLButtonElement | null>;
};

export default function Profile({ loginUser, logout, logoutButtonRef }: Props) {
  return (
    <>
      <h3>LoginUser: {loginUser?.name}</h3>
      <div>User Name {loginUser.name}</div>
      <button ref={logoutButtonRef} onClick={logout}>
        Logout
      </button>
    </>
  );
}
