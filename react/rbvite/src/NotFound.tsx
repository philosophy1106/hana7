import { useLocation, useNavigate } from "react-router-dom";

// src/NotFound.tsx
export const NotFound = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const { pathname } = location;
  const goPreviousPage = () => navigate(-1);
  const goHome = () => navigate("/", { state: { pathname } });
  return (
    <>
      <h2>404 NOT FOUND</h2>
      <div>{location.pathname}페이지를 찾을 수 없습니다!</div>
      <div style={{ marginTop: "1rem" }}>
        <button onClick={goHome} style={{ marginRight: "1rem" }}>
          Home으로 가기
        </button>
        | <button onClick={goPreviousPage}>이전 페이지로 가기기</button>
      </div>
    </>
  );
};
