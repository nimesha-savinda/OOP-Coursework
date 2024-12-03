import React from "react";
import { useContext } from "react";
import { DataContext } from "./Layouts/DataContext";

function Navigation(props) {
  const { sharedData, setSharedData } = useContext(DataContext);

  return (
    <nav className="flex items-center  justify-between py-8 px-16">
      <div className="flex items-center gap-x-16">
      <p>Hi, {sharedData.role}</p>
      </div>
      <div className="flex items-center gap-x-16">
        <a className="font-semibold text-3xl" to="/">
          Online Booking
        </a>
      </div>
      <div className="flex items-center gap-x-8">
        <div>
          <button>Log out</button>
        </div>
        
      </div>
    </nav>
  );
}

export default Navigation;


const props = {
    name: "Manupa",
}