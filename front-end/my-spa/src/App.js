import { Outlet } from "react-router-dom";
import Header from "./components/Header";

function App() {
  return (
    <div className="container">
      {/* <h2>Single page application</h2> */}
      <Header/>
      <Outlet />
    </div>
  );
}

export default App;
